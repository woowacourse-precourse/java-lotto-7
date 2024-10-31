package lotto.model;

public class Money {
    private int leftMoney;
    public Money(int money) {
        this.leftMoney = money;
    }
    public void take(int price) {
        leftMoney -= price;
    }
    public int getLeftMoney() {
        return leftMoney;
    }
}
