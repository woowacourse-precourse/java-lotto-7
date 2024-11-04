package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottoCreateService {

    public Lottos createLottosWithMoney(int money) {
        int lottoCount = money / LottoConstant.LOTTO_PRICE;
        return createLottos(lottoCount);
    }

    public Lottos createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = createRandomNumbers();
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }

    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
            LottoConstant.LOTTO_NUMBER_MIN,
            LottoConstant.LOTTO_NUMBER_MAX,
            LottoConstant.LOTTO_NUMBER_COUNT
        );
    }

    public WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }
}
