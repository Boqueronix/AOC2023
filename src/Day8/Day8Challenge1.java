package Day8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Day8Challenge1 {
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
        long steps = 0;
        Node current = nodes.get(nodes.indexOf(new Node("AAA", "", "")));
        while (!current.equals(new Node("ZZZ", "", ""))){
            if (directions.get((int) (steps % directions.size())) == 'L'){
                current = nodes.get(nodes.indexOf(new Node(current.left, "", "")));
            } else {
                current = nodes.get(nodes.indexOf(new Node(current.right, "", "")));
            }
            steps++;
        }
        System.out.println("Steps: " + steps);
    }

}
