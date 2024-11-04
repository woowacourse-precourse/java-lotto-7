package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class ParsingService {
    private int money;
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void setMoney(String money) {
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void parseNumbers(String stringNumbers) {
        String[] parts = stringNumbers.split(",");
        for (String part : parts) {
            winningNumbers.add(Integer.parseInt(part));
        }
    }

    public void parseBonusNumbers(String stringBonusNumber) {
        this.bonusNumber = Integer.parseInt(stringBonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

