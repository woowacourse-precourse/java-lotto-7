package lotto.io.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.InputValidator;
import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.Money;

public class InputView {

    private static final String AMOUNT_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_GUIDE_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_GUIDE_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_DELIM = ",";

    private final InputValidator validator = new InputValidator();

    public Money getAmountOfMoney() {
        System.out.println(AMOUNT_INPUT_GUIDE_MESSAGE);
        Money money;
        while (true) {
            try {
                String input = Console.readLine();
                validateAmountOfMoney(input);
                int amountOfMoney = Integer.parseInt(input);
                money = new Money(amountOfMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    private void validateAmountOfMoney(String input) {
        validator.validateWhiteSpace(input);
        validator.validateNonDigitInput(input);
        validator.validateOutOfRangeAmount(input);
    }

    public Lotto getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_GUIDE_MESSAGE);
        Lotto winningNumbers;
        while (true) {
            try {
                String input = Console.readLine();
                validateWinningNumbers(input);
                List<Integer> numbers = convertStringToList(input);
                winningNumbers = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private void validateWinningNumbers(String input) {
        validator.validateWhiteSpace(input);
        validator.validateEmptyElemFromInput(input);
        validator.validateEndsWithComma(input);
        validator.validateExistNotDigitElems(input);
    }

    public BonusNumber getBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_GUIDE_MESSAGE);
        String input = Console.readLine();

        return new BonusNumber(input);
    }

    private List<Integer> convertStringToList(String input) {
        String[] numbers = input.split(INPUT_DELIM);
        return Arrays.stream(numbers)
                .map(number -> Integer.parseInt(number.strip()))
                .toList();
    }
}
