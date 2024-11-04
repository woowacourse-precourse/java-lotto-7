package lotto.Service;

import java.util.ArrayList;
import java.util.List;

public class ParsingService {
    private int money;
    private List<Integer> numbers = new ArrayList<>();
    private int bonusNumber;

    public void setMoney(String money) {
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void parseNumbers(String stringNumbers) {
        String[] parts = stringNumbers.split(",");
        for (String part : parts) {
           numbers.add(Integer.parseInt(part));
        }
    }
    public void parseBonusNumbers(String stringBonusNumber){
        this.bonusNumber=Integer.parseInt(stringBonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

