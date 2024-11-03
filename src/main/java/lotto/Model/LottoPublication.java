package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPublication {

    public List<Integer> lottoNumberPublication() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<Integer> getSortedLottoNumbers() {
        List<Integer> numbers = lottoNumberPublication();
        Collections.sort(numbers);
        return numbers;
    }

    public List<List<Integer>> totalLotto(int count) {
        List<List<Integer>> publicationNumbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            publicationNumbers.add(getSortedLottoNumbers());
        }

        return publicationNumbers;
    }
}
