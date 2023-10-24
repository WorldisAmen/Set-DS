import java.util.Scanner;
public class Set implements ISet{

    private String[] universe;
    private int elements;

    public Set(String[] universe) {
        this.universe = universe;
        this.elements = 0;
    }
    public void setElements(int elements){
        this.elements = elements;
    }
    public void add(String element) {
        BitOperations Bo = new BitOperations();
        for (int i = 0; i < universe.length; i++) {
            if (universe[i].equals(element)) {
                this.elements = Bo.setBit(this.elements, i);
                return;
            }
        }

        int chosen;
        if (!element.isEmpty()) {
            do {

                System.out.println(element + " isn't in universe");
                System.out.println("enter 1 to remove " + element + " from the set");
                System.out.println("enter 2 to replace " + element + " with another");
                Scanner scanner = new Scanner(System.in);
                chosen = scanner.nextInt();
                switch (chosen) {
                    case 1:
                        System.out.println(element + " is removed successfully");
                        return;
                    case 2:
                        System.out.print("enter the new element :");
                        String newElement = scanner.next();
                        add(newElement);
                        return;

                    default:
                        System.out.println("try again!");
                }
            }
            while (chosen != 1 && chosen != 2);
        }

    }

    @Override
    public int union(Set other) {
        if (universe.length != other.universe.length) {
            throw new IllegalArgumentException("Universe sizes do not match");
        }
        return (this.elements | other.elements);
    }
    @Override
    public int intersection(Set other) {
        if (universe.length != other.universe.length) {
            throw new IllegalArgumentException("Universe sizes do not match");
        }
        return (this.elements & other.elements);
    }
    @Override
    public int complement() {
        return ~this.elements;
    }
    @Override
    public int difference(Set other) {
        if (universe.length != other.universe.length) {
            throw new IllegalArgumentException("Universe sizes do not match");
        }
        System.out.println(elements & (~other.elements));
        return elements & (~other.elements);
    }
    @Override
    public int cardinality() {
        return countBits(this.elements);
    }
    @Override
    public void print() {
        System.out.print("{");
        boolean first = true;
        BitOperations Bo = new BitOperations();
        for (int i = 0; i < universe.length; i++) {
            if (Bo.getBit(elements,i) == 1) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(universe[i]);
                first = false;
            }
        }
        System.out.println("}");
    }
    public static int countBits(int n) {
        return (n == 0) ? 0 : ((n & 1) + countBits(n >> 1));
    }

}