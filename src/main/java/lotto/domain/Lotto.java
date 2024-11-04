package lotto.domain;

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
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        int count = 0;  // 일치하는 번호의 개수를 저장할 변수

        for (Integer number : numbers) {  // numbers 리스트의 각 번호를 순회
            if (winningNumbers.contains(number)) {  // winningNumbers 리스트에 현재 번호가 포함되어 있는지 체크
                count++;  // 포함되어 있다면 카운트 증가
            }
        }

        return count;  // 일치하는 번호의 개수를 반환
    }
}
