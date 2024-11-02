package lotto.service;

import lotto.domain.Lotto.Lotto;
import lotto.domain.Lotto.LottoGenerator;
import lotto.domain.Lotto.LottoManager;
import lotto.domain.Lotto.LottoFormatter;
import lotto.domain.WinningLotto.WinningLottoManager;
import lotto.parser.business.LottoParser;
import lotto.parser.util.ParseUtils;
import lotto.utils.RandomNumbersSelector;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final LottoManager lottoManager;
    private final LottoFormatter lottoFormatter;
    private final WinningLottoManager winningLottoManager;

    public LottoService(LottoGenerator lottoGenerator, LottoManager lottoManager, LottoFormatter lottoFormatter, WinningLottoManager winningLottoManager) {
        this.lottoGenerator = lottoGenerator;
        this.lottoManager = lottoManager;
        this.lottoFormatter = lottoFormatter;
        this.winningLottoManager = winningLottoManager;
    }

    public void createLottos(int buyLottoCount) {
        for (int i = 0; i < buyLottoCount; i++) {
            List<Integer> randomNumbers = RandomNumbersSelector.selectRandomNumbers();
            List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers(randomNumbers);
            lottoManager.createLottosByRandomNumbers(lottoNumbers);
        }
    }

    public List<String> formatBuyLottoNumbersResult() {
        return lottoFormatter.formatLottoNumbers(lottoManager.getLottos());
    }

    public void recordWinningLottoInfo(String winningNumbers, String bonusNumber) {
        List<Integer> parsedWinNumbers = LottoParser.parseWinningNumbers(winningNumbers);
        int parsedBonusNumber = ParseUtils.covertToNumber(bonusNumber);

        for (Lotto lotto : lottoManager.getLottos()) {
            int matchedCount = calculateEqualWinningNumberBySingleLotto(parsedWinNumbers, lotto);
            boolean hasBonusNumber = hasBonusNumberInLottoNumbers(parsedBonusNumber, lotto);
            winningLottoManager.recordWinningLotto(matchedCount, hasBonusNumber);
        }
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

    public int calculateBuyLottoCount(int buyLottoMoney) {
        int lottoCount = buyLottoMoney / 1000;
        return lottoCount;
    }
}
