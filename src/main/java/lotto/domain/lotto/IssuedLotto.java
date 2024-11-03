package lotto.domain.lotto;

import lotto.domain.winning.WinningCombination;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IssuedLotto {
    private final List<Lotto> lottoTickets;

    public IssuedLotto(List<Lotto> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets); // 불변 리스트로 저장
    }

    // 로또 티켓 목록 반환
    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    // 당첨 결과를 계산하여 등급별로 개수를 반환
    public Map<Rank, Long> calculateResults(WinningCombination winningCombination) {
        return lottoTickets.stream()
                .map(lotto -> lotto.calculateRank(winningCombination))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }
}