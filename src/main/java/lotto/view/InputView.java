package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ExceptionConstant;
import lotto.constant.InputConstant;
import lotto.constant.LottoConstant;

public class InputView {
    public static String inputPurchaseAmount() {
        System.out.println(InputConstant.INPUT_PURCHASE_AMOUNT);
        return Console.readLine();

    }

    public static String inputPrimaryNumber() {
        System.out.println(InputConstant.INPUT_PRIMARY_NUMBER);
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.println();
        System.out.println(InputConstant.INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        if (bonusNumber == null || bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(ExceptionConstant.NULL_OR_EMPTY);
        }
        if (!(bonusNumber.chars().allMatch(Character::isDigit))) {
            throw new IllegalArgumentException(ExceptionConstant.CONTAINS_INVALID_CHARACTER);
        }
        int bonus = Integer.parseInt(bonusNumber);
        if (bonus < LottoConstant.LOTTO_NUMBER_MIN || bonus > LottoConstant.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ExceptionConstant.NUMBER_VALID_RANGE);
        }
        return bonus;
    }

}
