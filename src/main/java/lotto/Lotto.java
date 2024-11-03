package lotto;

import java.util.Collections;
import java.util.LinkedList;
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
    // TODO: 추가 기능 구현
    public void printNumbers(){
        System.out.println(numbers.toString());
    }
    public void sortNumbers(){
        Collections.sort(numbers);
    }
    public int getRetainAllSize(List<Integer> winningNumbers){
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
