package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumber(numbers);
        this.numbers = ascendingSort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> duplicateNumber = new HashSet<>(numbers);
        if(duplicateNumber.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
        }
    }
    private void validateNumber(List<Integer> numbers){
        for(int number : numbers){
            new LottoNumber(number);
        }
    }
    private List<Integer> ascendingSort(List<Integer> numbers){
        List<Integer> ascendingNumbers = new ArrayList<>(numbers); // 수정 가능한 복사본 생성
        Collections.sort(ascendingNumbers);
        return ascendingNumbers;
    }
    public List<Integer> getNumbers(){
        return numbers;
    }

    // TODO: 추가 기능 구현
}
