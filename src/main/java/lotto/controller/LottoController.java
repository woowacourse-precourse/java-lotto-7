package lotto.controller;

import dto.LottosDTO;
import lotto.model.AttemptCount;
import lotto.model.Lottos;
import lotto.util.GenerateNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GenerateNumbers generateNumbers;

    public LottoController(InputView inputView, OutputView outputView, GenerateNumbers generateNumbers) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generateNumbers = generateNumbers;
    }

    public void start() {
        int purchaseAmount = Integer.parseInt(inputView.readPurchaseAmount());
        AttemptCount attemptCount = new AttemptCount(purchaseAmount);
        Lottos lottos = new Lottos(attemptCount.getCount(), generateNumbers);

        LottosDTO lottosDTO = LottosDTO.from(lottos.getLottos());
        outputView.printLottos(lottosDTO);

    }
}
