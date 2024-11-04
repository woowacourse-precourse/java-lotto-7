package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String NUMBER_RANGE_OVER = "[ERROR] 숫자는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NUMBER_SIZE_WRONG = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String NUMBER_OVERLAP = "[ERROR] 로또 번호에 중복이 있습니다.";

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
            System.out.println(NUMBER_SIZE_WRONG);
            throw new IllegalArgumentException();
        }
        if(checkForDuplicates(numbers)){
            System.out.println(NUMBER_OVERLAP);
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
                System.out.println(NUMBER_RANGE_OVER);
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkForBonusNumberDuplicates(int bonus){
        Set<Integer> duplicationReMove = new HashSet<>(this.numbers);
        duplicationReMove.add(bonus);
        if(duplicationReMove.size() != numbers.size() + 1){

            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }


}
