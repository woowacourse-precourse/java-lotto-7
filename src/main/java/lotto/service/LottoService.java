package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.dto.request.EarningRateRequest;
import lotto.dto.request.LottoAmountRequest;
import lotto.dto.request.LottoResultRequest;
import lotto.dto.response.EarningRateResponse;
import lotto.dto.response.LottoResultResponse;
import lotto.dto.response.LottoesResponse;

import java.util.*;

public class LottoService {

    private final List<Lotto> lottoes = new ArrayList<>();

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
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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

    public EarningRateResponse getEarningRate(EarningRateRequest request) {
        double earningRate = request.lottoResult().keySet().stream()
                .mapToDouble(rank -> ((double) (rank.getPrize()) / (request.amount() * 1000) * (request.lottoResult().get(rank)) * (100))).sum();

        return EarningRateResponse.from(earningRate);
    }
}
