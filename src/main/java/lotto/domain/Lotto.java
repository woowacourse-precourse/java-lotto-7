package lotto.domain;

import java.util.List;
import lotto.dto.LottoWinResult;
import lotto.enums.LottoErrorMessage;
import lotto.exception.LottoInputException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoInputException(LottoErrorMessage.LOTTO_WINNING_INVALID_SIZE);
        }
    }

    public LottoWinResult getResult(List<Integer> winningNumbers, int bonusNumber) {
        int winCount = getWinningCount(winningNumbers);
        boolean isBonus = isBonus(bonusNumber);
        return new LottoWinResult(winCount,isBonus,LottoCalculator.cal(winCount,isBonus));
    }

    private boolean isBonus(int bonusNumber) {
        return numbers.stream()
                .anyMatch((num) -> num == bonusNumber);
    }

    private int getWinningCount(List<Integer> winningNumbers) {
        int winCount = 0;
        for(Integer curNum : numbers){
            boolean isMatch = winningNumbers.stream()
                    .anyMatch((num) -> num == curNum);
            if(isMatch){
                winCount++;
            }
        }
        return winCount;
    }
}
