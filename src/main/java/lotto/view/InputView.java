package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.validator.CommonInputValidator;
import lotto.validator.NumberInputValidator;

public class InputView {

    private final CommonInputValidator commonInputValidator;
    private final NumberInputValidator numberInputValidator;

    public InputView(CommonInputValidator commonInputValidator, NumberInputValidator numberInputValidator) {
        this.commonInputValidator = commonInputValidator;
        this.numberInputValidator = numberInputValidator;
    }

    public int getMoneyFromUser() {
        String input = Console.readLine();
        commonInputValidator.validateCommonInput(input);
        numberInputValidator.validateNumberInput(input);

        return Integer.parseInt(input);
    }

    public List<Integer> getLottoWinningNumbersFromUser() {
        String input = Console.readLine();
        commonInputValidator.validateCommonInput(input);
        String[] splitInput = validateParsedInput(input);

        return convertToIntegerListFrom(splitInput);
    }

    private String[] validateParsedInput(String input) {
        String[] splitInput = input.split(",");
        for (String s : splitInput) {
            numberInputValidator.validateNumberInput(s);
        }
        return splitInput;
    }

    private List<Integer> convertToIntegerListFrom(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(Integer::parseInt)
                .toList();
    }

    public int getLottoBonusNumberFromUser() {
        String input = Console.readLine();
        commonInputValidator.validateCommonInput(input);
        numberInputValidator.validateNumberInput(input);

        return Integer.parseInt(input);
    }
}
