package Day2;

import java.util.ArrayList;
import java.util.Scanner;

public class Day2Challenge1 {
    private static final int R_MAX = 12;
    private static final int G_MAX = 13;
    private static final int B_MAX = 14;
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
            for (String s : rgb) {
                if (s.contains("red")) {
                    if (Integer.parseInt(s.substring(1, s.length() - 4)) > R_MAX) {
                        valid = false;
                        break;
                    }
                } else if (s.contains("green")) {
                    if (Integer.parseInt(s.substring(1, s.length() - 6)) > G_MAX) {
                        valid = false;
                        break;
                    }
                } else if (s.contains("blue")) {
                    if (Integer.parseInt(s.substring(1, s.length() - 5)) > B_MAX) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                inputs.add(Integer.parseInt(split[0].substring(5)));
            }
            input = scanner.nextLine();
        }
        int sum = 0;
        for (Integer integer : inputs) {
            sum += integer;
        }
        System.out.println("Sum: " + sum);
    }
}
