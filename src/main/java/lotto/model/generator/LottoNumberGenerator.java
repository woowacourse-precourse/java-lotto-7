package lotto.model.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generateLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return sortNumbers(new ArrayList<>(lottoNumbers));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);

        return numbers;
    }
}
