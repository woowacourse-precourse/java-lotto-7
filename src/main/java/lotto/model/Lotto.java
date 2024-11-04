package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(Set<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers);
        validate(result);
        this.numbers = List.copyOf(result);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static Lotto createLotto(Set<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto createLottoByString(String input) {
        try {
            String[] numbers = input.split(",");
            List<Integer> numberList = new ArrayList<>();
            for (String s : numbers) {
                numberList.add(Integer.parseInt(s));
            }
            Set<Integer> numberSet = new HashSet<>(numberList);
            if (numberList.size() != numberSet.size()) {
                throw new IllegalArgumentException();
            }
            return new Lotto(numberSet);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException();
        }
    }

    public String getString() {
        return Arrays.toString(numbers.toArray());
    }

    public boolean validateBonusNumberIsDuplicated(int bonusNumber) {
        if (this.numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
