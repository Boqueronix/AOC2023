package Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4Challenge1 {
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
        System.out.println();
        int sum = 0;
        for (Integer integer : pointsPerCard) {
            System.out.println(integer);
            sum += integer;
        }
        System.out.println("Sum: " + sum);
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
               if (points == 0){
                   points = 1;
               } else {
                   points *= 2;
               }
           }
        }
        return points;
    }
}
