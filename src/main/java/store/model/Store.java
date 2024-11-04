package store.model;

import java.util.List;

public class Store {

    private List<Integer> weeklyNumbers;

    private Integer bonusNumber;

    public List<Integer> getWeeklyNumbers() {
        return weeklyNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void updateWeeklyNumbers(List<Integer> weeklyNumbers) {
        this.weeklyNumbers = weeklyNumbers;
    }

    public void updateBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
