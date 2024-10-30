package lotto.model;

public class UserData {
    private int money = 0;
    private int lottoPapes = 0;


    public void setMoney(int money) {
        this.money = money;
    }

    public void setLottoPapes(int lottoPapes) {
        this.lottoPapes = lottoPapes;
    }

    public int getMoney() {
        return money;
    }

    public int getLottoPapes() {
        return lottoPapes;
    }

}
