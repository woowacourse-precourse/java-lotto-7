package lotto.Model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int sameNumCount(List<Integer> winNumbers) {
        int count = 0;
        for (Integer number : this.numbers) {
            if (winNumbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean checkBonus(int bonusNum) {
        return numbers.contains(bonusNum);
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
