package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<Integer> numbers;
    private int bonusNumber;

    public WinningLotto() {
        this.numbers = new ArrayList<>();
        this.bonusNumber = 0;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
