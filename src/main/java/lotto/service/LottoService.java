package lotto.service;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoPurchasePrice;
import lotto.model.LottoResult;
import lotto.model.LottoTicketCount;
import lotto.model.ReturnRate;
import lotto.model.WinningNumbers;
import lotto.service.generator.TicketNumberGenerator;

public class LottoService {
    private final LottoTicketService lottoTicketService;
    private final WinningNumbersService winningNumbersService;
    private final BonusNumberService bonusNumberService;
    private final LottoResultService lottoResultService;

    public LottoService(TicketNumberGenerator ticketNumberGenerator) {
        this.lottoTicketService = new LottoTicketService(ticketNumberGenerator);
        this.winningNumbersService = new WinningNumbersService();
        this.bonusNumberService = new BonusNumberService();
        this.lottoResultService = new LottoResultService();
    }

    public LottoPurchasePrice getLottoPurchasePrice(String purchasePrice) {
        return lottoTicketService.getLottoPurchasePrice(purchasePrice);
    }

    public LottoTicketCount getLottoTicketCount(LottoPurchasePrice lottoPurchasePrice) {
        return lottoTicketService.calculateLottoTicketCount(lottoPurchasePrice);
    }

    public List<Lotto> getLottos(LottoTicketCount lottoTicketCount) {
        return lottoTicketService.generateLottos(lottoTicketCount);
    }

    public WinningNumbers getWinningNumbers(String winningNumbers) {
        return winningNumbersService.getWinningNumbers(winningNumbers);
    }

    public BonusNumber getBonusNumber(String bonusNumber) {
        return bonusNumberService.getBonusNumber(bonusNumber);
    }

    public LottoResult getLottoResult(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return lottoResultService.getLottoResult(lottos, winningNumbers, bonusNumber);
    }

    public ReturnRate getReturnRate(LottoResult lottoResult, LottoPurchasePrice lottoPurchasePrice) {
        return lottoResultService.calculateReturnRate(lottoResult, lottoPurchasePrice);
    }
}
