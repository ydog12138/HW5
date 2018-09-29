import java.util.Scanner;

/**
 * This program is for cs180 hw5 that it controls a parking garage
 * @author Haoran Yin(Ian) yin143@purdue.edu
 * @version 2018-09-29-00
 */
public class ValetParker {

    public static void main(String[] args) {
        final String divider = "==========";
        final String menu = "\nOptions:\n" + divider + "\n" + "1) Park Car\n" + "2) Print Parking Garage\n"
                + "3) Remove Car at Location\n" + "4) Exit\n" + divider;
        final String intro = "Welcome to Valet Parker!\n" + divider;
        System.out.println(intro);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of floors:");
        int floor = input.nextInt();
        System.out.println("Enter number of rows per floor:");
        int row = input.nextInt();
        System.out.println("Enter number of columns per floor:");
        int column = input.nextInt();
        String[][][] parking = new String[floor][row][column];
        boolean go = true;
        int choice;
        while (go) {
            System.out.println(menu);
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Car Description:");
                    String description = input.nextLine();
                    description = input.nextLine();
                    int parkFloor = 0;
                    int parkRow = 0;
                    int parkColumn = 0;
                    boolean found = false;
                    if (parking[floor - 1][row - 1][column - 1] != null)
                        System.out.println("No Spaces Available.");
                    else {
                        for (int i = 0; i < floor; i++) {
                            if (!found) {
                                for (int k = 0; k < row; k++) {
                                    if (!found) {
                                        for (int z = 0; z < column; z++) {
                                            if (!found && parking[i][k][z] == null) {
                                                parkFloor = i;
                                                parkRow = k;
                                                parkColumn = z;
                                                found = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        parking[parkFloor][parkRow][parkColumn] = description;
                        System.out.println("Car parked at:\n" + divider + "\n" +
                                "Floor: " + parkFloor + "\n" +
                                "Row: " + parkRow + "\n" +
                                "Col: " + parkColumn + "\n");
                    }
                    break;
                case 2:
                    for (int i = 0; i < floor; i++) {
                        System.out.println("Floor: " + i + "\n" + divider);
                        for (int k = 0; k < row; k++) {
                            for (int z = 0; z < column; z++) {
                                System.out.print("|");
                                if (parking[i][k][z] == null)
                                    System.out.print(" ");
                                else
                                    System.out.print("#");
                                System.out.print("|");
                            }
                            System.out.print("\n");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.println("Enter Location of Car\nFloor:");
                    int removeFloor = input.nextInt();
                    System.out.println("Row:");
                    int removeRow = input.nextInt();
                    System.out.println("Col:");
                    int removeCol = input.nextInt();
                    if (removeFloor >= floor || removeRow >= row || removeCol >= column)
                        System.out.println("Error: Space does not exist.");
                    else if (parking[removeFloor][removeRow][removeCol] == null)
                        System.out.println("Error: Space does not contain a car.");
                    else {
                        System.out.println("Removing " + parking[removeFloor][removeRow][removeCol]);
                        parking[removeFloor][removeRow][removeCol] = null;
                    }
                    break;
                case 4:
                    go = false;
                    break;
                default:
                    System.out.println("Error: Option not available.");
                    break;
            }
        }
    }
}
