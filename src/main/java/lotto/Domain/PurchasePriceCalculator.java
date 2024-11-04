package lotto.Domain;

public class PurchasePriceCalculator {
    private static Integer PRICE_PER_ONE_LOTTO = 1000;

    public static Integer calculateLottoPrice(Integer paymentPrice) {
        return paymentPrice / PRICE_PER_ONE_LOTTO;
    }
}
