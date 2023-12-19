package ecomProject.src.clothingStore;

//in this method we will use basically some services such as add display and other

public interface ClothingService {
    void addClothes  (Clothes clothes);
    void displayClothes();

    void removeClothesById(int Id);

    void updateClothesByType(String type);
}
