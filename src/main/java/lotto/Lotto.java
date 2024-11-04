package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        checkSize(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        this.numbers = Collections.unmodifiableList(mutableNumbers);
    }

    private void checkSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.toString());
        }
    }

    private void checkDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> duplicationCheck = new HashSet<>();
        for (Integer number : numbers) {
            if (!duplicationCheck.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.toString());
            }
        }
    }

    private void checkRange(List<Integer> numbers) throws IllegalArgumentException {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.toString());
            }
        }
    }

    public String getNumberString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }

    public int countMatches(List<Integer> winningNumberList) {
        int count = 0;
        for (Integer number : this.numbers) {
            if (winningNumberList.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
