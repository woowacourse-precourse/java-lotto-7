package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.type.LottoRank;
import lotto.dto.request.LottoMoneyRequest;
import lotto.dto.response.LottoCalculateResponse;
import lotto.dto.response.LottoNumResponseList;

import java.util.*;

public class LottoService {
    private final Map<LottoRank, Integer> prizeCounts = new HashMap<>();

    public LottoNumResponseList createLottoList(LottoMoneyRequest lottoMoneyRequest) {
        int money = lottoMoneyRequest.money();
        int lottoCount = money / 1000;

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                    .sorted()
                    .toList());

            lottoList.add(lotto);
        }

        return LottoNumResponseList.of(lottoCount, lottoList);
    }

    public LottoCalculateResponse calculateLotto(Lotto ownLotto, int bonusNumber, List<Lotto> lottoList, Money money) {
        for (Lotto target : lottoList) {
            LottoRank prize = calculatePrizeCount(target, ownLotto, bonusNumber);
            prizeCounts.put(prize, prizeCounts.getOrDefault(prize, 0) + 1);
        }

        return LottoCalculateResponse.of(prizeCounts, calculateEarningRate(money));
    }

    private LottoRank calculatePrizeCount(Lotto target, Lotto ownLotto, int bonusNumber) {
        return target.match(ownLotto, bonusNumber);
    }

    private double calculateEarningRate(Money money) {
        int totalPrize = prizeCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double earningRate = ((double) totalPrize / money.getValue()) * 100;

        return Math.round(earningRate * 100.0) / 100.0;
    }
}