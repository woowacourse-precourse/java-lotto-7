package lotto.domain;

public class Wallet {
    private final static int MIN_PRICE_PER_LOTTO_TICKET = 1000;

    private final int money;
    private final int ticket;
    private int rateOfReturn = 0;

    public Wallet(int money) {
        validateMinAmount(money);
        validateUnit(money);

        this.money = money;
        this.ticket = calculateNumberOfLottoPurchases(money);
    }

    public int getRateOfReturn() {
        return rateOfReturn;
    }

    public int getTicket(){
        return ticket;
    }



    public void calculateRateOfReturn(int totalPrizeMoney){
        rateOfReturn = totalPrizeMoney / money * 100;
    }


    private int calculateNumberOfLottoPurchases(int money){
        return money / MIN_PRICE_PER_LOTTO_TICKET;
    }




    private void validateMinAmount(int money) {
        if (money < MIN_PRICE_PER_LOTTO_TICKET) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 1,000원 입니다.");
        }
    }

    private void validateUnit(int money){
        if (money % MIN_PRICE_PER_LOTTO_TICKET != 0){
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위로 입력해 주세요.");
        }
    }

}
