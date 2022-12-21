

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Purchase {
    private String name;
    private Integer amount = 0;
    private double price;
    private boolean sale;

    public Purchase(String name, double price, boolean sale) {
        this.name = name;
        this.price = price;
        this.sale = sale;
    }

    public Purchase(String name, double price) {
        this.name = name;
        this.price = price;
        this.sale = false;
    }

    public Purchase() {
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isSale() {
        return sale;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return price * amount;
    }

    @Override
    public String toString() {
        if (sale == true) {
            String purcahses = String.format("   %-11s    *$%-6.1f   %-5d      $%-6.1f  ", name, price, amount, getTotal());
            return purcahses;
        } else {
            String purcahse = String.format("   %-11s     $%-6.1f   %-5d      $%-6.1f ", name, price, amount, getTotal());
            return purcahse;
        }

    }
}
