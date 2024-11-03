package view;

import domain.Lotto;
import domain.PlayerBuyLotto;
import message.Message;

import java.util.List;

public class Output {

    public List<Lotto> printPurchasedLotto(int lottoPurchased) {

        PlayerBuyLotto playerBuyLotto = new PlayerBuyLotto();

        System.out.println(lottoPurchased + Message.AMOUNT_PURCHASED.getMessage());

        List<Lotto> lottos = playerBuyLotto.buyLotto(lottoPurchased);

        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();

        return lottos;
    }
}
