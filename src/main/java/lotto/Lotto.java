package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public final static int LOW_NUMBER = 1;
    public final static int HIGH_NUMBER = 45;

    private int bonus;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        if(bonus < LOW_NUMBER || bonus > HIGH_NUMBER){
            throw new IllegalArgumentException("[ERROR]: 보너스 숫자는 " + LOW_NUMBER + "~ " + HIGH_NUMBER + "이어야 합니다.");
        }
        if(getNumbers().contains(bonus)){
            throw new IllegalArgumentException("[ERROR]: 로또 번호중에 보너스 번호와 겹치는 번호가 있습니다.");
        }
        this.bonus = bonus;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validAll(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    private void validRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOW_NUMBER || number > HIGH_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자는 " + LOW_NUMBER
                        + "~" + HIGH_NUMBER + " 사이의 숫자이어야 합니다.");
            }
        }
    }

    private void checkDuplicated(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private void validAll(List<Integer> numbers) {
        validate(numbers);
        validRange(numbers);
        checkDuplicated(numbers);
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
