package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.repository.LottoRepository;
import lotto.repository.ResultRepository;

import java.util.List;
import java.util.Map;

public class WinService {

    private final LottoRepository lottoRepository;
    private final ResultRepository resultRepository;

    public WinService(LottoRepository lottoRepository, ResultRepository resultRepository) {
        this.lottoRepository = lottoRepository;
        this.resultRepository = resultRepository;
    }

    public Map<Rank, Integer> win(List<Integer> winNumbers, int bonus){
        List<Lotto> lottos = lottoRepository.findAll();

        for (Lotto lotto : lottos){
            Rank rank = findRank(
                    findMatchCount(winNumbers, lotto),
                    isMatchBonus(lotto, bonus));

            if (rank != null){
                resultRepository.addResult(rank);
            }
        }

        return resultRepository.getResult();
    }

    public double getProfit(Money money){
        return resultRepository.calculate(money);
    }

    private Rank findRank(int count, boolean isBonus){
        if (count == 6) return Rank.FIRST;
        if (count == 5 && isBonus) return Rank.SECOND;
        if (count == 5) return Rank.THIRD;
        if (count == 4) return Rank.FOURTH;
        if (count == 3) return Rank.FIFTH;

        return null;
    }

    private boolean isMatchBonus(Lotto lotto, int bonus){
        return lotto.getNumbers().contains(bonus);
    }

    private int findMatchCount(List<Integer> winNumbers, Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winNumbers::contains)
                .count();
    }

}
