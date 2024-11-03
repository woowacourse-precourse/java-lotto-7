package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);  // 불변성을 위해 새로운 리스트 반환
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

    }

    // TODO: 추가 기능 구현
    public int countMatchNumbers(Lotto winningLotto) {
        int matchCount = 0;
        List<Integer> winningNumbers = winningLotto.getNumbers();

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
    public boolean checkBonus(int number) {
        for(int num : numbers){
            if(num == number){
                return true;
            }
        }
        return false;
    }
}
