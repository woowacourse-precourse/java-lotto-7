package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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
        if (numbers.stream().distinct().count() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        for(int num:numbers){
            if (num < 1 || num > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    public List<Integer> getNumbers(){
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public boolean containsNumber(int number){
        return numbers.contains(number);
    }

    public int matchNumber(List<Integer> otherNumbers){
        return (int) this.numbers.stream()
                .filter(otherNumbers::contains).count();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Lotto)) return false;
        Lotto other = (Lotto) obj;
        return numbers.equals(other.numbers);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
