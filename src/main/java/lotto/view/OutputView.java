package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.Prize.*;

public class OutputView {
    public void showPurchasedLotteries(List<Lotto> all_lottos){
        System.out.println("\n" + all_lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto: all_lottos) {
            String output_one = lotto.getNumbers().stream()
                                                    .map(String::valueOf)
                                                    .collect(Collectors.joining(","));
            System.out.println("[" + output_one + "]");
        }
    }

    public void showResult(LottoResult result, Integer pay_amount) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (" + fifth.getPrize() + "원) - " + result.getValue(fifth) +"개");
        System.out.println("4개 일치 (" + forth.getPrize() + "원) - " + result.getValue(forth) +"개");
        System.out.println("5개 일치 (" + third.getPrize() + "원) - " + result.getValue(third) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + second.getPrize() + "원) - " + result.getValue(second) +"개");
        System.out.println("6개 일치 (" + first.getPrize() + "원) - " + result.getValue(first) +"개");
        Double rate = result.calculateEarningsRate(pay_amount);
        System.out.println("총 수익률은 "+ String.format("%.1f", rate) +"%입니다.");
    }
}
