package Day6;

import java.util.ArrayList;
import java.util.Scanner;

public class Day6Challenge1 {

    private record Race(int time, int record) {}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Race> races = new ArrayList<>();
        System.out.println("Enter: ");
        String input = scanner.nextLine();
        String[] times = input.substring(5).split(" ");
        input = scanner.nextLine();
        String[] records = input.substring(9).split(" ");
        ArrayList<Integer> trimmedTimes = new ArrayList<>();
        for (String time: times){
            if (!time.isEmpty()){
                trimmedTimes.add(Integer.parseInt(time));
            }
        }
        for (String record: records){
            if (!record.isEmpty()){
                races.add(new Race(trimmedTimes.remove(0), Integer.parseInt(record)));
            }
        }
        int product = 1;
        for (Race race: races) {
            product *= calculatePosibilities(race);

        }
        System.out.println("Product: " + product);
    }

    private static int calculatePosibilities(Race race){
        int record = race.record;
        int possibilities = 0;
        for (int i = 1; i < race.time; i++){
            int distance = i * (race.time - i);
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
