package Algorithms_DataStructures.ECommerceSearch;

public class Main {
    static void main(String[] args) {

        Product[] products ={
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Bag", "Fashion")
        };
        int searchId = 104;

        // Linear Search
        Product result1 = LinearSearch.linearSearch(products, searchId);

        if(result1!=null) System.out.println("Linear Search Found: " + result1);
        else System.out.println("Product not found");

        // Binary Search
        Product result2 = BinarySearch.binarySearch(products, searchId);

        if(result2!=null) System.out.println("Binary Search Found: " + result2);
        else System.out.println("Product not found");
    }
}