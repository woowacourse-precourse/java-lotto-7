package lotto.service;

import lotto.domain.LottoNumberProvider;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

import java.util.List;
import java.util.Set;

public class LottoGame {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public LottoGame(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void issueLottoNumbers() {
        String purchaseAmount = inputReader.inputPurchaseAmount();

        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        purchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        int lottoCount = Integer.parseInt(purchaseAmount) / 10000;

        LottoNumberProvider lottoNumberProvider = new LottoNumberProvider();
        List<Set<Integer>> totalLottoNumbers = lottoNumberProvider.generateAndStoreLottoNumbers(lottoCount);
    }
}
