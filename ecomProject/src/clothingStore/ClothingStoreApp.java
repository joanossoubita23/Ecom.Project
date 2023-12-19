package ecomProject.src.clothingStore;

import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClothingStoreApp {


    public static Clothes createClothes(Scanner sc) {
        System.out.println("Please enter the Clothes id: ");
        int id = sc.nextInt();
        System.out.println("Please enter the Clothes type");
        String type = sc.next();
        System.out.println("Please enter your clothes size ");
        double size = sc.nextDouble();
        System.out.println("Please enter the price:");
        double price = sc.nextDouble();
        System.out.println("Please enter the quantity");
        int quantity = sc.nextInt();
        Clothes c2 = new Clothes(id, type, size, price, quantity);
        return (c2);
    }

    public static void main(String[] args) {

        JDBConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        ClothingServiceImp serviceImp = new ClothingServiceImp();
        int choice;
        boolean options = true;
        try {
            do {
                System.out.println("""
                         Welcome to our clothing store! 
                            Please choose from the following option: 
                           1-Add Clothes/items 
                           2-Display clothes/items in your cart
                           3-Remove items 
                           4-Update items
                           5-Exit
                        """);
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        Clothes c1 = createClothes(sc);
                        serviceImp.addClothes(c1);
                        serviceImp.displayClothes();
                        break;
                    case 2:
                        System.out.println("Your clothes list");
                        serviceImp.displayClothes();
                        break;
                    case 3:
                        serviceImp.displayClothes();
                        sc.nextLine();
                        System.out.println("Enter clothes id to remove: ");
                        int id = sc.nextInt();
                        serviceImp.removeClothesById(id);
                        break;
                    case 4:
                        sc.nextLine();
                        serviceImp.displayClothes();
                        System.out.println("Enter the clothes type to update");
                        String type2 = sc.next();
                        serviceImp.updateClothesByType(type2);
                        System.out.println("Please create the updated item");
                        Clothes updatedItem = createClothes(sc);
                        System.out.println(updatedItem);
                        break;
                    case 5:
                        System.out.println("Bye, Come back soon!");
                        options = false;
                        break;
                }
            } while (options);
        }catch (InputMismatchException e){
            System.out.println("Sorry ,Wrong input! ");
        }

    }
}

