package lotto.Controller;

import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.domain.Lotto;
import lotto.domain.RankResult;
import lotto.domain.UserLotto;

import java.util.List;

public class LottoController {
    LottoService lottoService = new LottoService();

    public void run() {
        List<Lotto> lottos=purchase_Lotto();
        UserLotto userLotto=UserLotto();
        RankResult rankResult=RankResult(lottos,userLotto);
        double profit_rate=profit_rate(rankResult);
        OutputView.print_winning_statistics(rankResult);
        OutputView.print_profit_statistics(profit_rate);
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
    private RankResult RankResult(List<Lotto> lottos, UserLotto userLotto){
       RankResult rankResult=lottoService.winning_statistics(lottos,userLotto.getWinning_Lotto().getNumbers(),userLotto.getBonus_Number());
       return rankResult;
    }
    private double profit_rate(RankResult rankResult){
        return lottoService.profit_rate(rankResult);
    }
}
