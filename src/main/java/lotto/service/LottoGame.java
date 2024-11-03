package lotto.service;

import lotto.domain.LottoNumberProvider;
import lotto.domain.TypeConverter;
import lotto.validator.Lotto;
import lotto.validator.PurchaseAmount;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

import java.util.List;
import java.util.Set;

public class LottoGame {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private List<Integer> winningNumbers;

    public LottoGame(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void issueLottoNumbers() {
        String purchaseAmount = inputReader.inputPurchaseAmount();

        PurchaseAmount purchaseAmountValidator = new PurchaseAmount();
        purchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        int lottoCount = Integer.parseInt(purchaseAmount) / 1000;

        LottoNumberProvider lottoNumberProvider = new LottoNumberProvider();
        List<Set<Integer>> totalLottoNumbers = lottoNumberProvider.generateAndStoreLottoNumbers(lottoCount);

        outputWriter.printLottoNumbers(lottoCount, totalLottoNumbers);
    }

    public void convertAndValidateWinningNumbers() {
        String inputWinningNumbers = inputReader.inputWinningNumbers();

        TypeConverter typeConverter = new TypeConverter();
        Lotto lotto = new Lotto(typeConverter.convertToList(inputWinningNumbers));
        winningNumbers = lotto.getWinningNumbers();
    }

}
