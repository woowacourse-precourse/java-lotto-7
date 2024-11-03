package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoResult;
import lotto.dto.LottoResults;

public class CustomerLotto {
    private final List<Lotto> tickets;

    private CustomerLotto(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static CustomerLotto of(List<Lotto> tickets) {
        return new CustomerLotto(tickets);
    }

    /**
     * 주어진 당첨 로또를 고객의 로또 티켓들과 비교합니다.
     *
     * @param winningLotto 고객의 티켓과 비교할 당첨 로또
     * @return 비교 결과를 포함하는 LottoResults 객체
     */
    public LottoResults compareWinningLotto(WinningLotto winningLotto) {
        List<LottoResult> lottoResults = tickets.stream()
                .map(winningLotto::checkLotto)
                .toList();
        return LottoResults.of(lottoResults);
    }

    public List<Lotto> getTickets() {
        return new ArrayList<>(tickets);
    }
}
