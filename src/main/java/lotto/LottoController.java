package lotto;

import java.util.HashMap;

public class LottoController {
    public void run(){
        inputView Input = new inputView();
        Money money = Input.getMoney();
        Lotto lotto = Input.getLotto();
        AdditionalNumber additionalNumber = Input.getAdditionalNumber();
        BuyLotto BuyLotto = new BuyLotto(money);

        OutViewLotto Output = new OutViewLotto();
        Output.viewLottoList(money, BuyLotto);

        MatchLotto matchLotto = new MatchLotto();
        HashMap<Integer, Integer> result = matchLotto.MatchLotto(BuyLotto, lotto, additionalNumber);
        CalculateResult calculateResult = new CalculateResult();
        float rewordRatio = calculateResult.Calculate(result, money);
        Output.ViewResultDetail(result);
        Output.ViewResultPrice(rewordRatio);
    }
}
