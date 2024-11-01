package lotto;

import lotto.constants.collection.ScoreSystem;
import lotto.constants.collection.ScoreSystemReward;
import lotto.constants.value.LottoRule;
import lotto.controller.LottoController;
import lotto.controller.LottoInputManger;
import lotto.controller.NumberLottoInputManger;
import lotto.domain.LottoMachine;
import lotto.domain.factory.NumberLottoFactory;
import lotto.domain.score.Score;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new NumberLottoInputManger(InputView.getInstance()),
                new LottoMachine(
                        new NumberLottoFactory(LottoRule.MINIMUM_NUMBER_RANGE.getInstance(),
                                               LottoRule.MAXIMUM_NUMBER_RANGE.getInstance(),
                                               LottoRule.COMBINATION_LENGTH.getInstance()),
                        new Score(ScoreSystem.DEFAULT.getInstance(),
                                  ScoreSystemReward.DEFAULT.getInstance())),
                OutputView.getInstance()
        );
    }
}
