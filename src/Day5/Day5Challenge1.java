package Day5;

import java.util.ArrayList;
import java.util.Scanner;

public class Day5Challenge1 {

    private record Map(long destination, long source, long length) {}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> seeds = new ArrayList<>();
        System.out.println("Enter: ");
        String input = scanner.nextLine();
        String[] seedStrings = input.substring(7).split(" ");
        for (String seedString : seedStrings) {
            seeds.add(Long.parseLong(seedString));
        }
        input = scanner.nextLine();
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> seedToSoil = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            seedToSoil.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        ArrayList<Long> soils = map(seeds, seedToSoil);
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> soilToFertilizer = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            soilToFertilizer.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        ArrayList<Long> fertilizers = map(soils, soilToFertilizer);
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> fertilizerToWater = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            fertilizerToWater.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        ArrayList<Long> waters = map(fertilizers, fertilizerToWater);
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> waterToLight = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            waterToLight.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        ArrayList<Long> lights = map(waters, waterToLight);
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> lightToTemperature = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            lightToTemperature.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        ArrayList<Long> temperatures = map(lights, lightToTemperature);
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> temperatureToHumidity = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            temperatureToHumidity.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        ArrayList<Long> humidities = map(temperatures, temperatureToHumidity);
        input = scanner.nextLine();
        input = scanner.nextLine();
        ArrayList<Map> humidityToLocation = new ArrayList<>();
        while (!input.isEmpty()) {
            String[] split = input.split(" ");
            humidityToLocation.add(new Map(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            input = scanner.nextLine();
        }
        ArrayList<Long> locations = map(humidities, humidityToLocation);
        long minLocation = locations.get(0);
        for (Long location : locations) {
            if (location < minLocation) {
                minLocation = location;
            }
        }
        System.out.println("Closest Location: " + minLocation);
    }

    public static ArrayList<Long> map(ArrayList<Long> source, ArrayList<Map> maps) {
        ArrayList<Long> destination = new ArrayList<>(source.size());
        for (Long s: source) {
            boolean found = false;
            for (Map map : maps) {
                if (s - map.source < map.length && map.source <= s) {
                    destination.add(map.destination - (map.source - s));
                    found = true;
                    break;
                }
            }
            if (!found) {
                destination.add(s);
            }
        }
        return destination;
    }
}
