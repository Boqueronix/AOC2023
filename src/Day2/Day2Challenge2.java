package Day2;

import java.util.ArrayList;
import java.util.Scanner;

public class Day2Challenge2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        System.out.println("Enter: ");
        String input = scanner.nextLine();
        while (!input.isEmpty()) {
            String[] split = input.split(":");
            split[1] = split[1].replace(";", ",");
            String[] rgb = split[1].split(",");
            boolean valid = true;
            int r = 0;
            int g = 0;
            int b = 0;
            for (String s : rgb) {
                if (s.contains("red")) {
                    if (Integer.parseInt(s.substring(1, s.length() - 4)) > r) {
                        r = Integer.parseInt(s.substring(1, s.length() - 4));
                    }
                } else if (s.contains("green")) {
                    if (Integer.parseInt(s.substring(1, s.length() - 6)) > g) {
                        g = Integer.parseInt(s.substring(1, s.length() - 6));
                    }
                } else if (s.contains("blue")) {
                    if (Integer.parseInt(s.substring(1, s.length() - 5)) > b) {
                        b = Integer.parseInt(s.substring(1, s.length() - 5));
                    }
                }
            }
            inputs.add(r*g*b);
            input = scanner.nextLine();
        }
        int sum = 0;
        for (Integer integer : inputs) {
            sum += integer;
        }
        System.out.println("Sum: " + sum);
    }
}
