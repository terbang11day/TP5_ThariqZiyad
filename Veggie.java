// Veggie.java
public class Veggie extends Product {
    private boolean isOrganic;

    public Veggie(String name, int price, int stock, boolean isOrganic) {
        super(name, price, stock);
        this.isOrganic = isOrganic;
    }

    @Override
    public int checkDiscount(int quantity) {
        int discount = 0;
        if (isOrganic) {
            if (quantity >= 5) {
                discount = 20;
            } else if (quantity >= 3) {
                discount = 10;
            }
        } else {
            if (quantity >= 5) {
                discount = 25;
            } else if (quantity >= 3) {
                discount = 20;
            }
        }
        return discount;
    }
}
