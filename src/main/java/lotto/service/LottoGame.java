package lotto.service;

import lotto.domain.LottoNumberProvider;
import lotto.domain.TypeConverter;
import lotto.domain.WinningResultExtractor;
import lotto.validator.BonusNumber;
import lotto.validator.Lotto;
import lotto.validator.PurchaseAmount;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

import java.util.List;
import java.util.Set;

public class LottoGame {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    List<Set<Integer>> totalLottoNumbers;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private String purchaseAmount;

    public LottoGame(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void issueLottoNumbers() {
        purchaseAmount = inputReader.inputPurchaseAmount();

        PurchaseAmount purchaseAmountValidator = new PurchaseAmount();
        purchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        int lottoCount = Integer.parseInt(purchaseAmount) / 1000;

        LottoNumberProvider lottoNumberProvider = new LottoNumberProvider();
        totalLottoNumbers = lottoNumberProvider.generateAndStoreLottoNumbers(lottoCount);

        outputWriter.printLottoNumbers(lottoCount, totalLottoNumbers);
    }

    public void convertAndValidateWinningNumbers() {
        String inputWinningNumbers = inputReader.inputWinningNumbers();
        String inputBonusNumber = inputReader.inputBonusNumber();

        TypeConverter typeConverter = new TypeConverter();
        Lotto lottoValidator = new Lotto(typeConverter.convertToList(inputWinningNumbers));
        winningNumbers = lottoValidator.getWinningNumbers();

        BonusNumber bonusNumberValidator = new BonusNumber();
        bonusNumberValidator.validateBonusNumber(inputBonusNumber, winningNumbers);
        bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    public void calculateWinningRate() {
        WinningResultExtractor winningResultExtractor = new WinningResultExtractor();
        winningResultExtractor.getWinningResult(totalLottoNumbers, winningNumbers, bonusNumber);
        String winningRate = winningResultExtractor.getWinningRate(Integer.parseInt(purchaseAmount));

        outputWriter.printWinningStatistics(winningRate, winningResultExtractor.totalMatchCounts, winningResultExtractor.bonusCount);
    }

}
