package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.common.LottoConstants;
import lotto.domain.Lotto;

public class LottoNumberGenerator {
    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.NUMBER_START,
                LottoConstants.NUMBER_END,
                LottoConstants.SIZE);

        List<Integer> lottoNumbers = new ArrayList<>(randomNumbers);
        lottoNumbers.sort(Integer::compareTo);
        return new Lotto(lottoNumbers);
    }
}
