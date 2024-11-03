package lotto.domain;

import lotto.domain.factory.LottoFactory;
import lotto.domain.score.Score;
import lotto.dto.LottosDto;
import lotto.dto.ScoreDto;

public class LottoMachine {

    private final LottoFactory lottoFactory;
    private final Score score;
    private Lottos lottos;

    public LottoMachine(LottoFactory lottoFactory, Score score) {
        this.lottoFactory = lottoFactory;
        this.score = score;
    }

    public void buyNumberOfLottos(int amount) {
        lottos = new Lottos(amount, lottoFactory);
    }

    public LottosDto getLottos() {
        return new LottosDto(lottos);
    }

    public ScoreDto getScore(Lotto winningLotto, BonusComponent bonusComponent) {
        return score.printScore(lottos, winningLotto, bonusComponent);
    }
}
