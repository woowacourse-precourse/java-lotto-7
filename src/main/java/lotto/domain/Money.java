package lotto.domain;

public class Money {
    private static final long ZER0_MONEY = 0;
    private static final long LOTTO_PRICE = 1000;
    private long money;
    private long spentMoney;
    private long earnedMoney;

    public Money() {
        this(ZER0_MONEY);
    }

    public Money(long money) {
        this.money = money;
    }

    public long getTicket() {
        long ticketCount = money / LOTTO_PRICE;
        useMoney(money);
        return ticketCount;
    }

    public long getEarnedMoney() {
        return earnedMoney;
    }

    public long getSpentMoney() {
        return spentMoney;
    }

    public double getRateOfReturn() {
        double rateOfReturn = ((float) earnedMoney / spentMoney) * 100;
        return Math.round(rateOfReturn * 10) / 10.0;
    }

    public void addMoney(long amount) {
        money += amount;
        earnedMoney += amount;
    }

    private void useMoney(long amount) {
        money -= amount;
        spentMoney += amount;
    }
}
