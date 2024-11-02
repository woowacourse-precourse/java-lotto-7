package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isSixNumbers(numbers);
        isDuplicatedNumber(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    private void isSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 수를 입력하셔야 합니다.");
        }
    }

    private void isDuplicatedNumber(List<Integer> numbers) {
        boolean hasDuplicates = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (hasDuplicates) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers){
        return numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
