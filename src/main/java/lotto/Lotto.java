package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    
    private void checkDuplicate(List<Integer> numbers) {
    	Set<Integer> lottoSet = new HashSet<>(numbers);
    	if(lottoSet.size() < numbers.size()) {
    		throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
    	}
    }
    
    public List<Integer> getLottoNumber(){
    	return this.numbers;
    }
}
