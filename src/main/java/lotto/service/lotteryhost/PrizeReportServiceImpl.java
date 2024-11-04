package lotto.service.lotteryhost;

import java.util.Optional;
import lotto.repository.LottoTicketRepository;
import lotto.repository.WinningReceiptRepository;
import lotto.service.constant.prize.PrizeCondition;

public class PrizeReportServiceImpl implements PrizeReportService {

    private final LottoTicketRepository lottoTicket = LottoTicketRepository.getTicket();
    private final WinningReceiptRepository winningReceipt = WinningReceiptRepository.getInstance();

    private final PrizeCheckService prizeCheckService;

    public PrizeReportServiceImpl(PrizeCheckService prizeCheckService) {
        this.prizeCheckService = prizeCheckService;
    }

    @Override
    public void updateReport() {
        while(lottoTicket.unrevealedGameExist()){
            updateCondition();
        }
    }

    private void updateCondition() {
        Optional<PrizeCondition> result = prizeCheckService.result();
        result.ifPresent(winningReceipt::add);
    }
}
