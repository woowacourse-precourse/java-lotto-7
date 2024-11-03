package lotto;

import java.util.List;

public class LottoGameController {
    private final LottoService lottoService;
    private final LottoInputView LottoInputView;
    private final LottoOutputView LottoOutputView;


    public LottoGameController(lotto.LottoInputView lottoInputView, LottoService lottoService, lotto.LottoOutputView lottoOutputView) {
        LottoInputView = lottoInputView;
        this.lottoService = lottoService;
        LottoOutputView = lottoOutputView;
    }

    public void play(){
        List<Lotto> purchaseLottos = purchaseLottos(); // 로또를 구입한 후
        Lotto winningLotto = getWinningLotto(); // 이긴 로또 가져오고
        int bonusNumber = getBonusNumber(winningLotto); // 보너스 로또를 체크하고
        showResult(purchaseLottos, winningLotto,bonusNumber); // 결과 보여주기
    }

    private List<Lotto> purchaseLottos(){
        try {
            int amount = LottoInputView.readPurchaseAmount();

        }
    }
}
