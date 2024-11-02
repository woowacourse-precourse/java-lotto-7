package lotto.dto;

import java.util.List;

public class InputDTO {
    private List<Integer> winningNumbers;

    private int bonusNumber;

    private List<Integer> allNumbers;

    private int money;

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

    public List<Integer> getAllNumbers() {
        return allNumbers;
    }

    public void setAllNumbers(List<Integer> allNumbers) {
        this.allNumbers = allNumbers;
    }

    public int getMoney() {
        return money;
    }

    public int setMoney(int money) {
        this.money = money;
        return money;
    }
}