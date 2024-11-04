package lotto.domain;

import lotto.constants.Ranking;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.LottoValue.LOTTO_PRICE;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Ranking> checkRankings(final WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> checkSingleRanking(lotto, winningLotto))
                .collect(Collectors.toList());
    }

    private Ranking checkSingleRanking(final Lotto lotto, final WinningLotto winningLotto) {
        int matchCount = lotto.calculateMatchCount(winningLotto.getLotto().getNumbers());
        boolean isBonus = lotto.isContainNumber(winningLotto.getBonusNumber());
        return Ranking.of(matchCount, isBonus);
    }

    public int getLottoTicketPrice() {
        return lottos.size() * LOTTO_PRICE.getValue();
    }

    public List<List<Integer>> getAllLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumberValues)
                .collect(Collectors.toList());
    }

    public int getLottoCount() {
        return lottos.size();
    }
}
