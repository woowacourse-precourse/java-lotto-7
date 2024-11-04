package lotto.domain.lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoDto {

    private Set<Integer> winningNumbers = new HashSet<>();
    private Integer bonusNumber;

    public void updateWinningNumbers(String inputWinningNumbers) {
        String[] numbers = inputWinningNumbers.split(",");
        for (String number : numbers) {
            this.winningNumbers.add(Integer.parseInt(number));
        }
    }

    public void updateBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
