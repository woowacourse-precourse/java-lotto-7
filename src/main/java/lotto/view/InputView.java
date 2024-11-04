package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.validator.CommonInputValidator;
import lotto.validator.NumberInputValidator;

public class InputView {

    public int getMoneyFromUser() {
        String input = Console.readLine();
        CommonInputValidator.validateCommonInput(input);
        NumberInputValidator.validateNumberInput(input);

        return Integer.parseInt(input);
    }

    public Lotto getLottoWinningNumbersFromUser() {
        String input = Console.readLine();
        CommonInputValidator.validateCommonInput(input);
        String[] splitInput = validateParsedInput(input);

        List<Integer> lottoWinningNumbers = convertToIntegerListFrom(splitInput);

        return Lotto.of(lottoWinningNumbers);
    }

    private static String[] validateParsedInput(String input) {
        String[] splitInput = input.split(",");
        for (String s : splitInput) {
            NumberInputValidator.validateNumberInput(s);
        }
        return splitInput;
    }

    private static List<Integer> convertToIntegerListFrom(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(Integer::parseInt)
                .toList();
    }

    public int getLottoBonusNumberFromUser() {
        String input = Console.readLine();
        CommonInputValidator.validateCommonInput(input);
        NumberInputValidator.validateNumberInput(input);

        return Integer.parseInt(input);
    }
}
