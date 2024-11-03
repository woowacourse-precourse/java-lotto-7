package lotto.controller;

import static lotto.view.constant.Message.BONUS_START;
import static lotto.view.constant.Message.START;
import static lotto.view.constant.Message.STATISTICS;
import static lotto.view.constant.Message.WINNING_START;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Parser;
import lotto.domain.ScoreBoard;
import lotto.domain.Winning;
import lotto.dto.LottoResultDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Parser parser = new Parser();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void start() {
        outputView.printResult(START.getMessage());
        List<Lotto> lottos = pickLotto();
        outputView.printLottos(lottos);

        Winning winning = createWinning();

        ScoreBoard scoreBoard = new ScoreBoard(lottos, winning);
        outputView.printResult(STATISTICS.getMessage());
        List<LottoResultDto> lottoResultDtos = scoreBoard.returnStatistics();
        lottoResultDtos.forEach(s -> outputView.printResult(s.getDescription()));
        outputView.printResult(scoreBoard.getRate().getDescription());
    }

    private List<Lotto> pickLotto() {
        int count = inputView.inputCountFromCash();
        return lottoMachine.generateLottos(count);
    }

    private Winning createWinning() {
        List<Integer> winningNumber = getWinningNumber();
        int bonus = getBonusNumber();

        return new Winning(winningNumber, bonus);
    }

    private int getIntValue() {
        try {
            return parser.parseToInt(inputView.inputString());
        } catch (IllegalArgumentException e) {
            outputView.printResult(e.getMessage());
            return getIntValue();
        }
    }

    private List<Integer> getWinningNumber() {
        outputView.printResult(WINNING_START.getMessage());
        return parser.parseToIntList(inputView.inputString());
    }

    private int getBonusNumber() {
        outputView.printResult(BONUS_START.getMessage());
        return getIntValue();
    }

}
