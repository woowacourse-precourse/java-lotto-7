package lotto;

import java.util.List;
import java.util.Map;

public class LottoGameController {
    private final LottoService lottoService;
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;


    public LottoGameController(LottoInputView lottoInputView, LottoService lottoService, LottoOutputView lottoOutputView) {
        this.lottoInputView = lottoInputView;
        this.lottoService = lottoService;
        this.lottoOutputView = lottoOutputView;
    }

    public void play(){
        List<Lotto> purchaseLottos = purchaseLottos();
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto);
        showResult(purchaseLottos, winningLotto,bonusNumber);
    }

    private List<Lotto> purchaseLottos(){
        try {
            int amount = lottoInputView.readPurchaseAmount();
            List<Lotto> lottos = lottoService.purchaseLotto(amount);
            lottoOutputView.printPurchaseResult(lottos);
            return lottos;
        } catch (IllegalArgumentException e){
            lottoOutputView.printError(e.getMessage());
            return purchaseLottos();
        }
    }

    private Lotto getWinningLotto() {
        try {
            return lottoInputView.readWinningNumbers();
        } catch (IllegalArgumentException e) {
            lottoOutputView.printError(e.getMessage());
            return getWinningLotto();
        }
    }

    private int getBonusNumber(Lotto winningLotto) {
        try {
            return lottoInputView.readBonusNumber(winningLotto);
        } catch (IllegalArgumentException e) {
            lottoOutputView.printError(e.getMessage());
            return getBonusNumber(winningLotto);
        }
    }

    private void showResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<WinningRank, Integer> statistics =
                lottoService.calculateWinningStatistics(lottos, winningLotto, bonusNumber);
        double returnRate =
                lottoService.calculateReturnRate(statistics, lottos.size() * 1000);
        lottoOutputView.printWinningStatistics(statistics, returnRate);
    }

}
