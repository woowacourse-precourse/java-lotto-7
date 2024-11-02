package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.score.Prize;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    public GameManager() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        outputView.printPurchaseInputMessage();
        int price = readPrice();
        LottoShop lottoShop = new LottoShop();
        LottoJudge lottoJudge = new LottoJudge();
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        YieldCalculator yieldCalculator = new YieldCalculator();
        List<Lotto> lottos = lottoShop.buyLotto(price, randomLottoGenerator);
        outputView.printLottos(lottos);
        LottoWinningSet lottoWinningSet = readWinningLottoSet();
        Map<Prize, Integer> lottoScore = lottoJudge.calculateLottoScore(lottos, lottoWinningSet);
        int prizeMoney = yieldCalculator.calculatePrizeMoney(lottoScore);
    }

    private int readPrice() {
        return Integer.parseInt(inputView.readPrice());
    }

    private LottoWinningSet readWinningLottoSet() {
        return new LottoWinningSet(readWinningNumber(), readBonusNumber());
    }

    private List<Integer> readWinningNumber() {
        return Arrays.stream(inputView.readWinningNumber())
                .map(Integer::parseInt)
                .toList();
    }

    private int readBonusNumber() {
        return Integer.parseInt(inputView.readBonusNumber());
    }
}

