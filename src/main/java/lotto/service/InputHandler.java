package lotto.service;

import lotto.model.Lotto;

import java.util.List;

public class InputHandler {
    public static int purchaseLottoHandle(String input) {
        Validator.purchaseLottoValidate(input);

        return Integer.parseInt(input);
    }

    public static List<Integer> enterWinningNumbersHandle(String input) {
        Validator.enterWinningNumberValidate(input);

        return Lotto.stringArrayToIntList(input.split(","));
    }

    public static int enterBonusNumberHandle(String input) {
        Validator.enterBonusNumberValidate(input);

        return Integer.parseInt(input);
    }
}
