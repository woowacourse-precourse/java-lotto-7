package lotto.domain;

import java.util.List;

public record WinningTicket(List<Integer> winningNumbers, int bonusNumber) {
    public WinningTicket(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = List.copyOf(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    public boolean isBonusNumberMatched(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
