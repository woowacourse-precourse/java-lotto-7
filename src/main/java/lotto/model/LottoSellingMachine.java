package lotto.model;

public class LottoSellingMachine {

    public static Lottos sell(Long money) {
        validateMoney(money);
        Long lottoCount = calculateLottoCount(money);
        return Lottos.from(lottoCount);
    }

    private static void validateMoney(Long money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    private static Long calculateLottoCount(Long money) {
        return money / 1000;
    }
}
