package lotto;

import static lotto.Constant.COMMA;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private final List<String> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        validateFormat(winningNumbers);
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = convertToList(winningNumbers);
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

    private List<String> convertToList(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(COMMA));
    }
}
