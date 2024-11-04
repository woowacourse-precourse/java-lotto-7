package lotto.domain;

import java.util.Collections;
import java.util.List;

public class UserLotto extends Lotto {
    public UserLotto(List<Integer> numbers) {
        super(numbers);
        sortLottoNumbers(numbers);
    }

    private void sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
