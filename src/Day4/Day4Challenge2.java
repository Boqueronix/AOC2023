package Day4;

import java.util.ArrayList;
import java.util.Scanner;

public class Day4Challenge2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: ");
        String input = scanner.nextLine();
        ArrayList<Integer> pointsPerCard = new ArrayList<>();
        while (!input.isEmpty()){
            int points = getPoints(input);
            pointsPerCard.add(points);
            input = scanner.nextLine();
        }
        ArrayList<Integer> copiesPerCard = getIntegers(pointsPerCard);
        System.out.println();
        int sum = 0;
        for (Integer integer : copiesPerCard) {
            System.out.println(integer);
            sum += integer;
        }
        System.out.println("Sum: " + sum);
    }

    private static ArrayList<Integer> getIntegers(ArrayList<Integer> pointsPerCard) {
        ArrayList<Integer> copiesPerCard = new ArrayList<>(pointsPerCard.size());
        for (int i = 0; i < pointsPerCard.size(); i++) {
            copiesPerCard.add(1);
        }
        for (int i = 0; i < copiesPerCard.size(); i++) {
            for (int j = 0; j < copiesPerCard.get(i); j++) {
                for (int k = i; k <  i + pointsPerCard.get(i); k++) {
                    try {
                        copiesPerCard.set(k + 1, copiesPerCard.get(k + 1) + 1);
                    } catch (Exception ignored) {}
                }
            }
        }
        return copiesPerCard;
    }

    private static int getPoints(String input) {
        int points = 0;
        String[] card = input.split(":");
        String[] cardList = card[1].split("\\|");
        String[] winningList = cardList[0].split(" ");
        ArrayList<Integer> winners = new ArrayList<>(winningList.length);
        for (int i = 0; i < winningList.length; i++) {
            if (!winningList[i].isEmpty()) {
                winners.add(Integer.parseInt(winningList[i]));
            }
        }
        String[] yourList = cardList[1].split(" ");
        ArrayList<Integer> yours = new ArrayList<>(yourList.length);
        for (int i = 0; i < yourList.length; i++) {
            if (!yourList[i].isEmpty()) {
                yours.add(Integer.parseInt(yourList[i]));
            }
        }
        for (Integer winner: winners) {
           if (yours.contains(winner)){
               points++;
           }
        }
        return points;
    }
}
