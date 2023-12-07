package Day1;

import java.util.ArrayList;
import java.util.Scanner;

public class Day1Challenge2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        System.out.println("Enter: ");
        String input = scanner.nextLine();
        while (!input.isEmpty()) {
            ArrayList<Integer> digits = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                if (input.startsWith("one", i)) {
                    digits.add(1);
                } else if (input.startsWith("two", i)) {
                    digits.add(2);
                } else if (input.startsWith("three", i)) {
                    digits.add(3);
                } else if (input.startsWith("four", i)) {
                    digits.add(4);
                } else if (input.startsWith("five", i)) {
                    digits.add(5);
                } else if (input.startsWith("six", i)) {
                    digits.add(6);
                } else if (input.startsWith("seven", i)) {
                    digits.add(7);
                } else if (input.startsWith("eight", i)) {
                    digits.add(8);
                } else if (input.startsWith("nine", i)) {
                    digits.add(9);
                } else {
                    try {
                        digits.add(Integer.parseInt(input.substring(i, i + 1)));
                    } catch (NumberFormatException ignored) {}
                }
            }
            inputs.add(digits.get(0)*10 + digits.get(digits.size()-1));
            input = scanner.nextLine();
        }
        int sum = 0;
        System.out.println("Summing: ");
        for (Integer integer : inputs) {
            System.out.println(integer);
            sum += integer;
        }
        System.out.println("Sum: ");
        System.out.println(sum);
    }
}