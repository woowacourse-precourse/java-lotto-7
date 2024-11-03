package lotto.controller;

import static lotto.constant.ErrorMessage.*;

import java.util.List;

public class ControllerValidation {

    public static void inputPurchaseMoneyValidation(String inputPurchaseMoney){
        if (!inputPurchaseMoney.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_POSITIVE_INTEGER_ERROR_MESSAGE);
        }
    }

    public static void inputBonusNumberValidation(String inputBonusNumber) {
        if (!inputBonusNumber.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException(BONUS_NUMBER_POSITIVE_INTEGER_ERROR_MESSAGE);
        }
    }

    public static void checkAlreadyExistNumber(List<Integer> numbers, Integer number){
        if(numbers.contains(number)){
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_WITH_WINNING_ERROR_MESSAGE);
        }
    }
}
