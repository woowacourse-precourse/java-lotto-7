package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoConstants;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;

public class LottoService {
    private final LottoNumberGenerator numberGenerator;

    public LottoService() {
        this.numberGenerator = new LottoNumberGenerator();
    }

    public LottoTicket generateLottos(int purchaseAmount) {
        LottoTicket lottoTicket = new LottoTicket();
        int lottoCount = purchaseAmount / LottoConstants.LOTTO_PRICE_UNIT;

        for (int i = 0; i < lottoCount; i++) {
            lottoTicket.addLotto(generateSingleLotto());
        }
        return lottoTicket;
    }

    private Lotto generateSingleLotto() {
        Lotto lotto = new Lotto(numberGenerator.generate());
        lotto.sortAscendingInteger();
        return lotto;
    }

    public Map<LottoResult, Integer> calculateStatisticsLottoResult(LottoTicket lottoTicket,
                                                                    List<Integer> winningNumbers,
                                                                    int bonusNumber) {
        Map<LottoResult, Integer> lottoResultCount = initializeLottoResultCount();
        updateLottoResultCount(lottoTicket, winningNumbers, bonusNumber, lottoResultCount);
        return lottoResultCount;
    }

    private Map<LottoResult, Integer> initializeLottoResultCount() {
        Map<LottoResult, Integer> lottoResultCount = new HashMap<>();
        for (LottoResult lottoResult : LottoResult.values()) {
            lottoResultCount.put(lottoResult, 0);
        }
        return lottoResultCount;
    }

    private void updateLottoResultCount(LottoTicket lottoTicket, List<Integer> winningNumbers,
                                        int bonusNumber, Map<LottoResult, Integer> lottoResultCount) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            LottoResult lottoResult = determineLottoResult(lotto, winningNumbers, bonusNumber);
            if (lottoResult != null) {
                lottoResultCount.put(lottoResult, lottoResultCount.get(lottoResult) + 1);
            }
        }
    }

    private LottoResult determineLottoResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = countMatches(lotto, winningNumbers);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
        return LottoResult.getLottoResult(matchCount, hasBonus);
    }

    private int countMatches(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
