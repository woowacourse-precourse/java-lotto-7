package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    //발행된 로또의 수량과 번호를 오름차순으로 정리하여 출력
    public void printPurchasedLottos(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    // 당첨 통계와 수익률을 포함한 전체 결과 출력
    public void printResult(Map<Rank,Integer> result, double profitRate){
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - "+ result.get(Rank.FIFTH) +"개");
        System.out.println("4개 일치 (50,000원) - "+result.get(Rank.FOURTH)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result.get(Rank.THIRD)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result.get(Rank.SECOND)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+result.get(Rank.FIRST)+"개");

        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);

    }


}
