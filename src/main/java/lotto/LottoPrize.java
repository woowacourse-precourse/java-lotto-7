package lotto;

public enum LottoPrize {

    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);

    final long amount;

    LottoPrize(int amount){
        this.amount = amount;
    }

    public long getAmount(){
        return this.amount;
    }
}
