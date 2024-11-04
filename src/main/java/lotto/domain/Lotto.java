package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateLottoNumberRange(List<Integer> numbers){
        numbers.stream().forEach(element->{
            if(element < 1 || element > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 내의 숫자여야 합니다.");
            }
        });
    }

    private void validateLottoNumberIsInteger(List<Integer> numbers){
        numbers.stream().forEach(element->{
            if(!(element instanceof Integer)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 정수만 입력 가능합니다.");
            }
        });
    }

    private void validateLottoNumberIsDuplicated(List<Integer> numbers){
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if(numbersSet.size() < numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호는 입력이 불가합니다.");
        }
    }

    private void validateLottoNumber(List<Integer> numbers){
        try{
            validateLottoSize(numbers);
            validateLottoNumberRange(numbers);
            validateLottoNumberIsInteger(numbers);
            validateLottoNumberIsDuplicated(numbers);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}