package lotto.view;

import static lotto.ExceptionMessage.BONUS_NUMBER_NOT_NUMERIC_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumberInputView {
    private static final String BONUS_NUMBER_INPUT_GUIDE = "\n보너스 번호를 입력해 주세요.";


    public void printBonusNumberInputGuide() {
        System.out.println(BONUS_NUMBER_INPUT_GUIDE);
    }


    public int getBonusNumber() {
        String bonusNumber = Console.readLine();
        validateBonusNumberIsNumeric(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }


    private void validateBonusNumberIsNumeric(String bonusNumber) {
        if (!bonusNumber.matches("\\d+")) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_NUMERIC_EXCEPTION.message());
        }
    }
}
