package lotto.printer;

import java.util.List;
import lotto.Lotto;

public class ResultPrinter {

    public static void printLottoesBought(List<Lotto> lottoes) {
        System.out.println(lottoes.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoes) {
            System.out.println(lotto);
        }
        System.out.println();
    }


}
