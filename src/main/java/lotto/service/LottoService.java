package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public List<Rank> calculateRank(List<List<Integer>> lottoTickets, List<Integer> winningNumber, int bonusNumber) {
        List<Rank> rankResult = new ArrayList<>();
        Lotto winningLotto = new Lotto(winningNumber);

        for (List<Integer> lottoTicket : lottoTickets) {
            Lotto lotto = new Lotto(lottoTicket);
            rankResult.add(lotto.calculateRank(winningLotto.getNumbers(), bonusNumber));
        }

        return rankResult;
    }
}
