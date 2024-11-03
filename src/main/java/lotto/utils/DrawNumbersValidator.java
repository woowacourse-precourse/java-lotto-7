package lotto.utils;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.constant.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class DrawNumbersValidator {

    private static final String DELIMITER = ",";

    public List<Integer> validateWinningNumbers(String winningNumbers) {
        validateEmpty(winningNumbers);
        validateWinningNumbersFormat(winningNumbers);

        List<String> splitWinningNumbers = List.of(winningNumbers.split(DELIMITER));
        validateCountWinningNumbers(splitWinningNumbers);
        validateAllNoLetters(splitWinningNumbers);
        validateDuplicateWiningNumbers(splitWinningNumbers);
        validateAllRange(splitWinningNumbers);
        return splitWinningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateAllRange(List<String> splitWinningNumbers) {
        for (String number : splitWinningNumbers) {
            validateRange(number);
        }
    }

    private void validateAllNoLetters(List<String> splitWinningNumbers) {
        for (String number : splitWinningNumbers) {
            validateNoLetters(number);
        }
    }

    public int validateBonusNumber(String bonusNumber) {
        validateEmpty(bonusNumber);
        validateNoLetters(bonusNumber);
        int parseBonusNumber = Integer.parseInt(bonusNumber);
        validateRange(bonusNumber);

        return parseBonusNumber;
    }

    public void validateAssociateWinningAndBonusNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호와 당첨 번호는 중복될 수 없습니다.");
        }
    }
    private void validateRange(String number) {
        if (Integer.parseInt(number) < LottoNumber.MIN_VALUE || LottoNumber.MAX_VALUE < Integer.parseInt(number)) {
            throw new IllegalArgumentException("번호는 1 ~ 45 범위로 입력해주세요.");
        }
    }

    private void validateDuplicateWiningNumbers(List<String> splitWinningNumbers) {
        if (isDuplicateWinningNumbers(splitWinningNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 중복을 제거하고 입력해주세요");
        }
    }

    private void validateNoLetters(String number) {
        if (!number.matches(LottoNumber.FORMAT)) {
            throw new IllegalArgumentException("번호로는 문자를 입력할 수 없습니다.");
        }
    }

    private void validateCountWinningNumbers(List<String> splitWinningNumbers) {
        if (splitWinningNumbers.size() < Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호 개수가 부족합니다.");
        }

        if (splitWinningNumbers.size() > Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호 개수가 초과되었습니다.");
        }
    }

    private void validateWinningNumbersFormat(String winningNumbers) {
        if (winningNumbers.startsWith(DELIMITER) || winningNumbers.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("잘못된 당첨 번호 형식입니다.");
        }
    }

    private void validateEmpty(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("번호를 입력해주세요.");
        }
    }

    private boolean isDuplicateWinningNumbers(List<String> splitWinningNumbers) {
        return splitWinningNumbers.stream().distinct().count() != splitWinningNumbers.size();
    }
}
