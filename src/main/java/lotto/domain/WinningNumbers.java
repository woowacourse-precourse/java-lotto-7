package lotto.domain;

import static lotto.utils.Constant.COMMA;
import static lotto.utils.Constant.LOTTO_SIZE;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        validateFormat(winningNumbers);
        validateWinningNumbers(winningNumbers);
        List<Integer> sortedWinningNumbers = convertToListAndSort(winningNumbers);
        this.winningNumbers = Collections.unmodifiableList(sortedWinningNumbers);
    }

    public int countMatchingNumbers(Lotto lotto) {
        Set<Integer> winningset = new HashSet<>(winningNumbers);
        int count = 0;
        for(int i=0;i<LOTTO_SIZE;i++){
            Integer number = lotto.getElement(i);
            if(winningset.contains(number)){
                count++;
            }
        }
        return count;
    }

    private void validateFormat(String winningNumbers) {
        if(winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 올바른 방식으로 입력하세요");
        }
        if(winningNumbers.startsWith(COMMA) || winningNumbers.endsWith(COMMA)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 올바른 방식으로 입력하세요");
        }
    }

    private void validateWinningNumbers(String winningNumbers) {
        String[] splitWinningNumbers = winningNumbers.split(COMMA);
        if(splitWinningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        int number;
        for (String splitWinningNumber : splitWinningNumbers) {
            try {
                number = Integer.parseInt(splitWinningNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
            }
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 이상 45 이하입니다.");
            }
        }
    }

    private List<Integer> convertToListAndSort(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(COMMA))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
