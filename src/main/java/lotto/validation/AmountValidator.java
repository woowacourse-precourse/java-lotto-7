package lotto.validation;

import lotto.message.ErrorMessage;

import static lotto.constant.Constant.LOTTO_PRICE;

public class AmountValidator {
    /**
     * 구입 금액이 0보다 작은지 검증
     * @param amount 구입 금액
     */
    public static void isPositive(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    /**
     * 구입 금액이 1000으로 나누어 떨어지는지 검증
     * @param amount 구입 금액
     */
    public static void isDivisibleByThousand(int amount){
        if(amount % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_THOUSAND.getMessage());
        }
    }

}
