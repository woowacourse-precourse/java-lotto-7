package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoConstants;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;

public class LottoService {

    public LottoTicket generateLottos(int purchaseAmount) {
        LottoTicket lottoTicket = new LottoTicket();
        int lottoCount = purchaseAmount / LottoConstants.LOTTO_PRICE_UNIT;

        for (int i = 0; i < lottoCount; i++) {
            lottoTicket.addLotto(generateSingleLotto());
        }
        return lottoTicket;
    }

    private Lotto generateSingleLotto() {
        Lotto lotto = new Lotto(pickLottoNumber());
        lotto.sortAscendingInteger();
        return lotto;
    }

    public Map<LottoResult, Integer> calculateStatisticsLottoResult(LottoTicket lottoTicket,
                                                                    List<Integer> winningNumbers,
                                                                    int bonusNumber) {
        Map<LottoResult, Integer> lottoResultCount = initializeLottoResultCount();

        for (Lotto lotto : lottoTicket.getLottos()) {
            LottoResult lottoResult = determineLottoResult(lotto, winningNumbers, bonusNumber);
            if (lottoResult != null) {
                lottoResultCount.put(lottoResult, lottoResultCount.get(lottoResult) + 1);
            }
        }

        return lottoResultCount;
    }

    private Map<LottoResult, Integer> initializeLottoResultCount() {
        Map<LottoResult, Integer> lottoResultCount = new HashMap<>();
        for (LottoResult lottoResult : LottoResult.values()) {
            lottoResultCount.put(lottoResult, 0);
        }
        return lottoResultCount;
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

    private List<Integer> pickLottoNumber() {
        return new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_NUMBER_MIN, LottoConstants.LOTTO_NUMBER_MAX,
                        LottoConstants.LOTTO_NUMBER_COUNT));
    }
}
