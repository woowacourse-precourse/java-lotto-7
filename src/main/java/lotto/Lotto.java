package lotto;

import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    
    public Lotto(List<Integer> numbers) {
        LottoValidator.validateNumbers(numbers); // 로또 유효성 검사
        this.numbers = numbers;
    }
    
    
    public List<Integer> getNumbers() {
        return numbers;
    }

}
