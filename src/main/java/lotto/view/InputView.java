package lotto.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


    private static final int LOTTO_AMOUNT = 1000;
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_WINNING_NUMBER = 1;
    private static final int MAX_WINNING_NUMBER = 45;


    public int readPurchaseAmount() {
        String fieldName = "구입금액";
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String input = readLine();

        validateNumber(input, fieldName);

        int amount = Integer.parseInt(input);
        validateDivisible(amount);

        return amount;
    }

    public List<Integer> readWinningNumbers() {
        String fieldName = "당첨번호";
        System.out.println(WINNING_NUMBERS_MESSAGE);
        String input = readLine();

        List<String> numberTokens = splitWinningNumbers(input);
        validateWinningNumberCount(numberTokens);

        numberTokens.forEach(i -> validateNumber(i, fieldName));

        List<Integer> winningNumbers = parseToNumbers(numberTokens);
        winningNumbers.forEach(i -> validateNumberInRange(i, fieldName));

        return winningNumbers;
    }

    public Integer readBonusNumber() {
        String fieldName = "보너스번호";
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = readLine();

        validateNumber(input, fieldName);

        int bonusNumber = Integer.parseInt(input);
        validateNumberInRange(bonusNumber, fieldName);

        return bonusNumber;
    }

    private void validateNumber(String input, String fieldName) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("[ERROR] %s은(는) 숫자여야 합니다.", fieldName));
        }
    }

    private void validateDivisible(int amount) {
        if (amount % LOTTO_AMOUNT != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 구입금액은 %d원 단위여야 합니다.", LOTTO_AMOUNT));
        }
    }

    private List<String> splitWinningNumbers(String input) {
        return Arrays.stream(input.split(WINNING_NUMBER_DELIMITER)).toList();
    }

    private void validateWinningNumberCount(List<String> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 당첨 번호는 %d개여야 합니다.", WINNING_NUMBER_COUNT));
        }
    }

    private List<Integer> parseToNumbers(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNumberInRange(Integer number, String fieldName) {
        if (number < MIN_WINNING_NUMBER)
            throw new IllegalArgumentException(String.format("[ERROR] %s은(는) %d 이상이어야 합니다.", fieldName, MIN_WINNING_NUMBER));
        if (number > MAX_WINNING_NUMBER)
            throw new IllegalArgumentException(String.format("[ERROR] %s은(는) %d 이하이어야 합니다.", fieldName, MAX_WINNING_NUMBER));
    }
}
