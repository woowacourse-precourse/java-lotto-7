package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.util.FormatValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final int MONEY = 1000;
    private static final String SEPARATOR = ",";
    private static final FormatValidator FORMAT_VALIDATOR = FormatValidator.getInstance();
    private static InputView instance;

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String input() {
        return Console.readLine();
    }

    public Integer inputPrice() {
        String input = input();
        return dividePrice(input);
    }

    private Integer dividePrice(String price) {
        FORMAT_VALIDATOR.validatePriceFormat(price);
        return Integer.parseInt(price) / MONEY;
    }

    public List<Integer> inputWinningNumbers() {
        String input = input();
        return getWinningNumbers(input);
    }

    private List<Integer> getWinningNumbers(String input) {
        FORMAT_VALIDATOR.validateWinningNumberFormat(input);
        return Arrays.stream(input.split(SEPARATOR)).map(Integer::parseInt).toList();
    }

    public Integer inputBonusNumber() {
        String input = input();
        FORMAT_VALIDATOR.validateBonusNumberFormat(input);
        return Integer.parseInt(input);
    }
}
