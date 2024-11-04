package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Money;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class OutputView {

    public static void printBuyLottoCount(Money money){
        System.out.printf(("%d개를 구매했습니다.") + "%n", money.getLottoCount());
    }

    public static void printLottoList(List<Lotto> lottos){
        lottos.getLotto().forEach(System.out::println);
        System.out.println();
    }

    public static void printLottResult(LottoResult result){
        System.out.println("당첨통계");
        System.out.println("---");
    }

}
