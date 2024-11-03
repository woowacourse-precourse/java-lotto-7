package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    // LottoTest를 수정하지 않기 위해 접근지정자 유지
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createUserLotto(List<Integer> numbers){
        return new Lotto(numbers);
    }

    public static Lotto createWinningLotto(List<Integer> numbers){
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        validateRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현

    private void validateSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUnique(List<Integer> numbers){
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if(numbers.stream().anyMatch(integer -> integer < 0 || integer >45)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
        }
    }
}
