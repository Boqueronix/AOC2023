package Day9;

import java.util.ArrayList;
import java.util.Scanner;

public class Day9Challenge2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> firstNumbers = new ArrayList<>();
        System.out.println("Enter: ");
        String input = scanner.nextLine();
        while (!input.isEmpty()){
            String[] numbers = input.split(" ");
            ArrayList<Integer> numbersList = new ArrayList<>();
            for (String number : numbers) {
                numbersList.add(Integer.parseInt(number));
            }
            firstNumbers.add(predictPrev(numbersList));
            input = scanner.nextLine();
        }
        int sum = 0;
        for (Integer firstNumber : firstNumbers) {
            sum += firstNumber;
        }
        System.out.println("Sum: " + sum);
    }

    private static int predictPrev(ArrayList<Integer> numbersList) {
        if (allSame(numbersList)) {
            return numbersList.get(0);
        }
        ArrayList<Integer> differences = new ArrayList<>(numbersList.size() - 1);
        for (int i = 0; i < numbersList.size() - 1; i++) {
            differences.add(numbersList.get(i + 1) - numbersList.get(i));
        }
        return numbersList.get(0) - predictPrev(differences);
    }

    private static boolean allSame(ArrayList<Integer> numbersList) {
        int lastNumber = numbersList.get(0);
        for (int i = 1; i < numbersList.size(); i++) {
            if (numbersList.get(i) != lastNumber) {
                return false;
            }
        }
        return true;
    }
}
