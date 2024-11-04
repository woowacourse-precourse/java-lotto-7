package lotto.model;

import java.util.List;

public class UserData {
    private int money = 0;
    private int lottoPapers = 0;
    private int bonusNumber = 0;
    private List<Integer> winNumbers;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        UserDataValidator.validateMoney(money);
        this.money = money;
    }

    public int getLottoPapers() {
        return lottoPapers;
    }

    public void setLottoPapers(int lottoPapers) {
        this.lottoPapers = lottoPapers;
    }

    public List<Integer> getWinNumbers() {
        UserDataValidator.validateWinNumbers(winNumbers);
        return winNumbers;
    }

    public void setWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        UserDataValidator.validateBonusNumber(winNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

}
