package lotto.controller;

import java.util.List;
import lotto.domain.LottoPurchaseCalculator;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.util.RandomNumberGenerator;

public class LottoController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoPurchaseCalculator lottoManager;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler, RandomNumberGenerator randomNumberGenerator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoManager = new LottoPurchaseCalculator(randomNumberGenerator);
    }

    public void startLotto() {
        outputHandler.showLottoPrice();
        String price = inputHandler.price();
        int lottoCount = lottoManager.getLottoCount(price);
        outputHandler.showLottoCount(lottoCount);

        List<List<Integer>> lottoNumbers = lottoManager.generateLottoNumbers(lottoCount);
        for (List<Integer> numbers : lottoNumbers) {
            outputHandler.showLottoList(numbers);
        }
    }
}
