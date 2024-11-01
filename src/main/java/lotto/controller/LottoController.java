package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.model.InputParser;
import lotto.model.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    public void startLottoSaleProcess() {
        InputParser inputParser = new InputParser();
        int purchaseAmount = getPurchaseAmount(inputParser);

        LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount);
        List<Lotto> generatedlottoList = lottoGenerator.getLottoList();

        outputView.displayLottoList(purchaseAmount, generatedlottoList);
    }

    public int getPurchaseAmount(InputParser inputParser) {
        while (true) {
            try {
                String purchaseAmount = inputView.readPurchaseAmount();
                return inputParser.parsePurchaseAmount(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
