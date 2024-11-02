package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.WinningNumbers;
import lotto.io.OutputHandler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoGame {
    private final static int LOTTO_PRICE = 1000;
    private final Lottos lottos = new Lottos();
    private int buyingPrice;

    public int buyLottos(int buyingPrice) {
        this.buyingPrice = buyingPrice;
        int lottoCount = getLottoCount(buyingPrice);

        createLottos(lottoCount);

        return lottos.getSize();
    }

    private int getLottoCount(int lottoPrice) {
        int lottoCount = lottoPrice / LOTTO_PRICE;
        OutputHandler.printLottoCount(lottoCount);
        return lottoCount;
    }

    private void createLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            createLottoNumbers();
        }
        lottos.printLottos();
    }

    private void createLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        lottos.addLotto(lotto);
    }

    public void start(WinningNumbers winningNumbers) {
        LottoPrizeRecord lottoPrizeRecord = lottos.checkLottos(winningNumbers);
        lottoPrizeRecord.printResult();
        int totalWinningPrice = lottoPrizeRecord.computeWinningPrice();

        computeYield(totalWinningPrice);
    }

    private void computeYield(int totalWinningPrice) {
        double yield = (double) totalWinningPrice / this.buyingPrice;
        OutputHandler.printYield(yield);
    }
}
