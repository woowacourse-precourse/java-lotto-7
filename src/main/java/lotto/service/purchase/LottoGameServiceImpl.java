package lotto.service.purchase;

import java.util.Optional;
import lotto.domain.DrawTool;
import lotto.domain.Lotto;

public class LottoGameServiceImpl implements LottoGameService {

    private final DrawTool lottoMachine;

    public LottoGameServiceImpl(DrawTool lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public Optional<Lotto> register() {
        if(lottoMachine.gamesLeft()) {
            return Optional.of(new Lotto(lottoMachine.quickPicks()));
        }
        return Optional.empty();
    }
}
