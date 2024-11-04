package lotto.model;

public class Pay {
    private int money;
    private int amount;
    private int change;

    private Pay(String input) {
        try {
            this.money = Integer.parseInt(input);
경            if (this.money < 1000) {
                throw new IllegalArgumentException();
            }
            this.amount = money / 1000;
            this.change = money % 1000;
        } catch (NumberFormatException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static Pay createPay(String input) {
        return new Pay(input);
    }

    public int getMoney() {
        return this.money;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getChange() {
        return this.change;
    }
}
