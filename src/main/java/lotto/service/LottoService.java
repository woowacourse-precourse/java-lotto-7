package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoService {

    private static final Long THREE_NUMBER_PRICE = 5000L;
    private static final Long FOUR_NUMBER_PRICE = 50000L;
    private static final Long FIVE_NUMBER_PRICE = 1500000L;
    private static final Long FIVE_BONUS_NUMBER_PRICE = 30000000L;
    private static final Long SIX_NUMBER_PRICE = 2000000000L;

    // 당첨 통계 설정
    public void setWinningLottoCount(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            int winningNumberCount = lotto.getWinningNumberCount(lottos.getInputLottoNumbers(),
                    lottos.getBonusNumber());
            lottos.countUp(winningNumberCount);
        }
    }

    // 수익률 계산
    public double getRateOfReturn(Lottos lottos, int price) {
        int[] counts = lottos.getWinningLottoCounts();

        long sum = counts[3] * THREE_NUMBER_PRICE + counts[4] * FOUR_NUMBER_PRICE
                + counts[5] * FIVE_NUMBER_PRICE + counts[7] * FIVE_BONUS_NUMBER_PRICE
                + counts[6] * SIX_NUMBER_PRICE;

        double rateOfReturn = (double) sum / price;

        return Math.round(rateOfReturn * 100 * 100) / 100.0; // 소수점 둘째 자리에서 반올림
    }

    public void addLotto(Lottos lottos, int price) {
        for (int i = 0; i < price / 1000; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lotto));
        }
    }

}
