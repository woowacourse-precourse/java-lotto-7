package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final String NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String UNACCEPTED_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호 중 중복된 번호가 있습니다.";

    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }
    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        winningNumbers.stream().forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE);
            }
        });
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(UNACCEPTED_LENGTH_EXCEPTION_MESSAGE);
        }
        Set<Integer> uniqueWinningNumbers = new HashSet(winningNumbers);
        if (winningNumbers.size() != uniqueWinningNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
    
    
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
