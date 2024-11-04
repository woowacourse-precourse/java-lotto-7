package view;

import domain.Lotto;
import domain.PlayerBuyLotto;
import message.Message;
import message.Prize;

import java.util.List;
import java.util.Map;

public class Output {

    public final String count = "개";

    public List<Lotto> printPurchasedLotto(int lottoPurchased) {

        PlayerBuyLotto playerBuyLotto = new PlayerBuyLotto();

        System.out.println(lottoPurchased + Message.AMOUNT_PURCHASED.getMessage());

        List<Lotto> lottos = playerBuyLotto.buyLotto(lottoPurchased);

        for(Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();

        return lottos;
    }

    public void printStaticGuide() {

        System.out.println(Message.WINNING_STATISTICS.getMessage());
        System.out.println(Message.WAITING.getMessage());
    }

    public void printResult(Map<Prize, Integer> result) {

        for (Prize prize : result.keySet()) {
            System.out.println(prize.getResult() + result.get(prize) + count);
        }
    }

    public void printProfitRate(double rate) {

        System.out.println(Message.TOTAL_PROFIT_RATE.format(rate));
    }
}
