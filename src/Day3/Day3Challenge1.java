package Day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day3Challenge1 {
    public record OrderedTriple(int beginningIndex, int endIndex, int height) {
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: ");
        HashMap<OrderedTriple, Integer> inputs = new HashMap<>();
        ArrayList<OrderedTriple> symbols = new ArrayList<>();
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
                        inputs.put(new OrderedTriple(i - digits.size(), i - 1, count), number);
                        digits.clear();
                    }
                    if (i < input.length() && input.charAt(i) != '.' && input.charAt(i) != ' ' && input.charAt(i) != '\n'){
                        symbols.add(new OrderedTriple(i, i, count));
                    }
                }
            }
            input = scanner.nextLine();
            count++;
        }
        ArrayList<Integer> toSum = new ArrayList<>();
        for (OrderedTriple limit: inputs.keySet()) {
            for (OrderedTriple symbol: symbols) {
                if (Math.abs(symbol.height() - limit.height()) <= 1){
                    if (symbol.beginningIndex() >= limit.beginningIndex() - 1 && symbol.endIndex() <= limit.endIndex() + 1){
                        toSum.add(inputs.get(limit));
                        break;
                    }
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