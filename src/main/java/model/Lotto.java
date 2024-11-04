package model;

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
    private void getNumberValidate(int index){
        if(index < 1 || index > 6){
            throw new IllegalArgumentException("[ERROR] 로또는 1 ~ 6번째 자릿수만 존재합니다.");
        }
    }
    // TODO: 추가 기능 구현
    public Integer getNumber(int index){
        getNumberValidate(index);
        return numbers.get(index-1);
    }

    public String toString(){
        return numbers.toString();
    }
}
