package lotto;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public boolean checkDuplicateWithBonusNumber(int bonusNum){
        if(numbers.contains(bonusNum)){
            return true;
        }
        return false;
    }

    public int findDuplicateNum(List<Integer> winningNumber){

        List<Integer> matchNum = this.numbers.stream().filter(o -> winningNumber.stream()
                .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());

        return matchNum.size();
    }




}
