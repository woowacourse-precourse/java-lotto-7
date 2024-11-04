package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkNumberRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public void outputLottoNumbers(){
        System.out.println(Arrays.toString(this.numbers.stream().toArray()));
    }

    public int MatchCount(Lotto winningNumbers){
        return (int)this.numbers.stream()
                .filter(winningNumbers ::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(OutputView.NUMBER_SIZE_WRONG);
            throw new IllegalArgumentException();
        }
        if(checkForDuplicates(numbers)){
            System.out.println(OutputView.NUMBER_OVERLAP);
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    private boolean checkForDuplicates(List<Integer>numbers){
        Set<Integer> duplicationReMove = new HashSet<>(numbers);
        return duplicationReMove.size() != numbers.size();
    }
    private void checkNumberRange(List<Integer>Numbers){
        for (int number : Numbers) {
            if(number > 45 || number < 1){
                System.out.println(OutputView.NUMBER_RANGE_OVER);
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkForBonusNumberDuplicates(int bonus){
        Set<Integer> duplicationReMove = new HashSet<>(this.numbers);
        duplicationReMove.add(bonus);
        if(duplicationReMove.size() != numbers.size() + 1){
            System.out.println(OutputView.BONUS_NUMBER_OVERLAP);
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }


}
