package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Converter;
import lotto.validator.InputValidator;

import java.util.List;

public class InputView {
    private static final String INPUT_BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private InputView(){
    }

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_BUY_MONEY_MESSAGE);
        String input = Console.readLine();
        InputValidator.validatePurchaseAmount(input);
        return Converter.convertToNumber(input);
    }

    public static List<Integer> inputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateWinNumbers(input);
        return Converter.convertNumbers(input);
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateBonusNumber(input);
        return Converter.convertToNumber(input);
    }

}
