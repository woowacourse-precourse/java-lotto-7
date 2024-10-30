package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final List<Integer> winningNumbers;

    public WinningNumbers(String input) {
        this.winningNumbers = parseAndValidate(input);
    }

    private List<Integer> parseAndValidate(String input) {
        try {
            // split 메서드에 limit 값을 설정하여 모든 요소를 포함
            List<String> splitInput = Arrays.asList(input.split(",", -1));

            // 숫자 변환 및 유효성 검사
            List<Integer> numbers = splitInput.stream()
                    .map(s -> {
                        try {
                            return Integer.parseInt(s.trim());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
                        }
                    })
                    .collect(Collectors.toList());

            // 각 항목이 빈 문자열인지 검사하고 숫자 개수가 6개인지 확인
            if (splitInput.size() != 6 || splitInput.stream().anyMatch(String::isEmpty)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 없이 6개여야 합니다.");
            }
            // 중복과 범위 검증
            if (new HashSet<>(numbers).size() != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 없이 6개여야 합니다.");
            }
            if (numbers.stream().anyMatch(num -> num < MIN || num > MAX)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
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
