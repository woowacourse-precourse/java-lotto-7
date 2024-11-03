package lotto.controller;

import lotto.service.LottoGame;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

public class LottoController {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public LottoController(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void startLotto() {
        LottoGame lottoGame = new LottoGame(inputReader, outputWriter);
        lottoGame.issueLottoNumbers();
        lottoGame.convertAndValidateWinningNumbers();
    }
}
