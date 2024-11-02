package lotto.view;

import lotto.constant.Prize;
import lotto.model.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPurchasePriceMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseLottoQuantity(Integer purchaseQuantity){System.out.println("\n"+purchaseQuantity+"개를 구매했습니다.");}

    public void printLotto(List<Lotto> lottos){
        for(Lotto lotto: lottos){
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printWinningNumbersMessage(){System.out.println("당첨 번호를 입력해 주세요.");}

    public void printBonusNumberMessage(){System.out.println("\n"+"보너스 번호를 입력해 주세요.");}

    public void printResult(HashMap<Prize, Integer> result){
        System.out.println();
        System.out.println("당첨 통계\n" + "---");

        for (Prize prize : Prize.values()) {
            int count = result.get(prize);
            System.out.print(prize.getCount() + "개 일치");
            if (prize.equals(Prize.FIVE_AND_BONUS)) System.out.print(", 보너스 볼 일치");
            System.out.println(" (" + prize.getPrize() + ") - " + count + "개");
        }
    }
}
