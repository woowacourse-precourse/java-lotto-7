package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.InputLottoNumber;
import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
    public List<Lotto> getLotto (int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < (purchaseAmount / 1000); i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }


    public Map<Rank, Integer> getRankResult(List<Lotto> lottos, InputLottoNumber inputLottoNumber) {
        Map<Rank, Integer> rankResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankResult.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(lotto, inputLottoNumber);
            rankResult.put(rank, rankResult.get(rank) + 1);
        }
        return rankResult;
    }

    public Rank calculateRank(Lotto lotto, InputLottoNumber inputLottoNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(inputLottoNumber.getWinningNumbers()::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(inputLottoNumber.getBonusNumber());
        return Rank.valueOf(matchCount, bonusMatch);
    }
}
