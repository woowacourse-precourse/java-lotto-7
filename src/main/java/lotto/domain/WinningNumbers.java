package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.ErrorMessages;
import lotto.common.LottoConstants;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String input) {
        this.winningNumbers = parseAndValidate(input);
    }

    private List<Integer> parseAndValidate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_WINNING_NUMBER);
        }
        try {
            // split 메서드에 limit 값을 설정하여 모든 요소를 포함
            List<String> splitInput = Arrays.asList(input.split(",", -1));

            // 각 항목이 빈 문자열인지 검사하고 숫자 개수가 6개인지 확인
            if (splitInput.size() != LottoConstants.LOTTO_SIZE || splitInput.stream().anyMatch(String::isEmpty)) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
            }

            // 숫자 변환 및 유효성 검사
            List<Integer> numbers = splitInput.stream()
                    .map(s -> {
                        try {
                            return Integer.parseInt(s.trim());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_INPUT_ERROR);
                        }
                    })
                    .collect(Collectors.toList());

            // 중복과 범위 검증
            if (new HashSet<>(numbers).size() != LottoConstants.LOTTO_SIZE) {
                throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBER);
            }
            if (numbers.stream()
                    .anyMatch(num -> num < LottoConstants.LOTTO_MIN_NUMBER || num > LottoConstants.LOTTO_MAX_NUMBER)) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE);
            }
            return numbers;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }


    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
