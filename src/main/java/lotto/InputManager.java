package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputManager {
    private static final String SEPARATOR = ",";

    public static int readPurchaseAmount() {
        System.out.println(OutputMessage.ENTER_PURCHASE_AMOUNT.getMessage());
        String input = Console.readLine();

        new LottoInputValidator(input);

        return Integer.parseInt(input.trim());
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(OutputMessage.ENTER_WINNING_NUMBERS.getMessage());
        String input = Console.readLine();

        new LottoInputValidator(input);
        List<Integer> numbers = parseToNumberList(input);

        new Lotto(numbers);

        return numbers;
    }

    public static int readBonusNumber(List<Integer> winningNumbers) {
        System.out.println(OutputMessage.ENTER_BONUS_NUMBER.getMessage());
        String input = Console.readLine();

        new LottoInputValidator(input);
        int bonusNumber = Integer.parseInt(input.trim());

        LottoInputValidator.validateBonusDuplication(bonusNumber, winningNumbers);
        return bonusNumber;
    }



    private static List<Integer> parseToNumberList(String input) {
        String[] parts = input.split(SEPARATOR);
        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            numbers.add(Integer.parseInt(part.trim()));
        }

        return numbers;
    }


}
