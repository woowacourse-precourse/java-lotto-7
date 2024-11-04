package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        List<Integer> numbersforvalidate = new ArrayList<>(numbers);
        for(int i = 0; i < numbers.size(); i++) {
            if(!numbersforvalidate.contains(numbers.get(i))) {
                numbers.remove(numbers.get(i));
            }
            else {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int containCount(List<Integer> winnings) {
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++) {
            if(winnings.contains(numbers.get(i))) {
                sum++;
            }
        }
        return sum;
    }

    public boolean containBonus(int bonus) {
        return numbers.contains(bonus);
    }
}
