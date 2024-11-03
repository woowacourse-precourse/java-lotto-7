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
import lotto.view.InputViewImpl;
import lotto.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {

        /**
         * 로또 머신을 초기화 합니다, 로또 머신은 실제 기계를 상상하시면 됩니다.
         * 숫자 기반 로또를 만들어 줄 펙토리가 주입 됩니다. 이때 숫자의 범위와 로또 길이가 설정됩니다.
         * 로또 당첨 Score 시스템이 주입 됩니다. 이때 점수 시스템과 그에 맞는 보상 제도가 주입됩니다.
         */
        LottoMachine lottoMachine = new LottoMachine(
                new NumberLottoFactory(
                        LottoRule.MINIMUM_NUMBER_RANGE.getInstance(),
                        LottoRule.MAXIMUM_NUMBER_RANGE.getInstance(),
                        LottoRule.COMBINATION_LENGTH.getInstance()),
                 new Score(
                         ScoreSystem.DEFAULT.getInstance(),
                         ScoreSystemReward.DEFAULT.getInstance()));


        //숫자 기반 로또를 위한 입력값 매니저를 초기화합니다
        LottoInputManger lottoInputManger = new NumberLottoInputManger(
                InputViewImpl.getInstance());


        //컨트롤러에 필요한 것을 모두 주입합니다.
        LottoController lottoController = new LottoController(
                lottoInputManger,
                lottoMachine,
                OutputViewImpl.getInstance());

        lottoController.play();
    }
}
