import java.util.Scanner;
import java.util.ArrayList;

class Inventory {
  int ProductID;
  String Name;
  int Price;
  int Quantity;

  public Inventory(int ProductID, String Name, int Price, int Quantity) {
    this.ProductID = ProductID;
    this.Name = Name;
    this.Price = Price;
    this.Quantity = Quantity;
  }
}

class Inventorys {
    static ArrayList<Inventory> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    int choice;
    do {
      ShowMenu();
      choice = sc.nextInt();
      handleChoice(choice);
    } while (choice != 6);
  }

  public static void ShowMenu() {
    System.out.println("1. Add a Product");
    System.out.println("2. Update Product Quantity");
    System.out.println("3. View All Products");
    System.out.println("4. Search for a Product");
    System.out.println("5. Delete a Productt");
    System.out.println("6. Exit");
  }

  public static void handleChoice(int choice) {
    switch (choice) {
      case 1:
        AddProduct();
        break;
      case 2:
        UpdateProductQuantity();
        break;
      case 3:
        ViewAllProducts();
        break;
      case 4:
        SearchForProduct();
        break;
      case 5:
        DeleteProduct();
        break;
      case 6:
        break;
      default:
        System.out.println("Invalid Choice");
    }
  }

  public static void AddProduct() {
    System.out.println("Enter Product ID");
    int ProductID = sc.nextInt();
    System.out.println("Enter Product Name");
    String Name = sc.next();
    System.out.println("Enter Product Price");
    int Price = sc.nextInt();
    System.out.println("Enter Product Quantity");
    int Quantity = sc.nextInt();
    inventory.add(new Inventory(ProductID, Name, Price, Quantity));
  }

  public static void UpdateProductQuantity() {
    System.out.println("Enter Product ID");
    int ProductID = sc.nextInt();
    System.out.println("Enter Quantity to be added");
    int Quantity = sc.nextInt();
    for (Inventory i : inventory) {
      if (i.ProductID == ProductID) {
        i.Quantity += Quantity;
        return;
      }
    }
    System.out.println("Product not found");
  }

  public static void ViewAllProducts() {
    for (Inventory i : inventory) {
      System.out.println("Product ID: " + i.ProductID);
      System.out.println("Product Name: " + i.Name);
      System.out.println("Product Price: " + i.Price);
      System.out.println("Product Quantity: " + i.Quantity);
    }
  }

  public static void SearchForProduct() {
    System.out.println("Enter Product ID");
    int ProductID = sc.nextInt();
    for (Inventory i : inventory) {
      if (i.ProductID == ProductID) {
        System.out.println("Product ID: " + i.ProductID);
        System.out.println("Product Name: " + i.Name);
        System.out.println("Product Price: " + i.Price);
        System.out.println("Product Quantity: " + i.Quantity);
        return;
      }
    }
    System.out.println("Product not found");
  }

  public static void DeleteProduct() {
    System.out.println("Enter Product ID");
    int ProductID = sc.nextInt();
    for (Inventory i : inventory) {
      if (i.ProductID == ProductID) {
        inventory.remove(i);
        return;
      }
    }
    System.out.println("Product not found");
  }
}