package lotto;

public class LottoMachine {
    public static final int PRICE_OF_ONE_LOTTERY_TICKET = 1000;

    private int calculateLottoCount(int amount) {
        return amount / PRICE_OF_ONE_LOTTERY_TICKET;
    }

}
