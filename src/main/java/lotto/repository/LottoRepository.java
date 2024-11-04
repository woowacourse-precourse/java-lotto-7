package lotto.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class LottoRepository {

    private static final Set<List<Integer>> lottoTickets = new HashSet<>();
    private static Lotto winningLotto = null;
    private static int bonusNumber = 0;
    private static final Map<LottoRank, Integer> winningResults = new HashMap<>();

    public LottoRepository() {
        winningResults.put(LottoRank.FIRST, 0);
        winningResults.put(LottoRank.SECOND, 0);
        winningResults.put(LottoRank.THIRD, 0);
        winningResults.put(LottoRank.FOURTH, 0);
        winningResults.put(LottoRank.FIFTH, 0);
    }

    public void insertNumbers(List<Integer> randomNumbers) {
        lottoTickets.add(randomNumbers);
    }

    public Set<List<Integer>> getLottoTickets() {
        return lottoTickets;
    }

    public void insertWinningLotto(Lotto lotto) {
        winningLotto = lotto;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getNumbers();
    }

    public void insertBonusNumber(int number) {
        bonusNumber = number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void insertMatchCount(LottoRank rank) {
        winningResults.compute(rank, (k, count) -> count + 1);
    }

    public Map<LottoRank, Integer> getWinningResults() {
        return winningResults;
    }

}
