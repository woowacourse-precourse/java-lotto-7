package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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

        HashSet<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 값이 있습니다.");
        }
    }

    public WinningCount countWinningNumber(List<Integer> winningNumbers, int bonusNumber){
        int count = 0;

        for (int idx = 0; idx < numbers.size(); idx++) {
            if(winningNumbers.contains(numbers.get(idx))){
                count++;

            }
        }
        boolean isBonusNumberMatched = checkBonusNumberMatch(bonusNumber);

        if(isBonusNumberMatched){
            count++;
        }

        return WinningCount.from(count, isBonusNumberMatched);
    }

    private boolean checkBonusNumberMatch(int bonusNumber){
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
