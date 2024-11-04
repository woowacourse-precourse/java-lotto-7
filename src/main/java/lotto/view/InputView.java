package lotto.view;

import lotto.constant.CompareInteger;
import lotto.constant.LottoGuide;
import lotto.constant.PriceRule;
import lotto.constant.WinningNumberRule;
import lotto.validator.NumberValidator;
import lotto.validator.PriceValidator;
import lotto.validator.WinningNumberValidator;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int getLottoCount() {
        try {
            int price = getLottoPrice();
            PriceValidator.validatePrice(price);
            return price / CompareInteger.PRICE_LOTTO.getNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return getLottoCount();
        }
    }

    private static int getLottoPrice() throws IllegalArgumentException {
        OutputView.printPriceGuide();
        String inputPrice = readInput();
        return NumberValidator.stringToInteger(inputPrice, LottoGuide.ERROR.getMessage() + PriceRule.ONLY_INTEGER.getMessage());
    }

    public static List<Integer> getWinningNumber() {
        try {
            List<String> inputWinningNumber = Arrays.asList(getWinningNumberInput().split(WinningNumberRule.SEPARATOR.getMessage()));
            return WinningNumberValidator.validateInputWinningNumber(inputWinningNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return getWinningNumber();
        }
    }

    private static String getWinningNumberInput(){
        OutputView.printWinningNumberGuide();
        String input = readInput();
        WinningNumberValidator.validateInputComma(input);
        return input;
    }

    public static Integer getBonusNumber(List<Integer> mainNumber) {
        try {
            Integer bonusNumber = WinningNumberValidator.getValidatedNumber(getBonusNumberInput());
            WinningNumberValidator.validateBonusDuplication(mainNumber, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return getBonusNumber(mainNumber);
        }
    }

    private static String getBonusNumberInput(){
        OutputView.printBonusNumberGuide();
        return InputView.readInput();
    }

    public static String readInput() {
        return readLine();
    }
}
