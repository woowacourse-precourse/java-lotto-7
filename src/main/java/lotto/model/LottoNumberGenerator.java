package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private List<Integer> lottoNumbers;

    public List<Integer> generateNumbers() {
        this.lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortNumbers(lottoNumbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return List.copyOf(sortedNumbers);  // 불변 리스트로 반환
    }
}
