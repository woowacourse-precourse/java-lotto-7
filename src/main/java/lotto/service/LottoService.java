package lotto.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResultCalculator;
import lotto.domain.Lottos;
import lotto.domain.Receipt;
import lotto.dto.LottoResult;
import lotto.dto.WinningLottoNumbers;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";
    private final LottoGenerator lottoGenerator;
    private final LottoResultCalculator calculator;

    public LottoService(LottoGenerator lottoGenerator, LottoResultCalculator calculator) {
        this.lottoGenerator = lottoGenerator;
        this.calculator = calculator;
    }

    public Receipt generateLottos(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);
        int count = amount / LOTTO_PRICE;
        Lottos lottos = lottoGenerator.generateLottos(count);
        return new Receipt(lottos, amount);
    }

    public LottoResult calculateLottoResult(Receipt receipt, String winningNumbers, String bonusNumber) {
        WinningLottoNumbers winningLottoNumbers = createWinningLotto(winningNumbers, bonusNumber);
        return calculator.calculateResult(receipt.getLottos(), winningLottoNumbers, receipt.getPurchaseAmount());
    }

    private WinningLottoNumbers createWinningLotto(String winningNumbers, String bonusNumber) {
        List<Integer> parsedNumbers = parseToIntegerList(winningNumbers);
        int parsedBonusNumber = Integer.parseInt(bonusNumber.trim());
        return new WinningLottoNumbers(parsedNumbers, parsedBonusNumber);
    }

    private List<Integer> parseToIntegerList(String numbers) {
        return Arrays.stream(numbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public BigDecimal calculateProfitRate(LottoResult lottoResult) {
        return calculator.calculateProfitRate(lottoResult);
    }
}
