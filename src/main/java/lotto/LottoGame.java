package lotto;

import java.util.List;

public class LottoGame {
    private final UserInputLotto userInputLotto;
    private final LottoGeneration lottoGeneration;
    private final LottoCheck lottoCheck;
    private final OutputLottoResult outputLottoResult;
    private int[] lottoResult;
    private int totalPrize;

    public LottoGame() {
        this.userInputLotto = new UserInputLotto();
        this.lottoGeneration = new LottoGeneration();
        this.lottoCheck = new LottoCheck();
        this.outputLottoResult = new OutputLottoResult();
        this.lottoResult = new int[5];
        this.totalPrize = 0;
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
