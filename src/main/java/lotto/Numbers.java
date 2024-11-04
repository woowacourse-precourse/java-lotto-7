package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Numbers {
    private static List<Integer> randomNumbers;

    private void makeNumbers(){
        this.randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void sortNumbers(List<Integer> numbers){
        Collections.sort(numbers);
    }

    public Numbers(){
        makeNumbers();
        sortNumbers(randomNumbers);
    }

    public static List<Integer> get(){
        return randomNumbers;
    }



}
