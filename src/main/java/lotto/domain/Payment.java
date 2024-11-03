package lotto.domain;

import lotto.exception.PaymentException;
import lotto.exception.message.PaymentExceptionMessage;

public class Payment {

    private static final int LOTTO_PRICE = 1000;

    private final int lottoCount;

    private Payment(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static Payment of(int money){
        validateMoney(money);
        return new Payment(calculateLottoCount(money));
    }

    public int getLottoCount(){
        return this.lottoCount;
    }

    private static void validateMoney(int money) {
        validateIsPositiveNumber(money);
        validateDivisibleByLottoUnit(money);
    }

    private static void validateIsPositiveNumber(int money){
        if (money <= 0) {
            throw new PaymentException(PaymentExceptionMessage.NOT_POSITIVE_NUMBER);
        }
    }

    private static void validateDivisibleByLottoUnit(int money){
        if (money % LOTTO_PRICE != 0) {
            throw new PaymentException(PaymentExceptionMessage.CANT_DIVIDE);
        }
    }

    private static int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
