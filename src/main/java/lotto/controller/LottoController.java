package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.validation.InputValidator;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final InputValidator inputValidator;
    private final LottoService lottoService;

    public LottoController(InputView inputView, InputValidator inputValidator, LottoService lottoService) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.lottoService = lottoService;
    }

    public void lottoPlay() {
        while (true) {
            try {
                List<Lotto> lottos = lottoService.generateLottos(inputValidator.validate(inputView.userInput()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
