package lotto;

public class PurchaseCalculator implements Calculator {
    private static final int LOTTO_PRICE = 1000;
    @Override
    public int calculate(int receivedAmount) {
        validateAmount(receivedAmount);
        return receivedAmount / LOTTO_PRICE;
    }

    private void validateAmount(int amount){
        validateMinimumAmount(amount);
        validateDivisibleByLottoPrice(amount);
    }

    private void validateMinimumAmount(int amount){
        if(amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상의 금액이어야 합니다.");
        }
    }

    private void validateDivisibleByLottoPrice(int amount){
        if(amount % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
