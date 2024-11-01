package lotto.controller.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.Lottery;

public class OutputView {
    public static final String TOTAL_PURCHASED_LOTTO = "개를 구매했습니다.";

    public OutputView() {
    }

    public void printLotteries(int buyCount, Lotteries lotteries){
        System.out.println(buyCount+TOTAL_PURCHASED_LOTTO);
        List<Lottery> lotteryList = lotteries.getLottery();
        for (Lottery lottery:lotteryList) {
            System.out.println(lottery.getNumbers().toString());
        }
    }
}
