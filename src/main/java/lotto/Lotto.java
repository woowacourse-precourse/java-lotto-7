package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
        hasDuplicate(numbers);
    }

    private void hasDuplicate(List<Integer> numbers) {
        ArrayList<Integer> list = new ArrayList<>(numbers);
        HashSet<Integer> hashSet = new HashSet<>(numbers);
        if(list.size() != hashSet.size())
            throw new IllegalArgumentException("중복되는 번호가 있습니다.");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
