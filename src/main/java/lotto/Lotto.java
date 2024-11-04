package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException{
        Set<Integer> checkDuplication = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("\n[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if(checkDuplication.size() != numbers.size()){
            throw new IllegalArgumentException("\n[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
    // TODO: 추가 기능 구현
    public String getList(){
        return numbers.toString();
    }
    public int getMatchedSize(List<Integer> winningNumbers){
        List<Integer> currentNumbers = new LinkedList<>(numbers);
        currentNumbers.retainAll(winningNumbers);

        return currentNumbers.size();
    }
    public boolean hasBonusNumber(int bonusNumber){
        if(numbers.contains(bonusNumber))
            return true;
        return false;
    }
}
