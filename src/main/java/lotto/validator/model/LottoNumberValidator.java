package lotto.validator.model;

import lotto.validator.Validator;

import java.util.HashSet;
import java.util.List;

// 로또 번호 검증 클래스
public class LottoNumberValidator implements Validator {
    private final List<Integer> numbers;

    public LottoNumberValidator(List<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public void validate(){
        isDuplicated();
        isValidCount();
        isValidNumbers();
    }

    private void isDuplicated(){
        if(numbers.size() > new HashSet<>(numbers).size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호 6개는 중복 될 수 없습니다.");
        }
    }

    private void isValidCount(){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void isValidNumbers(){
        for(int number: numbers){
            isInRange(number);
        }
    }

    private void isInRange(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자이어야 합니다.");
        }
    }
}
