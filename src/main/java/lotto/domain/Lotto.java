package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream()
                .anyMatch(number -> number < 1 || number > 45)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public int countMatchedNumbers(Lotto other){
        return (int) numbers.stream()
                .filter(other.getNumbers()::contains)
                .count();
    }

    public boolean containsNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }

}
