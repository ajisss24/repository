import java.util.ArrayList;
import java.util.List;

class MenuItem {
    private String name;
    private double price;
    private int quantity;

    public MenuItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateSubtotal() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Order {
    private List<MenuItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
       for (MenuItem item : items) {
           total += item.calculateSubtotal();
       }
        return total;
    }

    public void printReceipt() {
        System.out.println("===== Nota Pemesanan =====");
        for (MenuItem item : items) {
            System.out.println(item.getName() + " x " + item.getQuantity() + " : " + item.calculateSubtotal());
        }
        System.out.println("--------------------------");
        System.out.println("Total: " + calculateTotal());
    }
}

public class RestaurantOrderApp {
    public static void main(String[] args) {
        Order order = new Order();

        MenuItem item1 = new MenuItem("Nasi Goreng", 20000, 2);
        MenuItem item2 = new MenuItem("Mie Ayam", 15000, 1);

        order.addItem(item1);
        order.addItem(item2);

        order.printReceipt();
    }
}