package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
    private final Integer lottoCount;
    private final List<List<Integer>> lottoNumbers = new ArrayList<>();

    public LottoNumberGenerator(Integer lottoCount) {
        this.lottoCount = lottoCount;
    }

    public List<List<Integer>> generateLotto() {
        if (lottoNumbers.size() > 0) {
            return lottoNumbers;
        }

        for(int i = 0; i < lottoCount; i++){
            lottoNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottoNumbers;
    }
}
