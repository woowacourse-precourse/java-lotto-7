package lotto.purchase;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {

    private final List<Integer> numbers;

    public MyLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int countMatches(List<Integer> winningLotto) {
        List<Integer> myLottoNumbers = new ArrayList<>(numbers);
        myLottoNumbers.retainAll(winningLotto);
        return myLottoNumbers.size();
    }
}
