package lotto.application.service;

import java.util.ArrayList;
import java.util.List;
import lotto.application.in.LottoUseCase;
import lotto.application.out.LottoGeneratorPort;
import lotto.config.context.annotation.Service;
import lotto.domain.core.Lotto;
import lotto.domain.input.BonusNumber;
import lotto.domain.input.PurchaseAmount;
import lotto.domain.input.WinningNumber;
import lotto.domain.round.LottoRound;
import lotto.domain.round.LottoRoundResult;

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
