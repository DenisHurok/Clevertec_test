
public class SaleCards {

    private double sale;

    public SaleCards() {
        this.sale=1;
    }

    public SaleCards(String nameCard) {
        switch (nameCard) {
            case "card1":
                this.sale = 0.8;
                break;

            case "card2":
                this.sale = 0.7;
                break;
            case "card3":
                this.sale=0.6;
                break;
            default:
                this.sale=1;
                break;
        }

    }



    public double getSale() {
        return sale;
    }
}
