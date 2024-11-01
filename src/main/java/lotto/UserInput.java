package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public int inputAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 숫자이어야 합니다.");
        }
    }

    public int inputBonusNumber() {
        int bonus = validateBonusNumberFormat();
        validateBonusNumber(bonus);
        return bonus;
    }

    public List<Integer> inputWinningNumbers() {
        String winningNumbersInput = Console.readLine();
        List<Integer> winningNumbersOutput = convertInputWinningNumbersToOutput(winningNumbersInput);
        return winningNumbersOutput;
    }

    private List<Integer> convertInputWinningNumbersToOutput(String winningNumbers) {
        String[] inputWinningNumbers = winningNumbers.split(",");

        List<Integer> winningNumbersList = new ArrayList<>();

        for (String inputWinningNumber : inputWinningNumbers) {
            winningNumbersList.add(Integer.parseInt(inputWinningNumber));
        }

        return winningNumbersList;
    }

    private void validateBonusNumber(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 숫자만 허용됩니다.");
        }
    }

    private int validateBonusNumberFormat() {
        try {
            return Integer.parseInt(Console.readLine());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 형태여야 합니다.");
        }
    }

}
