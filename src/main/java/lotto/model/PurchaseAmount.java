package lotto.model;

public class PurchaseAmount{
    public static final Integer LOTTE_PRICE=1000;
    private final Integer money;

    public PurchaseAmount(Integer money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(Integer money) {
        validateNonNegative(money);
        validateDivisibleByLottoPrice(money);
    }

    private void validateDivisibleByLottoPrice(Integer money) {
        if(money%LOTTE_PRICE!=0){
            throw new IllegalArgumentException("[ERROR] 1000으로 나누져야 합니다.");
        }

    }

    private void validateNonNegative(Integer money) {
        if(money<=0){
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
    }

    public Integer getMoney() {
        return money;
    }
}
