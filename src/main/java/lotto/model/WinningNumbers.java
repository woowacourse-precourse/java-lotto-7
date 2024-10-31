package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber){
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber){
        if(bonusNumber<1||bonusNumber>45||winningNumbers.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45사이의 당첨번호와 중복되지 않는 번호여야 합니다.");
        }
    }

    public Lotto getWinningNumbers(){
        return this.winningNumbers;
    }

    public int getBonusNumber(){
        return this.bonusNumber;
    }
}
