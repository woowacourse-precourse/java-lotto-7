package lotto.service.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.validation.BonusNumberValidator;
import lotto.validation.WinningNumberValidator;

public class WinningNumberParser {

    public static List<Integer> parseWinningNumber(String winningNumberInput){
        List<String> splittedInput = splitInput(winningNumberInput);
        List<Integer> winningNumbers = new ArrayList<>();

        for (String token : splittedInput){
            int parsedNumber = Integer.parseInt(token.trim());
            WinningNumberValidator.validateNumberRange(parsedNumber);
            WinningNumberValidator.validateWinningNumberDuplicate(winningNumbers,parsedNumber);
            winningNumbers.add(parsedNumber);
        }

        return winningNumbers;
    }

    public static int parseBonusNumber(String bonusNumberInput){
        int bonusNumber = Integer.parseInt(bonusNumberInput.trim());
        BonusNumberValidator.validateNumberRange(bonusNumber);
        return bonusNumber;
    }

    private static List<String> splitInput(String input){
        return Arrays.stream(input.replaceAll(" ","").split(",")).toList();
    }

}
