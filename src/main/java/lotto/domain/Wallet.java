package lotto.domain;

public class Wallet {
    private final static int MIN_AMOUNT = 1000;

    private final int money;
    private int rateOfReturn = 0;

    public Wallet(int money) {
        validateMinAmount(money);
        validateUnit(money);

        this.money = money;
    }

    private void setRateOfReturn(int rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }








    private void validateMinAmount(int money) {
        if (money < MIN_AMOUNT) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 1,000원 입니다.");
        }
    }

    private void validateUnit(int money){
        if (money % MIN_AMOUNT != 0){
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위로 입력해 주세요.");
        }
    }

}
