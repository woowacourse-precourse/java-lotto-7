package view;

import domain.Lotto;
import domain.PlayerBuyLotto;
import message.Message;
import message.Prize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Output {

    public final String count = "개";

    public List<Lotto> printPurchasedLotto(int lottoPurchased) {

        PlayerBuyLotto playerBuyLotto = new PlayerBuyLotto();

        System.out.println(lottoPurchased + Message.AMOUNT_PURCHASED.getMessage());

        List<Lotto> lottos = new ArrayList<>();
        lottos = playerBuyLotto.buyLotto(lottoPurchased);

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

        for (Prize prize : Prize.values()) {

            if (prize != Prize.MISS) {
                System.out.println(prize.getResult() + result.getOrDefault(prize, 0) + count);
            }
        }
    }

    public void printProfitRate(Map<Prize, Integer> result, int lottoAmount) {

        long totalProfit = 0;

        for(Prize prize : Prize.values()) {

            totalProfit += prize.getMoney() * result.get(prize);
        }

        double profitRate = (double) totalProfit / lottoAmount *100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
