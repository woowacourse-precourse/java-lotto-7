package lotto.service.lotteryhost;

import lotto.repository.LottoTicketRepository;
import lotto.repository.WinningReceiptRepository;
import lotto.service.constant.Cost;
import lotto.service.constant.prize.PrizeCondition;

public class ProfitRateServiceImpl implements ProfitRateService {

    private final WinningReceiptRepository receipt;
    private final LottoTicketRepository ticket;

    public ProfitRateServiceImpl() {
        this.receipt = WinningReceiptRepository.getInstance();
        this.ticket = LottoTicketRepository.getTicket();
    }

    @Override
    public Double getRate() {
        return ((double) totalPrize() / (double) (ticket.getTotalGameCount()* Cost.ONE_LOTTO_GAME.getCost())) * 100;
    }

    private Long totalPrize() {
        if(receipt.prizeConditionExist()){
            return sumAllPrizeMoney();
        }
        return Cost.BASIC_PRIZE_MONEY.getCost();
    }

    private Long sumAllPrizeMoney() {
        Long sum = Cost.BASIC_PRIZE_MONEY.getCost();
        for (PrizeCondition condition : receipt.getPrizeConditions()) {
            sum += receipt.orderPrizeMoneySum(condition);
        }
        return sum;
    }
}