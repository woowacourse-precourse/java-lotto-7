package lotto.validation;

public class LottoPurchasePriceValidator implements Validator<String> {
    int LOTTO_PRICE = 1000;

    @Override
    public void validate(String lottoPurchasePrice) {
        if (Integer.parseInt(lottoPurchasePrice) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[Error] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
