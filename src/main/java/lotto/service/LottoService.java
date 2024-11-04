package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoManager;
import lotto.formatter.LottoFormatter;
import lotto.domain.WinningLotto.WinningLotto;
import lotto.domain.WinningLotto.WinningLottoCalculate;
import lotto.domain.WinningLotto.WinningLottoCounter;
import lotto.domain.dto.WinningLottoResultDTO;
import lotto.parser.business.LottoParser;
import lotto.parser.util.ParseUtils;
import lotto.validator.LottoValidator;

import java.util.*;

public class LottoService {
    private final LottoManager lottoManager;
    private final LottoFormatter lottoFormatter;
    private final WinningLottoCounter winningLottoCounter;
    private final WinningLottoCalculate winningLottoCalculate;
    private final LottoValidator lottoValidator;

    public LottoService(LottoManager lottoManager, LottoFormatter lottoFormatter, WinningLottoCounter winningLottoCounter, WinningLottoCalculate winningLottoCalculate, LottoValidator lottoValidator) {
        this.lottoManager = lottoManager;
        this.lottoFormatter = lottoFormatter;
        this.winningLottoCounter = winningLottoCounter;
        this.winningLottoCalculate = winningLottoCalculate;
        this.lottoValidator = lottoValidator;
    }

    public void callCreateLottos(int buyLottoCount) {
        lottoManager.createLottos(buyLottoCount);
    }

    public int getCalculateBuyLottoCount(int buyLottoMoney) {
        return winningLottoCalculate.calculateBuyLottoCount(buyLottoMoney);
    }

    public List<String> formatBuyLottoNumbersResult() {
        return lottoFormatter.formatLottoNumbers(lottoManager.getLottos());
    }

    public void recordWinningLotto(String winningNumbers, String bonusNumber) {
        List<Integer> parsedWinningNumbers = LottoParser.parseWinningNumbers(winningNumbers);
        lottoValidator.validateLottoNumbersSize(parsedWinningNumbers);
        lottoValidator.validateLottoRange(parsedWinningNumbers);
        lottoValidator.validateLottoNumbersDuplication(parsedWinningNumbers);
        int parsedBonusNumber = ParseUtils.convertToNumber(bonusNumber);
        lottoValidator.validateBonusLottoRange(parsedBonusNumber);
        lottoValidator.validateBonusNumberInLottoNumber(parsedWinningNumbers, parsedBonusNumber);

        for (Lotto lotto : lottoManager.getLottos()) {
            int matchedCount = calculateEqualWinningNumberBySingleLotto(parsedWinningNumbers, lotto);
            boolean hasBonusNumber = hasBonusNumberInLottoNumbers(parsedBonusNumber, lotto);
            WinningLotto winningLotto = WinningLotto.from(matchedCount, hasBonusNumber);
            winningLottoCounter.incrementCount(winningLotto);
        }
    }

    public List<WinningLottoResultDTO> formatWinningLottoResults() {
        return lottoFormatter.formatWinningLottoResults();
    }

    public double callCalculateLottoRateOfReturn(int buyLottoMoney) {
        return winningLottoCalculate.calculateLottoRateOfReturn(buyLottoMoney);
    }

    private int calculateEqualWinningNumberBySingleLotto(List<Integer> winningNumbers, Lotto lotto) {
        Set<Integer> parsedWinNumbers = new HashSet<>(winningNumbers);
        Set<Integer> parsedLottoNumbers = new HashSet<>(lotto.getNumbers());

        parsedWinNumbers.retainAll(parsedLottoNumbers);
        return parsedWinNumbers.size();
    }

    private boolean hasBonusNumberInLottoNumbers(int bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
