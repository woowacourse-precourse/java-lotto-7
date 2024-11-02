package lotto.service;

import lotto.application.LottoDto;
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

    public List<Rank> calculateRank(LottoTicketsDto lottoTicketsDto, List<Integer> winningNumber, int bonusNumber) {
        List<Rank> rankResult = new ArrayList<>();
        Lotto winningLotto = new Lotto(winningNumber);

        for (LottoDto lottoTicketDto : lottoTicketsDto.getLottoTickets()) {
            Lotto lotto = new Lotto(lottoTicketDto.getLotto());
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