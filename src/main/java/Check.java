
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Check {
    private   List<Purchase> goods = Arrays.asList(new Purchase("kefir", 20, true),
            new Purchase("Bublik", 20),
            new Purchase("sss", 20, true),
            new Purchase("Cheese", 3, true),
            new Purchase("Bread", 4, true),
            new Purchase("Milk", 2, true),
            new Purchase("Meat", 4));
    private ArrayList<Purchase> purchases = new ArrayList<>();
     private double sale ;
    private double total ;
    int amountOfSalePurchase;
    public Check(Map<Integer, Integer> idAndAmount, SaleCards card)  {
        if (card == null) {
            sale = 1;
        } else {
            sale = card.getSale();
        }

        for (Map.Entry<Integer, Integer> entry : idAndAmount.entrySet()) {
            try {

                Integer id = entry.getKey();
                Integer amount = entry.getValue();
                if (id < 0 || id > goods.size() || amount < 0) {
                    throw new IncorrectIdOrAmount("IncorrectIdOrAmount");
                }
                goods.get(id).setAmount(amount);
                purchases.add(goods.get(id));
            }
            catch (IncorrectIdOrAmount e){
                System.err.println(e.getMessage());
            }
}

            for (Purchase purchase : purchases) {
                if (purchase.isSale()) {
                    amountOfSalePurchase++;
                }
            }
            System.out.println(printHead());
            for (Purchase purchase : purchases) {
                if (purchase.isSale()) {
                    if (amountOfSalePurchase >= 5) {
                        purchase.setPrice(purchase.getPrice() * 0.9);
                    }
                }
                total += purchase.getTotal();
                System.out.println(purchase);
            }
            System.out.println(printbottom());
        }


    private String printHead() {
        Integer NumberOfCashier = 2;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String time = String.format("   CASHIER: №%d    Time: %s\n", NumberOfCashier, dateFormat.format(cal.getTime()));
        return
                "                 CASH RECEIPT" +
                        "\n             Supermarket MegaShop" + "\n" +
                        time
                        + "-----------------------------------------------" +
                        "\n   Product         Price     Amount     Total";

    }
    private String printbottom(){
        String price=String.format("   Price                               $%-6.1f", total);
        String priceWithSale = String.format("   Price with sale                     $%-6.1f", total * sale);

    return "\n-----------------------------------------------\n"+
                price+
            "\n   Sale                                " + (100 - sale * 100) + "%\n"+
            priceWithSale;

    }

    public void printInFile() {
        try (FileWriter writer = new FileWriter("src\\main\\java\\Print")) {
            writer.write(printHead());
            for (Purchase purchase : purchases
            ) {
                writer.write("\n" + purchase.toString());
            }
            writer.write((printbottom()));

        } catch (IOException e) {
            System.err.println("Not Found");
        }
    }
}
