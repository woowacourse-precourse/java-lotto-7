package lotto.model;

import java.util.List;

public class UserData {
    private int money = 0;
    private int lottoPapers = 0;
    private List<Integer> winNumbers;
    private int bonusNumber;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLottoPapers() {
        return lottoPapers;
    }

    public void setLottoPapers(int lottoPapes) {
        this.lottoPapers = lottoPapes;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public void setWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

}
