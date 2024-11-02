package lotto.controller;

import lotto.service.LottoGame;
import lotto.view.InputReader;

public class LottoController {

    private final InputReader inputReader;

    public LottoController(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public void startLotto() {
        LottoGame lottoGame = new LottoGame(inputReader);
        lottoGame.issueLottoNumbers();
    };
}
