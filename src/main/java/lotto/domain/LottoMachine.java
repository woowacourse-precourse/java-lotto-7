package lotto.domain;

import lotto.constants.collection.ScoreSystem;
import lotto.domain.factory.LottoFactory;
import lotto.domain.score.Score;
import lotto.dto.ScoreDto;

public class LottoMachine {

    private LottoFactory lottoFactory;
    private Lottos lottos;
    private Score score;

    public LottoMachine() {
    }

    public void setLottoFactory(LottoFactory lottoFactory){
        this.lottoFactory = lottoFactory;
    }

    public void setScoreSystem(ScoreSystem scoreSystem){
        score = new Score(scoreSystem);
    }

    public void buyNumberOfLottos(int amount){
        lottos = new Lottos(amount,lottoFactory);
    }

    public ScoreDto getScore(Lotto winningLotto, BonusComponent bonusComponent){
        return score.printScore(lottos,winningLotto,bonusComponent);
    }
}
