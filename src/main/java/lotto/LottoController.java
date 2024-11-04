package lotto;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;
    private final LottoView lottoView;

    protected LottoController(final LottoService lottoService, final LottoView lottoView) {
        this.lottoService = lottoService;
        this.lottoView = lottoView;
    }

    public List<Lotto> purchaseLottoTickets() {
        String purchaseAmount = lottoView.purchaseLotto();
        try {
            List<Lotto> lottoResult = lottoService.purchaseLottoTickets(purchaseAmount);
            lottoView.displayPurchasedLotto(lottoResult);
            return lottoResult;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLottoTickets();
        }

    }

    public void setWinningAndBonusLottoNumbers() {
        final String winningNumbers = lottoView.getWinningLottoNumbers();
        final String bonusNumber = lottoView.getBonusLottoNumbers();
        try {
            lottoService.setWinningLottoStore(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.setWinningAndBonusLottoNumbers();
        }
    }

    public void lottoResults(final List<Lotto> userLottoTickets) {
        LottoResultDto lottoResult = lottoService.getLottoResults(userLottoTickets);
        lottoView.displayLottoResults(lottoResult);
    }
}
