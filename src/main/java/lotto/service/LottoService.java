package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottosGenerator;
import lotto.domain.NumbersGenerator;
import lotto.domain.PurchaseLottos;
import lotto.domain.RandomNumbersGenerator;
import lotto.domain.WinningCalculator;
import lotto.domain.WinningResult;
import lotto.dto.LottoResult;
import lotto.dto.PurchaseLotto;

public class LottoService {
    private final LottosGenerator lottosGenerator;
    private final PurchaseLottos purchaseLottos;
    private final WinningCalculator winningCalculator;

    public LottoService() {
        NumbersGenerator numbersGenerator = new RandomNumbersGenerator();
        this.lottosGenerator = new LottosGenerator(numbersGenerator);
        this.purchaseLottos = new PurchaseLottos();
        this.winningCalculator = new WinningCalculator();
    }

    public PurchaseLotto purchase(int amount) {
        List<Lotto> lottos = purchaseLottos.saveAll(lottosGenerator.generate(amount));
        winningCalculator.saveLottos(purchaseLottos);
        Integer lottoCount = purchaseLottos.findLottoCount();
        return PurchaseLotto.of(lottos, lottoCount);
    }

    public void registerWinningLotto(List<Integer> winnerNumber) {
        Lotto lotto = new Lotto(winnerNumber);
        winningCalculator.saveWinningLotto(lotto);
    }

    public void registerBonusNumber(int number) {
        winningCalculator.saveBonusNumber(number);
    }

    public LottoResult getWinningResult() {
        WinningResult winningResult = winningCalculator.calculate();
        return LottoResult.of(winningResult.getResult(), winningResult.getProfit(purchaseLottos.purchaseAmount()));
    }
}
