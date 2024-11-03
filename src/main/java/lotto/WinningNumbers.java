package lotto;

import java.util.ArrayList;
import java.util.List;
import util.LottoFormatter;

public class WinningNumbers {
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(String winningNumbers, String bonusNumber) {
        try {
            this.winningNumbers = LottoFormatter.parseStringToIntList(winningNumbers);
            this.bonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환할 수 없는 값이 입력되었습니다.");
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력값을 처리하는 중 오류가 발생했습니다.");
        }
        validate();
    }

    private void validate() {
        if (winningNumbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + WINNING_NUMBER_COUNT + "개여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (!isWithinRange(winningNumbers) || !isWithinRange(List.of(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 번호를 입력해 주세요.");
        }
    }

    private boolean isWithinRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= MIN_NUMBER && num <= MAX_NUMBER);
    }

    public List<Integer> getAllWinningNumbers() {
        List<Integer> allWinningNumbers = new ArrayList<>(winningNumbers);
        allWinningNumbers.add(bonusNumber);
        return allWinningNumbers;
    }
}
