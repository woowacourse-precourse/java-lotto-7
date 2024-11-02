package lotto;

import java.util.List;
import lotto.io.InputMessage;
import lotto.io.InputReader;
import lotto.io.OutputPrinter;

public class LottoApplication {

    private final InputReader inputReader;
    private final OutputPrinter outputPrinter;
    private final LottoGenerator lottoGenerator;

    public LottoApplication() {
        this.inputReader = new InputReader();
        this.outputPrinter = new OutputPrinter();
        this.lottoGenerator = new LottoGenerator();
    }

    public void run() {
        List<Lotto> lottos = purchaseLotto();
        List<Integer> winningNumbers = getWinningNumbers();
    }

    private List<Lotto> purchaseLotto() {
        InputMessage.purchaseAmount();
        long purchaseAmount = inputReader.readPurchaseAmount();
        List<Lotto> lottos = lottoGenerator.purchase(purchaseAmount);
        outputPrinter.printLottoCreated(lottos);

        return lottos;
    }

    private List<Integer> getWinningNumbers() {
        InputMessage.winningNumbers();
        return inputReader.readWinningNumbers();
    }

}
