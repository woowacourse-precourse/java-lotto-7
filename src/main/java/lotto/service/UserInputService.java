package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.util.InputValidator;

public class UserInputService {
    public int getPurchaseAmount(String inputAmount) {

        InputValidator.isNotNull(inputAmount);
        inputAmount = removeBlank(inputAmount);
        InputValidator.isNotEmpty(inputAmount);

        int purchaseAmount = parseInteger(inputAmount);
        InputValidator.isMinimumAmount(purchaseAmount);
        InputValidator.isMultipleOfThousand(purchaseAmount);

        return purchaseAmount;
    }

    public Lotto getWinningLotto(String inputNumber) {

        InputValidator.isNotNull(inputNumber);
        inputNumber = removeBlank(inputNumber);
        InputValidator.isNotEmpty(inputNumber);

        List<String> numbersInput = splitInput(inputNumber);
        List<Integer> numbers = new ArrayList<>();

        for(String number : numbersInput) {
            int num = parseInteger(number);
            InputValidator.isValidNumber(num);
            numbers.add(num);
        }

        return new Lotto(numbers);
    }

    public int getBonus(String inputNumber) {

        InputValidator.isNotNull(inputNumber);
        inputNumber = removeBlank(inputNumber);
        InputValidator.isNotEmpty(inputNumber);

        int bonus = parseInteger(inputNumber);
        InputValidator.isValidNumber(bonus);

        return bonus;
    }

    private int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 문자가 들어가 있습니다");
        }
    }

    private String removeBlank(String input) {
        return input.replaceAll(" ", "");
    }

    private List<String> splitInput(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

}
