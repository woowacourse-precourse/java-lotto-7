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
        outputView.printLottos(lottos);

        Winning winning = createWinning();

        ScoreBoard scoreBoard = new ScoreBoard(lottos, winning);
        outputView.printMessage(STATISTICS);
        List<LottoResultDto> lottoResultDtos = scoreBoard.returnStatistics();
        lottoResultDtos.forEach(s -> outputView.printResult(s.getDescription()));
        outputView.printResult(scoreBoard.getRate().getDescription());
    }

    private List<Lotto> pickLottos() {
        int count = inputView.inputCountFromCash();
        return lottoMachine.generateLottos(count);
    }

    private Winning createWinning() {
        Winning winning = inputView.inputWinningNumbers();
        return inputView.inputBonusNumber(winning);
    }

}
