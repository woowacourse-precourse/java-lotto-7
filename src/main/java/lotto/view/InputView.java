package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.ErrorMessage.INVALID_INPUT_NUMBER;

public class InputView {

    private static final String DELIMITER = ",";

    public int readPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    public Lotto readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseWinningNumbers(input);
    }

    private Lotto parseWinningNumbers(String input) {
        String[] numbers = input.split(DELIMITER);
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String number : numbers) {
            parsedNumbers.add(Integer.parseInt(number.trim()));
        }
        Lotto winningNumbers = new Lotto(parsedNumbers);
        return winningNumbers;
    }

    public int readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER.getMessage());
        }
    }
}