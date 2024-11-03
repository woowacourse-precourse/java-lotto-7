package lotto.model;

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

    public int countMatchingNumbers(List<Integer> winningNumbers){
        int matchCount = 0;
        for(int number : numbers){
            if(winningNumbers.contains(number)){
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean matchingBonusNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }
    @Override
    public String toString() { //객체 안에 든 값을 문자열로 변환하기 위해
        return numbers.toString();
    }

}
