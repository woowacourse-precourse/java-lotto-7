package lotto.service.purchase;

import java.util.Optional;
import lotto.domain.DrawTool;
import lotto.domain.Lotto;
import lotto.repository.LottoTicketRepository;

public class LottoMachineServiceImpl implements LottoMachineService {

    private static LottoMachineServiceImpl instance;

    private final LottoTicketRepository ticketRepository;
    private final LottoGameService lottoGameService;
    private final DrawTool lottoMachine;

    private LottoMachineServiceImpl(PurchaseService purchaseService) {
        lottoMachine = purchaseService.openTrade();

        this.lottoGameService = new LottoGameServiceImpl(lottoMachine);
        this.ticketRepository = LottoTicketRepository.getTicket();
    }

    @Override
    public void updateLottoTicket() {
        while (lottoMachine.gamesLeft()) {
            typeGameLog();
        }
    }

    private void typeGameLog() {
        Optional<Lotto> game = lottoGameService.register();
        game.ifPresent(ticketRepository::fillReceipt);
    }

    public static LottoMachineServiceImpl getInstance(PurchaseService purchaseServiceImpl) {
        if (instance == null) {
            instance = new LottoMachineServiceImpl(purchaseServiceImpl);
        }
        return instance;
    }
}
