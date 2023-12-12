package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Day7Challenge1 {

    private static class Hand{
        private char[] hand;
        private int bid;
        private int rank = -1;

        public Hand(String hand, String bid) {
            this.hand = hand.toCharArray();
            this.bid = Integer.parseInt(bid);
            classifyHand();
        }

        private void classifyHand(){
            ArrayList<Integer> frequencies = new ArrayList<>(5);
            for (int i = 0; i < 5; i++) {
                int frequency = 0;
                for (int j = 0; j < 5; j++) {
                    if (hand[i] == hand[j]) {
                        frequency++;
                    }
                }
                frequencies.add(frequency);
            }
            if (frequencies.contains(5)){
                rank = 1;
            } else if (frequencies.contains(4)){
                rank = 2;
            } else if (frequencies.contains(3) && frequencies.contains(2)){
                rank = 3;
            } else if (frequencies.contains(3)){
                rank = 4;
            } else if (frequencies.contains(2)){
                rank = 6;
                frequencies.remove((Integer) 2);
                frequencies.remove((Integer) 2);
                if (frequencies.contains(2)){
                    rank = 5;
                }
            } else {
                rank = 7;
            }
        }

        public int getBid(){
            return bid;
        }
        public int getRank(){
            return rank;
        }
        public char[] getHand(){
            return hand;
        }
    }

    private static class CompareHands implements Comparator<Hand> {

        @Override
        public int compare(Hand o1, Hand o2) {
            if (o1.getRank() - o2.getRank() != 0){
                return o1.getRank() - o2.getRank();
            } else {
                int[] hand1 = handToInt(o1.getHand());
                int[] hand2 = handToInt(o2.getHand());
                for (int i = 0; i < 5; i++) {
                    if (hand1[i] - hand2[i] != 0){
                        return hand1[i] - hand2[i];
                    }
                }
                return 0;

            }
        }

        private int[] handToInt(char[] hand){
            int[] handInt = new int[5];
            for (int i = 0; i < 5; i++){
                switch (hand[i]) {
                    case 'A' -> handInt[i] = 1;
                    case 'K' -> handInt[i] = 2;
                    case 'Q' -> handInt[i] = 3;
                    case 'J' -> handInt[i] = 4;
                    case 'T' -> handInt[i] = 5;
                    default -> handInt[i] = 15 - (hand[i] - '0');
                }
            }
            return handInt;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Hand> hands = new ArrayList<>();
        System.out.println("Enter: ");
        String input = scanner.nextLine();
        while (!input.isEmpty()){
            hands.add(new Hand(input.substring(0,5), input.substring(6)));
            input = scanner.nextLine();
        }
        hands.sort(new CompareHands());
        long sum = 0;
        for (int i = 0; i < hands.size(); i++){
            sum += (long) hands.get(hands.size() - i - 1).getBid() * (i + 1);
        }
        System.out.println("Sum: " + sum);
    }

}
