package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.io.InputView;
import lotto.score.Prize;

public class GameManager {
    private final InputView inputView;

    public GameManager() {
        inputView = new InputView();
    }

    public void start() {
        int price = readPrice();
        LottoShop lottoShop = new LottoShop();
        LottoJudge lottoJudge = new LottoJudge();
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        List<Lotto> lottos = lottoShop.buyLotto(price, randomLottoGenerator);
        LottoWinningSet lottoWinningSet = readWinningLottoSet();
        Map<Prize, Integer> LottoScore = new HashMap<>();
    }

    private int readPrice() {
        return Integer.parseInt(inputView.readPrice());
    }

    private LottoWinningSet readWinningLottoSet() {
        return new LottoWinningSet(readWinningNumber(), readVBonusNumber());
    }

    private List<Integer> readWinningNumber() {
        return Arrays.stream(inputView.readWinningNumber())
                .map(Integer::parseInt)
                .toList();
    }

    private int readVBonusNumber() {
        return Integer.parseInt(inputView.readBonusNumber());
    }
}

