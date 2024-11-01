package lotto.Controller;

import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.domain.Lotto;
import lotto.domain.UserLotto;

import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    LottoService lottoService = new LottoService();

    public void run() {
        List<Lotto> lottos=purchase_Lotto();
        UserLotto userLotto=UserLotto();


    }

    private List<Lotto> purchase_Lotto(){
        int purchase_Amount=InputView.input_purchaseAmount();
        List<Lotto> lottos=lottoService.purchaseLotto(purchase_Amount);
        return lottos;
    }

    private UserLotto UserLotto(){
        Lotto winning_Number= InputView.input_winningNumber();
        int bonus_Number=InputView.input_bounsNumber();
        return new UserLotto(winning_Number,bonus_Number);
    }
}
