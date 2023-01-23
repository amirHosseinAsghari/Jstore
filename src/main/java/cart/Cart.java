package cart;

import dataOp.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Cart {
    public static void main(String[] args) throws IOException {
        reset();

    }
    public static ArrayList<String> productsInCart(){
        ArrayList<String> cart = ReadOp.readFile("/home/amir/Dev/JJ/src/main/resources/data/cart.txt");
        for (int i = 1; i < cart.size(); i++) {
            if (Integer.parseInt(cart.get(i).split(":")[1]) == 0){
                cart.remove(i);
            }
        }
        return cart;
    }
    public static boolean isCartFilled(){
        return total() > 0;
    }

    //If you ever want to reduce the quantity just pass negetive number to the add method
    public static boolean add(int productId, int productQuantity) throws IOException {
        ArrayList<String> products = ReadOp.readFile("/home/amir/Dev/JJ/src/main/resources/data/products.txt");
        if (productId < products.size()) {
            int inStock = Integer.parseInt(products.get(productId).split(":")[2]);
            if (productQuantity <= inStock) {
                ArrayList<String> cart = ReadOp.readFile("/home/amir/Dev/JJ/src/main/resources/data/cart.txt");
                int finalQuantity = productQuantity + Integer.parseInt(cart.get(productId).split(":")[1]);
                if (finalQuantity < 0){
                      finalQuantity = 0;
                }
                String line = productId + ":" + finalQuantity;
                cart.set(productId, line);
                Files.write(Path.of("/home/amir/Dev/JJ/src/main/resources/data/cart.txt"), cart);
                return true;
            }
        }

        return false;
    }

    public static boolean remove(int productId) throws IOException {
        ArrayList<String> products = ReadOp.readFile("/home/amir/Dev/JJ/src/main/resources/data/products.txt");
        if (productId < products.size()) {
            ArrayList<String> cart = ReadOp.readFile("/home/amir/Dev/JJ/src/main/resources/data/cart.txt");
            String line = productId + ":" + "0";
            cart.set(productId, line);
            Files.write(Path.of("/home/amir/Dev/JJ/src/main/resources/data/cart.txt"), cart);
            return true;
        }

        return false;
    }
    public static void reset() throws IOException {
        ArrayList<String> cart = ReadOp.readFile("/home/amir/Dev/JJ/src/main/resources/data/cart.txt");
        for (int i = 1; i < cart.size(); i++) {
            cart.set(i,i + ":" + "0");
        }
        Files.write(Path.of("/home/amir/Dev/JJ/src/main/resources/data/cart.txt"), cart);

    }

    public static double total() {
        ArrayList<String> cart = ReadOp.readFile("/home/amir/Dev/JJ/src/main/resources/data/cart.txt");
        ArrayList<String> products = ReadOp.readFile("/home/amir/Dev/JJ/src/main/resources/data/products.txt");
        double sum = 0;
        for (int i = 1; i < cart.size(); i++) {
            int count = Integer.parseInt(cart.get(i).split(":")[1]);
            int price = Integer.parseInt(products.get(i).split(":")[3]);
            sum += (count * price);
        }
        return sum;

    }
}
