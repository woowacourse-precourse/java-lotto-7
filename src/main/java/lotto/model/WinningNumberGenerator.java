package lotto.model;

import java.util.Arrays;
import java.util.List;

public class WinningNumberGenerator {
    public Lotto createWinningNumbers(String rawWinningNumbers) {
        validate(rawWinningNumbers);
        List<String> winningNumbers = splitWinningNumbers(rawWinningNumbers);
        List<Integer> numbers = convertWinningNumbers(winningNumbers);
        return Lotto.createWinningLotto(numbers);
    }

    private List<String> splitWinningNumbers(String rawWinningNumbers) {
        return Arrays.asList(rawWinningNumbers.split(","));
    }

    private List<Integer> convertWinningNumbers(List<String> rawWinningNumbers) {
        try {
            return rawWinningNumbers.stream().map(Integer::parseInt).toList();
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 부정확한 번호가 입력되었습니다.");
        }
    }

    private void validate(String rawWinningNumbers){
        validateFormat(rawWinningNumbers);
    }

    private void validateFormat(String rawWinningNumbers){
        if(!rawWinningNumbers.matches("^[0-9,]*$")){
            throw new IllegalArgumentException("[ERROR] 당첨 로또 번호는 숫자와 콤마만 입력가능합니다.");
        }
    }
}
