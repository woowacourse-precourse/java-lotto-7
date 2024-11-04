package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.common.Constants;
import lotto.dto.LottoPurchaseDTO;

public class LottoFactory {
    private final Lottos lottos;

    public LottoFactory(Lottos lottos) {
        this.lottos = lottos;
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.addAll(Randoms.pickUniqueNumbersInRange(Constants.RANDOM_MIN_NUM,
                Constants.RANDOM_MAX_NUM,
                Constants.LOTTO_NUMBER_COUNT));
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    public Lottos createLottos(LottoPurchaseDTO lottoPurchaseDTO) {
        int lottoCount = lottoPurchaseDTO.getLottoCount();

        for(int i=0; i<lottoCount; i++) {
            Lotto lotto = new Lotto(createRandomNumbers());
            lottos.addLotto(lotto);
        }

        return lottos;
    }

    public WinningLotto createWinningLotto(LottoPurchaseDTO lottoPurchaseDTO) {
        WinningLotto winningLotto = new WinningLotto(lottoPurchaseDTO.getLottoNumbers(), lottoPurchaseDTO.getBonusNumber());
        return winningLotto;
    }

    public String checkLottos() {
        return lottos.toString();
    }
}
