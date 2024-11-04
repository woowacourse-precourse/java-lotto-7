package model;

public class LottoWinningNumbers {
    private final Lotto winningNumbers;
    private final Integer bonusNumber;

    public LottoWinningNumbers(Lotto winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Integer getNumber(int index){
        return winningNumbers.getNumber(index);
    }

    public Integer getBonusNumber(){
        return bonusNumber;
    }
}
