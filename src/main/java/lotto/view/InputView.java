package lotto.view;

import lotto.util.ValidateUtil;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String NEXT_LINE = "\n";
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String INSERT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INSERT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final ValidateUtil validateUtil;

    public InputView() {
        this.validateUtil = new ValidateUtil();
    }

    public Integer getPurchaseAmountInput() {
        System.out.println(INSERT_PURCHASE_AMOUNT_MESSAGE);
        return validateUtil.validateAndParsePurchaseAmount(readLine());
    }

    public List<Integer> getWinningNumbersInput() {
        System.out.println(NEXT_LINE + INSERT_WINNING_NUMBERS_MESSAGE);
        final String input = readLine().trim();
        validateUtil.validateWinningNumbers(input);
        return parseWinningNumbers(input);
    }

    public List<Integer> parseWinningNumbers(final String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(WINNING_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .toList();
        winningNumbers.forEach(validateUtil::validateRange);
        return winningNumbers;
    }

    public Integer getBonusNumberInput(final List<Integer> winningNumbers) {
        System.out.println(NEXT_LINE + INSERT_BONUS_NUMBER_MESSAGE);
        final String input = readLine().trim();
        validateUtil.validateBonusNumber(input, winningNumbers);
        return parseBonusNumber(input);
    }

    public Integer parseBonusNumber(final String input) {
        return Integer.parseInt(input);
    }

}
