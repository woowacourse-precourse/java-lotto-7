package lotto.controller;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATE_WITH_WINNING_ERROR_MESSAGE;

import java.util.List;

public class ControllerValidation {

    public static void inputPurchaseMoneyValidation(String inputPurchaseMoney){
        if (!inputPurchaseMoney.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양의 정수여야 합니다.");
        }
    }

    public static void inputBonusNumberValidation(String inputBonusNumber) {
        if (!inputBonusNumber.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 자연수입니다.");
        }
    }

    public static void checkAlreadyExistNumber(List<Integer> numbers, Integer number){
        if(numbers.contains(number)){
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_WITH_WINNING_ERROR_MESSAGE);
        }
    }
}
