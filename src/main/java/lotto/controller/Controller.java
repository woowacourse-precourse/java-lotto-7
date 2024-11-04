package lotto.controller;

import static lotto.view.constant.Message.STATISTICS;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.ScoreBoard;
import lotto.domain.Winning;
import lotto.dto.LottoResultDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void start() {
        List<Lotto> lottos = pickLottos();
        outputView.printResult(" ");
        outputView.printLottos(lottos);
        outputView.printResult(" ");
        Winning winning = createWinning();
        outputView.printResult(" ");

        ScoreBoard scoreBoard = new ScoreBoard(lottos, winning);

        displayLottoDraw(scoreBoard);
    }

    private List<Lotto> pickLottos() {
        int count = inputView.inputCountFromCash();
        return lottoMachine.generateLottos(count);
    }

    private Winning createWinning() {
        Winning winning = inputView.inputWinningNumbers();
        outputView.printResult(" ");
        return inputView.inputBonusNumber(winning);
    }

    private void displayLottoDraw(ScoreBoard scoreBoard) {
        outputView.printMessage(STATISTICS);
        List<LottoResultDto> lottoResultDtos = scoreBoard.returnStatistics();
        lottoResultDtos.forEach(lottoResultDto -> outputView.printResult(lottoResultDto.getDescription()));
        outputView.printResult(scoreBoard.getRate().getDescription());
    }

}
