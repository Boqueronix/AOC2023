package Day8;

import java.util.ArrayList;
import java.util.Scanner;

public class Day8Challenge2 {
    private static class Node {
        private String element;
        private String left;
        private String right;
        public Node(String element, String left, String right){
            this.element = element;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            return this.element.equals(node.element);
        }

        public boolean endsWith(char end){
            return this.element.charAt(2) == end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Character> directions = new ArrayList<>();
        System.out.println("Enter: ");
        String input = scanner.nextLine();
        while (!input.isEmpty()){
            for (int i = 0; i < input.length(); i++) {
                directions.add(input.charAt(i));
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.isEmpty()){
            nodes.add(new Node(input.substring(0,3), input.substring(7,10), input.substring(12,15)));
            input = scanner.nextLine();
        }
        ArrayList<Integer> stepsList = new ArrayList<>();
        for (Node node : nodes) {
            if (node.endsWith('A')){
                int steps = 0;
                Node current = node;
                while (!current.endsWith('Z')){
                    if (directions.get((int) (steps % directions.size())) == 'L'){
                        current = nodes.get(nodes.indexOf(new Node(current.left, "", "")));
                    } else {
                        current = nodes.get(nodes.indexOf(new Node(current.right, "", "")));
                    }
                    steps++;
                }
                stepsList.add(steps);
            }
        }
        long lcm = stepsList.get(0);
        while (!divisible(lcm, stepsList)){
            lcm += stepsList.get(0);
        }
        System.out.println("Steps: " + lcm);
    }
    private static boolean divisible(long lcm, ArrayList<Integer> stepsList){
        for (int i = 0; i < stepsList.size(); i++) {
            if (lcm % stepsList.get(i) != 0){
                return false;
            }
        }
        return true;
    }

}
