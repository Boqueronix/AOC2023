package Day5;

import java.util.ArrayList;
import java.util.Scanner;

public class Day5Challenge2 {

    private record Map(long destination, long source, long length) {}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: ");
        String input = scanner.nextLine();
        String[] seedStrings = input.substring(7).split(" ");
        input = scanner.nextLine();
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> seedToSoil = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            seedToSoil.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> soilToFertilizer = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            soilToFertilizer.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> fertilizerToWater = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            fertilizerToWater.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> waterToLight = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            waterToLight.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> lightToTemperature = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            lightToTemperature.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> temperatureToHumidity = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            temperatureToHumidity.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> humidityToLocation = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            humidityToLocation.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        long minLocation = Long.MAX_VALUE;
        for (int i = 0; i < seedStrings.length; i += 2) {
            for (long j = 0; j < Long.parseLong(seedStrings[i + 1]); j++) {
                long seed = Long.parseLong(seedStrings[i]) + j;
                long soil = map(seed, seedToSoil);
                long fertilizer = map(soil, soilToFertilizer);
                long water = map(fertilizer, fertilizerToWater);
                long light = map(water, waterToLight);
                long temperature = map(light, lightToTemperature);
                long humidity = map(temperature, temperatureToHumidity);
                long location = map(humidity, humidityToLocation);
                if (location < minLocation) {
                    minLocation = location;
                }
            }
        }
        System.out.println("Closest Location: " + minLocation);
    }

    public static long map(long l, ArrayList<Map> maps) {
        long destination = l;
        boolean found = false;
        for (Map map : maps) {
            if (l - map.source < map.length && map.source <= l) {
                destination = map.destination - (map.source - l);
                found = true;
                break;
            }
        }
        return destination;
    }
}
