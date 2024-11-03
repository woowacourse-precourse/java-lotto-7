package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoService {

    // 당첨 통계 설정
    public void setWinningLottoCount(Lottos lottoList) {
        for (Lotto lotto : lottoList.getLottoList()) {
            int winningNumberCount = lotto.getWinningNumberCount(lottoList.getInputLottoNumbers(),
                    lottoList.getBonusNumber());
            lottoList.countUp(winningNumberCount);
        }
    }

    // 수익률 계산
    public double getRateOfReturn(Lottos lottoList) {
        int[] counts = lottoList.getWinningLottoCounts();
        int size = lottoList.getInputLottoNumbers().size();

        long sum = counts[3] * 5000L + counts[4] * 50000L + counts[5] * 1500000L + counts[0] * 30000000L
                + counts[6] * 2000000000L;

        double rateOfReturn = (double) sum / (size * 1000);

        return Math.round(rateOfReturn * 100 * 100) / 100.0; // 소수점 둘째 자리에서 반올림
    }

    public List<Integer> addLotto(Lottos lottos) {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottos.add(new Lotto(lotto));
        return lotto;
    }

}
