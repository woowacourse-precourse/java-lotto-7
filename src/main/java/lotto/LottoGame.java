package lotto;

import java.util.List;

public class LottoGame {
    private final UserInputLotto userInputLotto;
    private final LottoGeneration lottoGeneration;

    public LottoGame() {
        this.userInputLotto = new UserInputLotto();
        this.lottoGeneration = new LottoGeneration();
    }

    public void strat() {
        List<Lotto> purchaseAmount = initGame();
        List<Integer> winningNumbers = userInputLotto.inputPrizeNumbers();
    }

    private List<Lotto> initGame() {
        int purchaseAmount = userInputLotto.purchaseAmount();
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> purchasedLottos = lottoGeneration.generateLottoLines(lottoCount);

        return purchasedLottos;
    }
}
