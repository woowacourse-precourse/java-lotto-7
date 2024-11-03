package lotto.dto;

import lotto.exceptioin.InputException;

import java.util.List;

public class InputDTO {
    private List<Integer> winningNumbers;

    private int bonusNumber;

    private int money;

    private final InputException inputException = new InputException();

    public InputDTO(List<Integer> winningNumbers, int bonusNumber, int money) {
        // 입력값 검증
        inputException.validateLottoNumbers(winningNumbers);
        inputException.validateBonusNumber(bonusNumber);
        inputException.validateMoney(money);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.money = money;
    }

    public InputDTO() {}

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }


    public int getMoney() {
        return money;
    }

    public int setMoney(int money) {
        this.money = money;
        return money;
    }
}