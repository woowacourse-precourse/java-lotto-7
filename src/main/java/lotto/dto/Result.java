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
            throw new IllegalArgumentException("[ERROR] 당첨번호 문자열 형식이 일치하지 않습니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        if(lotto.getNumbers().contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스번호는 당첨번호이외의 숫자여야 합니다.");
        this.bonusNumber = bonusNumber;
    }

}
