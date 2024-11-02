package lotto.view;

import lotto.util.LottoConstant;
import lotto.util.LottoNumberValidator;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int readPurchaseAmount() {
        String fieldName = "구입금액";
        String input = readLine();

        validateNumber(input, fieldName);

        int amount = Integer.parseInt(input);
        validateDivisible(amount);

        return amount;
    }

    public List<Integer> readWinningNumbers() {
        String fieldName = "당첨번호";
        String input = readLine();

        List<String> numberTokens = splitWinningNumbers(input);
        numberTokens.forEach(i -> validateNumber(i, fieldName));

        return parseToNumbers(numberTokens);
    }

    public int readBonusNumber() {
        String fieldName = "보너스번호";
        String input = readLine();

        validateNumber(input, fieldName);

        int bonusNumber = Integer.parseInt(input);
        LottoNumberValidator.validateNumberInRange(bonusNumber);

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

    private List<Integer> parseToNumbers(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
