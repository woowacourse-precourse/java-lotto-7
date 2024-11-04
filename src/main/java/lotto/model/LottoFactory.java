package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.Constants;
import lotto.dto.LottoPurchaseDTO;

public class LottoFactory {
    private final Lottos lottos;

    public LottoFactory(Lottos lottos) {
        this.lottos = lottos;
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Constants.RANDOM_MIN_NUM,
                Constants.RANDOM_MAX_NUM,
                Constants.LOTTO_NUMBER_COUNT);
        return randomNumbers;
    }

    private int calculateLottoCount(int price) {
        return price / Constants.LOTTO_PRICE;
    }

    public void createLottos(LottoPurchaseDTO lottoPurchaseDTO) {
        int lottoCount = calculateLottoCount(lottoPurchaseDTO.getPrice());

        for(int i=0; i<lottoCount; i++) {
            Lotto lotto = new Lotto(createRandomNumbers());
            lottos.addLotto(lotto);
        }
    }

    public String checkLottos() {
        return lottos.toString();
    }
}
