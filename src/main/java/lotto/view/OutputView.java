package lotto.view;
import lotto.domain.Lotto;
import lotto.domain.Winning;

import java.util.Collections;
import java.util.List;

public class OutputView {
    private final String PURCHASE_OUTPUT = "구입금액을 입력해 주세요.";
    private final String QUANTITY_OUTPUT="개를 구매했습니다.";
    private final String WINNINGNUMBER_OUTPUT="당첨 번호를 입력해 주세요.";
    private final String BONUSNUMBER_OUTPUT="보너스 번호를 입력해 주세요.";

    public void purchasePrint(){
        System.out.println(PURCHASE_OUTPUT);
    }

    public void quantityPrint(int lottoQuantity){
        System.out.println("\n"+lottoQuantity+QUANTITY_OUTPUT);
    }

    public void lottosPrint(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            Collections.sort(lotto.getLotto());
            System.out.println(lotto.getLotto());
        }
    }

    public void winningNumberPrint(){
        System.out.println("\n"+WINNINGNUMBER_OUTPUT);
    }

    public void bonusNumberPrint(){
        System.out.println("\n"+BONUSNUMBER_OUTPUT);
    }

    public void resultPrint(List<Winning> results) {
        System.out.println("\n"+"당첨통계"+"\n"+"---");
        for (Winning result : Winning.values()) {
            if (result == Winning.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", result.getNumberOfMatches(), result.getPrizeMoney(), result.getNumberOfLottos());
                continue;
            }

            System.out.printf("%d개 일치 (%s원) - %d개\n",
                    result.getNumberOfMatches(), result.getPrizeMoney(), result.getNumberOfLottos());
        }
    }

}
