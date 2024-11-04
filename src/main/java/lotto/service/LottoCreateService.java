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

    private Lottos createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = createRandomNumbers();
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
            LottoConstant.LOTTO_NUMBER_MIN,
            LottoConstant.LOTTO_NUMBER_MAX,
            LottoConstant.LOTTO_NUMBER_COUNT
        );
    }

    public Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public WinningLotto createWinningLotto(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }
}
