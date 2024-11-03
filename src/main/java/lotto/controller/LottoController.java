package lotto.controller;

import lotto.constants.value.LottoRule;
import lotto.domain.BonusComponent;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.dto.LottosDto;
import lotto.dto.ScoreDto;
import lotto.view.OutputView;

import java.util.function.Supplier;

public class LottoController {

    private final LottoInputManger inputManger;
    private final LottoMachine lottoMachine;
    private final OutputView outputView;

    public LottoController(LottoInputManger inputManger, LottoMachine lottoMachine, OutputView outputView) {
        this.inputManger = inputManger;
        this.lottoMachine = lottoMachine;
        this.outputView = outputView;
    }

    /**
     * Error는 사용자의 입력이 동반 된 작업에만 발생할 수 있습니다.
     * 따라서, ErrorCatcher는 사용자의 입력을 받는 경우에만 적용됩니다.
     */
    public void play() {
        int inputPrice = ErrorCatcher(inputManger::getInputPrice);
        int lottoBuyAmount = inputPrice / LottoRule.LOTTO_PRICE.getInstance();

        lottoMachine.buyNumberOfLottos(lottoBuyAmount);
        LottosDto lottosDto = lottoMachine.getLottos();
        outputView.printBoughtLottos(lottosDto);

        Lotto winningComponents = ErrorCatcher(inputManger::getInputWinningComponent);
        BonusComponent bonusComponent = ErrorCatcher(() -> inputManger.getInputBonusComponent(winningComponents));

        ScoreDto scoreDto = lottoMachine.getScore(winningComponents, bonusComponent);
        outputView.printScoreResult(scoreDto);
    }


    private <T> T ErrorCatcher(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
