package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.io.InputView;

public class GameManager {
    private InputView inputView;

    public GameManager() {
        inputView = new InputView();
    }

    public void start() {
        int price = readPrice();
        LottoShop lottoShop = new LottoShop();
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        List<Lotto> lottos = lottoShop.buyLotto(price, randomLottoGenerator);
        LottoWinningSet lottoWinningSet = readWinningLottoSet();
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

