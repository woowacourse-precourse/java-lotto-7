package lotto.service;

import lotto.application.LottoDto;
import lotto.application.LottoTicketsDto;
import lotto.application.WinningNumbersDto;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.UserMoney;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.MonetaryUnit.PERCENTAGE;

public class LottoService {
    public LottoTicketsDto createLottoTickets(int money) {
        UserMoney userMoney = new UserMoney(money);
        int numberOfTickets = userMoney.calculateNumberOfLotto();

        return new LottoTicketsDto(new LottoTickets(numberOfTickets));
    }

    public List<Rank> calculateRanks(LottoTicketsDto lottoTicketsDto, WinningNumbersDto winningNumbersDto) {
        List<Rank> rankResult = new ArrayList<>();
        Lotto winningLotto = new Lotto(winningNumbersDto.getWinningLottoNumbers());
        for (LottoDto lottoTicketDto : lottoTicketsDto.getLottoTickets()) {
            rankResult.add(new Lotto(lottoTicketDto.getLotto())
                    .calculateRanks(winningLotto.getNumbers(), winningNumbersDto.getBonusNumber()));
        }

        return rankResult;
    }

    public Double calculateRateOfReturn(int userMoney, List<Rank> ranks) {
        double prizeSum = ranks.stream()
                .mapToDouble(Rank::getPrize)
                .sum();

        return (prizeSum / userMoney) * PERCENTAGE.getUnit();
    }
}