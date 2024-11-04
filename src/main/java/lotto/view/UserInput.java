package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import lotto.Parser;
import lotto.Validator;

public class UserInput {
    public int getPurchaseAmount() {
        String input = Console.readLine();

        Validator.validateIsNumber(input);
        int amount = Parser.convertStrToInt(input);

        Validator.validatePositiveAmount(amount);
        Validator.validatePurchaseAmount(amount);

        return amount;
    }

    public static List<Integer> inputWinNumbers() {
        String input = Console.readLine();
        String[] numbers = input.split(",");

        List<Integer> winNumbers = new ArrayList<>();

        for (String number : numbers) {
            Validator.validateIsNumber(number);
            int num = Parser.convertStrToInt(number);
            Validator.validateNumberRange(num);
            winNumbers.add(num);
        }
        Validator.validateLottoSize(winNumbers);
        Validator.validateDuplicate(winNumbers);

        return winNumbers;
    }

    public static int inputBonusNumber(List<Integer> winNumbers) {
        String input = Console.readLine();

        Validator.validateIsNumber(input);
        int bonusNumber = Parser.convertStrToInt(input);

        Validator.validateNumberRange(bonusNumber);
        Validator.validateBonusDuplicate(winNumbers, bonusNumber);

        return bonusNumber;
    }

}
