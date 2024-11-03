package lotto.controller.view;

import java.util.List;
import lotto.domain.lottery.Lotteries;
import lotto.domain.lottery.Lottery;

public class OutputView {
    public static final String TOTAL_PURCHASED_LOTTO = "개를 구매했습니다.";

    public OutputView() {
    }

    public void printLotteries(Lotteries lotteries){
        System.out.println(lotteries.getLottery().size()+TOTAL_PURCHASED_LOTTO);
        List<Lottery> lotteryList = lotteries.getLottery();
        for (Lottery lottery:lotteryList) {
            System.out.println(lottery.getNumbers().toString());
        }
    }
}
