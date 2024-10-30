package lotto.domain;

import java.util.TreeSet;

public class Lotto {
    private final TreeSet<Integer> numbers;

    public Lotto(TreeSet<Integer> numbers) {
        isSixDifferentNumbers(numbers);
        this.numbers = numbers;
    }

    private void isSixDifferentNumbers(TreeSet<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException("6개의 서로 다른 수를 입력하셔야 합니다.");
        }
    }

    public boolean contains(int number){
        return this.numbers.contains(number);
    }
}
