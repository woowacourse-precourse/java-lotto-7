package lotto.purchase;

import java.util.ArrayList;
import java.util.List;

public record MyLotto(List<Integer> numbers) {

    public int countMatches(List<Integer> winningLotto) {
        List<Integer> myLottoNumbers = new ArrayList<>(numbers);
        myLottoNumbers.retainAll(winningLotto);
        return myLottoNumbers.size();
    }
}
