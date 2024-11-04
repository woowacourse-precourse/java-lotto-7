package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Rank rank;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Rank getRank() {
        return rank;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void checkForWinning(List<Integer> inputNumbers, Integer specNum) {
        numbers.retainAll(inputNumbers);
        int matchedNum = numbers.size();
        rank = ranking(matchedNum, specNum);
    }

    private Rank ranking(int matchedNum, Integer specNum) {
        if (matchedNum >= 6) {
            return Rank.FIRST;
        }
        if (matchedNum == 5) {
            if (numbers.contains(specNum)) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        }
        if (matchedNum >= 4) {
            return Rank.FOURTH;
        }
        if (matchedNum >= 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    public void printNumbers() {
        System.out.println(numbers);
    }
}
