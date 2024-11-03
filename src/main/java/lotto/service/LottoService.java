package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoManager;
import lotto.domain.LottoFormatter;
import lotto.domain.WinningLotto.WinningLotto;
import lotto.domain.WinningLotto.WinningLottoCalculate;
import lotto.domain.WinningLotto.WinningLottoCounter;
import lotto.dto.WinningLottoResultDTO;
import lotto.parser.business.LottoParser;
import lotto.parser.util.ParseUtils;

import java.util.*;

public class LottoService {
    private final LottoManager lottoManager;
    private final LottoFormatter lottoFormatter;
    private final WinningLottoCounter winningLottoCounter;
    private final WinningLottoCalculate winningLottoCalculate;

    public LottoService(LottoManager lottoManager, LottoFormatter lottoFormatter, WinningLottoCounter winningLottoCounter, WinningLottoCalculate winningLottoCalculate) {
        this.lottoManager = lottoManager;
        this.lottoFormatter = lottoFormatter;
        this.winningLottoCounter = winningLottoCounter;
        this.winningLottoCalculate = winningLottoCalculate;
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
        List<Integer> parsedWinNumbers = LottoParser.parseWinningNumbers(winningNumbers);
        int parsedBonusNumber = ParseUtils.convertToNumber(bonusNumber);

        for (Lotto lotto : lottoManager.getLottos()) {
            int matchedCount = calculateEqualWinningNumberBySingleLotto(parsedWinNumbers, lotto);
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
        if (lotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
