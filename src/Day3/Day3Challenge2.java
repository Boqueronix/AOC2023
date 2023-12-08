package Day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day3Challenge2 {
    public record OrderedTriple(int beginningIndex, int endIndex, int height) {
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: ");
        HashMap<OrderedTriple, Integer> numbers = new HashMap<>();
        HashMap<OrderedTriple, Character> symbols = new HashMap<>();
        String input = scanner.nextLine();
        int count = 0;
        while (!input.isEmpty()){
            ArrayList<Integer> digits = new ArrayList<>();
            for (int i = 0; i <= input.length(); i++) {
                try {
                    digits.add(Integer.parseInt(input.substring(i, i + 1)));
                } catch (Exception e) {
                    if (!digits.isEmpty()){
                        int number = 0;
                        for (int j = 0; j < digits.size(); j++) {
                            number += (int) (digits.get(j) * Math.pow(10, digits.size() - j - 1));
                        }
                        numbers.put(new OrderedTriple(i - digits.size(), i - 1, count), number);
                        digits.clear();
                    }
                    if (i < input.length() && input.charAt(i) != '.' && input.charAt(i) != ' ' && input.charAt(i) != '\n'){
                        symbols.put(new OrderedTriple(i, i, count), input.charAt(i));
                    }
                }
            }
            input = scanner.nextLine();
            count++;
        }
        ArrayList<Integer> toSum = new ArrayList<>();
        for (OrderedTriple symbolKey: symbols.keySet()) {
            if (symbols.get(symbolKey) == '*') {
                ArrayList<Integer> toMultiply = new ArrayList<>();
                for (OrderedTriple numberKey : numbers.keySet()) {
                    if (Math.abs(symbolKey.height() - numberKey.height()) <= 1){
                        if (symbolKey.beginningIndex() >= numberKey.beginningIndex() - 1 && symbolKey.endIndex() <= numberKey.endIndex() + 1){
                            toMultiply.add(numbers.get(numberKey));
                        }
                    }
                }
                if (toMultiply.size() == 2){
                    toSum.add(toMultiply.get(0) * toMultiply.get(1));
                }
            }
        }
        int sum = 0;
        for (Integer integer : toSum) {
            sum += integer;
        }
        System.out.println("Sum: " + sum);
    }
}