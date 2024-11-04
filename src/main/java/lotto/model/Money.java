package lotto.model;

public class Money {
    private int leftMoney;
    private int usedMoney;
    private int winningAmount;
    public Money(int money) {
        this.leftMoney = money;
        this.usedMoney = 0;
    }
    public void take(int price) {
        leftMoney -= price;
        usedMoney += price;
    }
    public int getLeftMoney() {
        return leftMoney;
    }
    public int getUsedMoney() {
        return usedMoney;
    }
    public void receiveWinningAmount(int totalWinningAmount) {
        this.winningAmount = totalWinningAmount;
    }
}
