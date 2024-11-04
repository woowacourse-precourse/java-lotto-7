package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import lotto.exception.PaymentException;
import lotto.exception.message.PaymentExceptionMessage;

public class Payment {

    private final int money;
    private final int lottoCount;

    private Payment(int money, int lottoCount) {
        this.money = money;
        this.lottoCount = lottoCount;
    }

    public static Payment of(int money){
        validateMoney(money);
        return new Payment(money, calculateLottoCount(money));
    }

    public int getMoney(){
        return this.money;
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
