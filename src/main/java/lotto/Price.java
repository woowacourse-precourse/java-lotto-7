package lotto;

public enum Price {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int number;
    private final int amount;

    Price(int number, int amount){
        this.number = number;
        this.amount = amount;
    }

    public int getNumber(){
        return number;
    }

    public int getAmount(){
        return amount;
    }

}
