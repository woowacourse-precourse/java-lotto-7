package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Numbers {
    private List<Integer> numbers;

    private void makeNumbers(){
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void sortNumbers(List<Integer> numbers){
        Collections.sort(numbers);
    }

    public void Numbers(){
        makeNumbers();
        sortNumbers(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
