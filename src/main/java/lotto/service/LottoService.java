package lotto.service;

import lotto.domain.Lotto.Lotto;
import lotto.domain.Lotto.LottoGenerator;
import lotto.domain.Lotto.LottoManager;
import lotto.domain.LottoFormatter;
import lotto.domain.WinningLotto.WinningLotto;
import lotto.domain.WinningLotto.WinningLottoCounter;
import lotto.dto.WinningLottoResultDTO;
import lotto.parser.business.LottoParser;
import lotto.parser.util.ParseUtils;
import lotto.utils.RandomNumbersSelector;
import lotto.utils.SortUtils;

import java.util.*;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final LottoManager lottoManager;
    private final LottoFormatter lottoFormatter;
    private final WinningLottoCounter winningLottoCounter;

    public LottoService(LottoGenerator lottoGenerator, LottoManager lottoManager, LottoFormatter lottoFormatter, WinningLottoCounter winningLottoCounter) {
        this.lottoGenerator = lottoGenerator;
        this.lottoManager = lottoManager;
        this.lottoFormatter = lottoFormatter;
        this.winningLottoCounter = winningLottoCounter;
    }

    public void createLottos(int buyLottoCount) {
        for (int i = 0; i < buyLottoCount; i++) {
            List<Integer> randomNumbers = RandomNumbersSelector.selectRandomNumbers();
            List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers(randomNumbers);
            List<Integer> sortedLottoNumbers = SortUtils.sortNumbers(lottoNumbers);
            lottoManager.createLottosByRandomNumbers(sortedLottoNumbers);
        }
    }

    public List<String> formatBuyLottoNumbersResult() {
        return lottoFormatter.formatLottoNumbers(lottoManager.getLottos());
    }

    public void recordWinningLottoInfo(String winningNumbers, String bonusNumber) {
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
        List<WinningLottoResultDTO> formatResults = new ArrayList<>();
        Map<WinningLotto, Integer> counts = winningLottoCounter.getAllCounts();

        for (WinningLotto winningLotto : WinningLotto.values()) {
            formatResults.add(new WinningLottoResultDTO(
                    winningLotto.getMatchedCount(),
                    winningLotto.getFormattedPrize(),
                    counts.get(winningLotto)
            ));
        }

        return formatResults;
    }


    public double calculateLottoRateOfReturn(int buyLottoMoney) {
        long totalAmount = calculateTotalPrize();
        double rateOfReturn = calculateRateOfReturn(buyLottoMoney, totalAmount);
        return formatRounding(rateOfReturn);
    }

    private double calculateRateOfReturn(int buyLottoMoney, long totalPrize) {
        double rateOfReturn = (double) totalPrize / buyLottoMoney;
        return rateOfReturn;
    }

    private long calculateTotalPrize() {
        Map<WinningLotto, Integer> counts = winningLottoCounter.getAllCounts();
        long sum = 0;
        for (Map.Entry<WinningLotto, Integer> entry : counts.entrySet()) {
            sum += (long) entry.getValue() * entry.getKey().getPrize();
        }
        return sum;
    }

    private double formatRounding(double rateOfReturn) {
        return Math.round((rateOfReturn * 1000) / 10.0);
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
