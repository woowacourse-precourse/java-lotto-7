package lotto.service;

import java.util.List;
import lotto.dto.ResultDto;
import lotto.model.customer.Customer;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.WinningLotto;
import lotto.utils.ProfitCalculator;
import lotto.utils.RankCounter;

public class LottoResultService {
    public WinningLotto registerWinningNumbers(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public void determineRanks(Customer customer, WinningLotto winningLotto) {
        customer.getLottoTickets().forEach(
                lottoTicket -> lottoTicket.determineRank(winningLotto)
        );
    }

    public ResultDto getResult(Customer customer) {
        List<LottoTicket> lottoTickets = customer.getLottoTickets();

        return ResultDto.from(RankCounter.countRanks(lottoTickets)
                , ProfitCalculator.calculateProfitRate(lottoTickets, customer.getPaidAmount()));
    }
}
