package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정렬된 상태로 입력되어야 합니다.");
        }
        if (numbers.getFirst() < 1 || numbers.getLast() > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 이상 45 이하여야 합니다.");
        }
    }

    public static Lotto generateLotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        return new Lotto(sortedNumbers);
    }

    public Prize checkWin(List<Integer> winningNumber, int bonusNumber) {
        int result = 0;
        for (Integer i : winningNumber) {
            if (numbers.contains(i)) result++;
        }
        boolean bonusTaken = numbers.contains(bonusNumber);
        if (result == 6) return Prize.FIRST_PLACE;
        else if (result == 5 && bonusTaken) return Prize.SECOND_PLACE;
        else if (result == 5) return Prize.THIRD_PLACE;
        else if (result == 4) return Prize.FOURTH_PLACE;
        else if (result == 3) return Prize.FIFTH_PLACE;
        return Prize.NOTHING;
    }

    public void printNumber(){
        System.out.println(numbers);
    }

    boolean isSorted() {
        return numbers.equals(numbers.stream().sorted().toList());
    }
}
