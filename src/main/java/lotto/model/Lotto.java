package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoDetails(){
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers){
        for (int number : numbers){
            if (number<0 || number>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 이어야 합니다.");
            }
        }
    }
}
