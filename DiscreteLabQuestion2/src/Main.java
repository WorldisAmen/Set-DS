import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the elements in the Universe U, separated by spaces: ");
            String[] universeArray = scanner.nextLine().split(" ");
            Set universe = new Set(universeArray);
            System.out.print("Enter the number of sets: ");
            int numSets = scanner.nextInt();
            scanner.nextLine(); // consume the remaining line break
            Set[] sets = new Set[numSets];
            for (int i = 1; i <= numSets; i++) {
                System.out.print("Enter the elements of set " + i + ", separated by spaces: ");
                String[] setArray = scanner.nextLine().split(" ");
                Set set = new Set(universeArray);
                for (int j = 0; j < setArray.length; ++j) {
                    set.add(setArray[j]);
                }
                sets[i - 1] = set;
            }
            while (true) {
                System.out.println();
                System.out.println("Select an operation:");
                System.out.println("1. Union of two sets");
                System.out.println("2. Intersection of two sets");
                System.out.println("3. Complement of a set");
                System.out.println("4. Difference between two sets");
                System.out.println("5. Cardinality of a set");
                System.out.println("6. Print a set");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("Goodbye!");
                    break;
                }
                System.out.print("Enter the number of the first set: ");
                int index1 = scanner.nextInt() - 1;
                Set set1 = sets[index1];
                scanner.nextLine(); // consume the remaining line break
                Set result = new Set(universeArray);
                switch (choice) {
                    case 1:
                        System.out.print("Enter the number of the second set: ");
                        int index2 = scanner.nextInt() - 1;
                        Set set2 = sets[index2];
                        int union = set1.union(set2);
                        System.out.println("The union of set " + (index1 + 1) + " and set " + (index2 + 1) + " is:");
                        result.setElements(union);
                        result.print();
                        break;
                    case 2:
                        System.out.print("Enter the number of the second set: ");
                        int index3 = scanner.nextInt() - 1;
                        Set set3 = sets[index3];
                        int intersectionSet = set1.intersection(set3);
                        System.out.println("The intersection of set " + (index1 + 1) + " and set " + (index3 + 1) + " is:");
                        result.setElements(intersectionSet);
                        result.print();
                        break;
                    case 3:
                        int complementSet = set1.complement();
                        System.out.println("The complement of set " + (index1 + 1) + " is:");
                        result.setElements(complementSet);
                        result.print();
                        break;
                    case 4:
                        System.out.print("Enter the number of the second set: ");
                        int index4 = scanner.nextInt() - 1;
                        Set set4 = sets[index4];
                        int diffSet = set1.difference(set4);
                        System.out.println("The difference between set " + (index1 + 1) + " and set " + (index4 + 1) + " is:");
                        result.setElements(diffSet);
                        result.print();
                        break;
                    case 5:
                        int cardinality = set1.cardinality();
                        System.out.println("The cardinality of set " + (index1 + 1) + " is: " + cardinality);
                        break;
                    case 6:
                        System.out.println("Set " + (index1 + 1) + " is:");
                        set1.print();
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        }catch (Exception e){
            System.out.println("Some error has occurred due to wrong input , try again");
        }
    }
}