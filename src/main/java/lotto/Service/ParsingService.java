package lotto.Service;

import java.util.ArrayList;
import java.util.List;

public class ParsingService {
    private int money;
    private List<Integer> numbers = new ArrayList<>();

    public void setMoney(String money) {
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    public void parseNumbers(String stringNumbers) {
        String[] parts = stringNumbers.split(",");
        for (String part : parts) {
            try {
                numbers.add(Integer.parseInt(part));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }
}

