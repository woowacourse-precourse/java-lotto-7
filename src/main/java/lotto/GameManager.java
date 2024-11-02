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
        LottoSet lottoSet = lottoShop.buyLotto(price, randomLottoGenerator);
    }

    private int readPrice() {
        return Integer.parseInt(inputView.readPrice());
    }

    private List<Integer> readWinningNumber() {
        return Arrays.stream(inputView.readWinningNumber())
                .map(Integer::parseInt)
                .toList();
    }
}

