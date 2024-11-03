package lotto;

import lotto.view.OutputView;

public enum Price {
    THREE(3, 5000, "3개 일치 (5,000원) - "),
    FOUR(4, 50000, "4개 일치 (50,000원) - "),
    FIVE(5, 1500000, "5개 일치 (1,500,000원) - "),
    FIVE_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치(30,000,000원) - "),
    SIX(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    MISS(0, 0, "");

    private final int number;
    private final int amount;
    private final String message;

    Price(int number, int amount, String message){
        this.number = number;
        this.amount = amount;
        this.message = message;
    }

    private static final int WINNING_MIN_COUNT = 3;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static Price value(int number, boolean matchBonus){
        if(number < WINNING_MIN_COUNT){
            return MISS;
        }

        if(FIVE.matchCount(number) && matchBonus){
            return FIVE;
        }

        for(Price price : values()){
            if(price.matchCount(number) && price != FIVE)
                return price;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public int getNumber(){
        return number;
    }

    public int getAmount(){
        return amount;
    }

    private boolean matchCount(int countOfMatch) {
        return this.number == countOfMatch;
    }

    public void printMessage(int count) {
        if (this != MISS) {
            OutputView.printSuccessMessage(message, count);
        }
    }

}
