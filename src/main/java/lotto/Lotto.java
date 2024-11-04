package lotto;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int compareNumberWithTicket(List<Integer> numbersInTicket) {
        int matchingNumerCount = 0;

        for (int i = 0; i < 6; i++) {
            if (numbersInTicket.contains(numbers.get(i))) {
                matchingNumerCount++;
            }
        }

        return matchingNumerCount;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        checkEachNumberIsUnique(numbers);
    }

    private void checkEachNumberIsUnique(List<Integer> numbers) {
        Set<Integer> usedToken = new HashSet<>();

        for (Integer number : numbers) {

            if (usedToken.contains(number)) {
                throw new IllegalArgumentException();
            }

            usedToken.add(number);
        }
    }
}
