package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.dto.request.LottoAmountRequest;
import lotto.dto.request.LottoResultRequest;
import lotto.dto.response.LottoResultResponse;
import lotto.dto.response.LottoesResponse;

import java.util.*;

public class LottoService {

    private List<Integer> lottoNumbers = new ArrayList<>();
    private List<Lotto> lottoes = new ArrayList<>();

    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;
    private final int LOTTO_SIZE = 6;

    public LottoesResponse makeLottoes(LottoAmountRequest request) {
        for (int i = 0; i < request.amount(); i++) {
            lottoes.add(makeLotto());
        }

        return LottoesResponse.from(lottoes);
    }

    private Lotto makeLotto() {
        return new Lotto(setRandomNumbers());
    }

    private List<Integer> setRandomNumbers() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public LottoResultResponse getLottoResult(LottoResultRequest request) {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Lotto lotto : lottoes) {
            int matchCount = lotto.matchCount(request.winningNumbers());
            boolean isBonusNumber = lotto.contains(request.bonusNumber());

            Ranking ranking = Ranking.valueOf(matchCount, isBonusNumber);
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }

        return LottoResultResponse.from(result);
    }
}
