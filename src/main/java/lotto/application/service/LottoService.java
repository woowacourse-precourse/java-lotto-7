package lotto.application.service;

import java.util.ArrayList;
import java.util.List;
import lotto.application.in.LottoUseCase;
import lotto.application.out.LottoGeneratorPort;
import lotto.config.context.annotation.Service;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoRound;
import lotto.domain.LottoRoundResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;

@Service
public class LottoService implements LottoUseCase {

    private final LottoGeneratorPort lottoGeneratorPort;

    public LottoService(LottoGeneratorPort lottoGeneratorPort) {
        this.lottoGeneratorPort = lottoGeneratorPort;
    }

    @Override
    public LottoRound buyLotto(PurchaseAmount purchaseAmount) {
        return new LottoRound(generateLotto(purchaseAmount));
    }

    @Override
    public LottoRoundResult checkResult(LottoRound round, WinningNumber winningNumber, BonusNumber bonusNumber) {
        return new LottoRoundResult(round.getMatchResult(winningNumber, bonusNumber));
    }

    private List<Lotto> generateLotto(PurchaseAmount purchaseAmount) {
        List<Lotto> generated = new ArrayList<>();
        for (int index = 0; index < purchaseAmount.getAmount(); index += Lotto.PRICE) {
            generated.add(lottoGeneratorPort.generate());
        }

        return generated;
    }
}
