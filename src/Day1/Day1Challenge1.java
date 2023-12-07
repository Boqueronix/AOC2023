package Day1;

import java.util.ArrayList;
import java.util.Scanner;

public class Day1Challenge1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        System.out.println("Enter: ");
        String input = scanner.nextLine();
        while (!input.isEmpty()) {
            ArrayList<Integer> digits = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                try {
                    digits.add(Integer.parseInt(input.substring(i, i + 1)));
                    System.out.println(input.charAt(i));
                } catch (NumberFormatException ignored) {}
            }
            inputs.add(digits.get(0)*10 + digits.get(digits.size()-1));
            input = scanner.nextLine();
        }
        int sum = 0;
        System.out.println("Summing: ");
        for (int i = 0; i < inputs.size(); i++) {
            System.out.println(inputs.get(i));
            sum += inputs.get(i);
        }
        System.out.println("Sum: ");
        System.out.println(sum);
    }
}