package lotto.service;

import lotto.application.LottoDto;
import lotto.application.LottoTicketsDto;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.MonetaryUnit.PERCENTAGE;
import static lotto.domain.MonetaryUnit.ROUND_UP_TO_TWO_DECIMAL_PLACES;

public class LottoService {
    public LottoTicketsDto createUserLottoTickets(int money) {
        UserMoney userMoney = new UserMoney(money);
        int numberOfTickets = userMoney.calculateNumberOfLotto();

        return new LottoTicketsDto(new LottoTickets(numberOfTickets));
    }

    public List<Rank> calculateUserLottoTicketsRank(LottoTicketsDto lottoTicketsDto, List<Integer> winningNumber, int bonusNumber) {
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

        return (double) Math.round((prizeSum / userMoney) * PERCENTAGE.getUnit() * ROUND_UP_TO_TWO_DECIMAL_PLACES.getUnit())
                / (ROUND_UP_TO_TWO_DECIMAL_PLACES.getUnit());
    }
}