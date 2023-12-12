package Day6;

import java.util.Scanner;

public class Day6Challenge2 {

    private record Race(long time, long record) {}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: ");
        String input = scanner.nextLine();
        Long time = Long.parseLong(input.substring(5).replace(" ", ""));
        input = scanner.nextLine();
        Long record = Long.parseLong(input.substring(9).replace(" ", ""));
        System.out.println("Product: " + calculatePosibilities(new Race(time, record)));
    }

    private static int calculatePosibilities(Race race){
        long record = race.record;
        int possibilities = 0;
        for (int i = 1; i < race.time; i++){
            long distance = i * (race.time - i);
            if (distance > record){
                possibilities++;
                record = distance;
            } else if (distance == record && possibilities > 0){
                possibilities *= 2;
                break;
            } else if (distance < record && possibilities > 0) {
                possibilities += possibilities - 1;
                break;
            }
        }
        return possibilities;
    }
}
