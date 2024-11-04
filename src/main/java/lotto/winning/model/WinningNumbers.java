package lotto.winning.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private static final String DELIMITER = ",";
    private List<Integer> winningNumbers;

    public List<Integer> getWinningNumbers(String inputWinningNumbers) {
        splitIntoNumbers(inputWinningNumbers);
        return winningNumbers;
    }

    private void splitIntoNumbers(String inputWinningNumbers) {
        winningNumbers = new ArrayList<>();
        for (String splitedNumber : inputWinningNumbers.split(DELIMITER)) {
            validateCastingToNumber(splitedNumber);
            int number = Integer.parseInt(splitedNumber);

            validateInRange(number);

            validateDegenerate(number);
            winningNumbers.add(number);
        }
        Collections.sort(winningNumbers);
    }
    
    private void validateCastingToNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력하세요.");
        }
    }
    
    private void validateInRange(int number) {
        boolean isInRange = (1 <= number) && (number <= 45);
        if (!isInRange) {
            throw new IllegalArgumentException("[ERROR] 1 - 45 사이의 숫자만 입력하세요.");
        }
    }

    private void validateDegenerate(int number) {
        boolean isDegenerated = winningNumbers.contains(number);
        if (isDegenerated) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
    }
}
