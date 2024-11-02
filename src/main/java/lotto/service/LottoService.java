package lotto.service;

import lotto.application.LottoTicketsDto;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.UserMoney;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public LottoTicketsDto createLottoTickets(int money) {
        UserMoney userMoney = new UserMoney(money);
        int numberOfTickets = userMoney.calculateNumberOfLotto();

        return new LottoTicketsDto(new LottoTickets(numberOfTickets));
    }

    public List<Rank> calculateRank(List<List<Integer>> lottoTickets, List<Integer> winningNumber, int bonusNumber) {
        List<Rank> rankResult = new ArrayList<>();
        Lotto winningLotto = new Lotto(winningNumber);

        for (List<Integer> lottoTicket : lottoTickets) {
            Lotto lotto = new Lotto(lottoTicket);
            rankResult.add(lotto.calculateRank(winningLotto.getNumbers(), bonusNumber));
        }

        return rankResult;
    }

    public Double calculateRateOfReturn(int userMoney, List<Rank> ranks) {
        double prizeSum = 0;
        for (Rank rank : ranks) {
            prizeSum += rank.getPrize();
        }

        return (prizeSum / userMoney) * 100;
    }
}
