package ecomProject.src.clothingStore;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.sql.Connection;

public class ClothingServiceImp implements ClothingService {

    private Connection connection;

    public ClothingServiceImp(Connection connection) {
        this.connection = connection;
    }

    private ArrayList<Clothes> clothesList = new ArrayList<>();

    public ClothingServiceImp() {
        this.clothesList = clothesList;
    }

    @Override
    public void addClothes(Clothes clothes) {
        try (PreparedStatement statement= connection.prepareStatement("INSERT INTO Clothing_DB(id,type,size,price,quantity) VALUES(?,?,?,?,?,?)")){
            statement.setInt(1,clothes.getId());
            statement.setString(2, clothes.getType());
            statement.setDouble(3,clothes.getSize());
            statement.setDouble(4,clothes.getPrice());
            statement.setInt(5,clothes.getQuantity());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        clothesList.add(clothes);
        System.out.println("Added successfully!");
    }

    @Override
    public void displayClothes() {
        if (clothesList.isEmpty()) {
            System.out.println("Your cart is empty!");
        } else
            for (Clothes clothes : clothesList) {
                System.out.println(clothes);
            }
    }

    @Override
    public void removeClothesById(int Id) {
//        Scanner sc = new Scanner (System.in);
//        System.out.println("Enter the clothes type to remove");
//        String type
        for (Clothes c1 : clothesList) {
            try {
                if (c1.getId() == (Id)) {
                    clothesList.remove(c1);
                    System.out.println("Your item removed from your card successfully");
                    break;

                } else {
                    System.out.println("No items found");
                }

            } catch (ConcurrentModificationException e) {
                System.out.println("error");
            }

        }
    }

    @Override
    public void updateClothesByType(String type) {
        for (Clothes c1 : clothesList) {
            if (c1.getType().equals(type)) {
                c1.setType(c1.getType());
            } else {
                System.out.println("Item with " + type + " not found");


            }
        }
    }
}

//CLothingServiceImp //
