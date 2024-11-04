package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    //numbers는 곧 당첨 번호
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45 까지입니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
