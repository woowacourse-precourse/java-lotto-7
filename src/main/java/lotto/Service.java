package lotto;

import java.util.List;

public class Service {
    private int purchaseCost;
    private List<Lotto> lottos;
    private Lotto userLotto;
    private int bonus;

    public void run(){
        purchaseCost = new User().inputCost();
        lottos = new Generate().lottos(purchaseCost);
        userLotto = new User().inputPurchaseLottos();
        bonus = new User().inputBonusNumber();

        Draw draw = new Draw();
        draw.lotto(lottos, userLotto, bonus);
        draw.printEarningRate(purchaseCost);
    }
}
