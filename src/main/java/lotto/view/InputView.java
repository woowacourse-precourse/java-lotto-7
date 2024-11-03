package lotto.view;

import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String NUMBER_PATTERN = "\\d+";
    private static final String NEXT_LINE = "\n";
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String INSERT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INSERT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final Integer LOTTO_PRICE = 1000;
    private static final Integer LOTTO_LEAST_NUM = 1;
    private static final Integer LOTTO_MAX_NUM = 45;
    private static final Integer LOTTO_LENGTH = 6;

    public Integer getPurchaseAmountInput() {
        System.out.println(INSERT_PURCHASE_AMOUNT_MESSAGE);
        return validateAndParsePurchaseAmount(readLine());
    }

    public Integer validateAndParsePurchaseAmount(final String input) {
        validateNumber(input);
        final int purchaseAmount = Integer.parseInt(input);
        validateAmount(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> getWinningNumbersInput() {
        System.out.println(NEXT_LINE + INSERT_WINNING_NUMBERS_MESSAGE);
        final String input = readLine().trim();
        validateWinningNumbers(input);
        return parseWinningNumbers(input);
    }

    public List<Integer> parseWinningNumbers(final String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(WINNING_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .toList();
        winningNumbers.forEach(this::validateRange);
        return winningNumbers;
    }

    public Integer getBonusNumberInput(final List<Integer> winningNumbers) {
        System.out.println(NEXT_LINE + INSERT_BONUS_NUMBER_MESSAGE);
        final String input = readLine().trim();
        validateBonusNumber(input, winningNumbers);
        return parseBonusNumber(input);
    }

    public Integer parseBonusNumber(final String input) {
        return Integer.parseInt(input);
    }

    public void validateWinningNumbers(final String input) {
        List<String> winningNumbers = Arrays.asList(input.split(WINNING_NUMBER_DELIMITER));
        winningNumbers.forEach(this::validateNumber);
        validateCount(winningNumbers);
        validateWinningNumbersDuplicate(winningNumbers);
    }

    public void validateBonusNumber(final String input, final List<Integer> winningNumbers) {
        validateNumber(input);
        validateDuplicate(input, winningNumbers);
        validateRange(Integer.parseInt(input));
    }

    public void validateNumber(final String input) {
        if (!input.matches(NUMBER_PATTERN)) // 정수로 이루어진 문자열인지 검증 [0-9]+
            throw new IllegalArgumentException(LottoException.NUMBER_FORMAT_NOT_VALID.getMessage());
    }

    public void validateAmount(final Integer purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) // 1,000원 단위로 나누어 떨어지지 않을 경우
            throw new IllegalArgumentException(LottoException.PURCHASE_AMOUNT_NOT_VALID.getMessage());
    }

    public void validateCount(final List<String> winningNumbers) {
        if (winningNumbers.size() != LOTTO_LENGTH) // 입력 받은 당첨 번호가 6자리가 아닐 경우
            throw new IllegalArgumentException(LottoException.LOTTO_LENGTH_NOT_VALID.getMessage());
    }

    public void validateRange(final Integer num) {
        if (num < LOTTO_LEAST_NUM || num > LOTTO_MAX_NUM) // 입력 받은 당첨 번호 혹은 보너스 번호가 1~45 범위를 벗어날 경우
            throw new IllegalArgumentException(LottoException.LOTTO_RANGE_NOT_VALID.getMessage());
    }

    public void validateWinningNumbersDuplicate(final List<String> winningNumbers) {
        Set<String> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size())
            throw new IllegalArgumentException(LottoException.WINNING_NUMBERS_DUPLICATED.getMessage()); // 당첨 번호 중 중복 값이 있을 경우
    }

    public void validateDuplicate(final String bonusNumberInput, final List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumberInput))) // 입력 받은 보너스 번호가 당첨 번호와 중복될 경우
            throw new IllegalArgumentException(LottoException.BONUS_NUMBER_DUPLICATED.getMessage());
    }
}
