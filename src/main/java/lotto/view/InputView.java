package lotto.view;

import lotto.domain.LottoConstant;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


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
        validateDuplicates(winningNumbers);

        winningNumbers.forEach(i -> validateNumberInRange(i, fieldName));

        return sortAscending(winningNumbers);
    }

    public int readBonusNumber() {
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
        int lottoAmount = LottoConstant.LOTTO_PURCHASE_AMOUNT.getIntValue();
        if (amount % lottoAmount != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 구입금액은 %d원 단위여야 합니다.", lottoAmount));
        }
    }

    private List<String> splitWinningNumbers(String input) {
        String lottoDelimiter = LottoConstant.DELIMITER.getValue();
        return Arrays.stream(input.split(lottoDelimiter)).toList();
    }

    private void validateWinningNumberCount(List<String> winningNumbers) {
        int lottoSize = LottoConstant.LOTTO_SIZE.getIntValue();
        if (winningNumbers.size() != lottoSize) {
            throw new IllegalArgumentException(String.format("[ERROR] 당첨 번호는 %d개여야 합니다.", lottoSize));
        }
    }

    private List<Integer> parseToNumbers(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNumberInRange(Integer number, String fieldName) {
        int minNumber = LottoConstant.MIN_NUMBER.getIntValue();
        int maxNumber = LottoConstant.MAX_NUMBER.getIntValue();

        if (number < minNumber)
            throw new IllegalArgumentException(String.format("[ERROR] %s은(는) %d 이상이어야 합니다.", fieldName, minNumber));
        if (number > maxNumber)
            throw new IllegalArgumentException(String.format("[ERROR] %s은(는) %d 이하이어야 합니다.", fieldName, maxNumber));
    }

    private void validateDuplicates(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 중복될 수 없습니다.");
        }
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
