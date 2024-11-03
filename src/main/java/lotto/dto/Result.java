package lotto.dto;

import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;

public class Result {
    private Lotto lotto;
    private int bonusNumber;

    public Result(String inputWinningNumbers) {
        Validator.validateEmptyString(inputWinningNumbers);
        List<Integer> winningNumbers = extractWinningNumbers(inputWinningNumbers);
        lotto = new Lotto(winningNumbers);
    }

    private List<Integer> extractWinningNumbers(String inputWinningNumbers) {
        try {
            String[] split = inputWinningNumbers.split(",");
            return Arrays.stream(split).map(Integer::parseInt).sorted().toList();
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 문자열이 아닙니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

}
