package lotto.service;

import lotto.dto.ResultDto;
import lotto.model.customer.Customer;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningLotto;
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
        return ResultDto.from(RankCounter.countRanks(customer.getLottoTickets())
                , customer.calculateProfitRate());
    }
}
