package lotto.service;

import lotto.dto.InputDTO;
import lotto.dto.Lotto;
import lotto.handler.OutputHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultService {

    private final LottoNumberService lottoNumberService = new LottoNumberService();
    private final OutputHandler outputHandler = new OutputHandler();

    public void calculateWinningsStatistics(InputDTO inputDTO, List<Lotto> purchasedLottos) {
        Map<String, Integer> statistics = initializeStatistics();

        for (Lotto lotto : purchasedLottos) {
            int matchCount = lottoNumberService.compareWithWinningNumbers(inputDTO, lotto);
            boolean hasBonus = lottoNumberService.compareWithBonusNumber(inputDTO, lotto);

            String formattedResult = getFormattedResult(matchCount, hasBonus);

            updateStatistics(statistics, formattedResult);
        }

        outputHandler.printStatistics(statistics);
    }

    private Map<String, Integer> initializeStatistics() {
        Map<String, Integer> statistics = new HashMap<>();
        statistics.put("6개 일치 (2,000,000,000원)", 0);
        statistics.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        statistics.put("5개 일치 (1,500,000원)", 0);
        statistics.put("4개 일치 (50,000원)", 0);
        statistics.put("3개 일치 (5,000원)", 0);
        return statistics;
    }

    private String getFormattedResult(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return "6개 일치 (2,000,000,000원)";
        } else if (matchCount == 5 && hasBonus) {
            return "5개 일치, 보너스 볼 일치 (30,000,000원)";
        } else if (matchCount == 5) {
            return "5개 일치 (1,500,000원)";
        } else if (matchCount == 4) {
            return "4개 일치 (50,000원)";
        } else if (matchCount == 3) {
            return "3개 일치 (5,000원)";
        }
        return "당첨 되지 않음.";
    }

    private void updateStatistics(Map<String, Integer> statistics, String formattedResult) {
        if (!formattedResult.equals("당첨 되지 않음.")) {
            statistics.put(formattedResult, statistics.getOrDefault(formattedResult, 0) + 1);
        }
    }
}
