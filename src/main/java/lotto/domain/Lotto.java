package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers); // 가변 리스트로 복사
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> lotto_numbers = new HashSet<>();
        for (int number : numbers) {
            if (!lotto_numbers.add(number)) throw new IllegalArgumentException("[ERROR] 로또에 중복된 숫자가 없어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean check_Bonus_Number(int bonus_number) {
        if(numbers.contains(bonus_number)) return true;
        return false;
    }

}
