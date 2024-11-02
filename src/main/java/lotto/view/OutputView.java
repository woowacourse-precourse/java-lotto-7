package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    // todo: 발행된 로또의 수량과 번호를 오름차순으로 정리하여 출력
    public void printPurchasedLottos(List<Lotto> lottos){
        System.out.println(lottos + "개를 구매했습니다.");
        for(Lotto lotto : lottos){
            // todo : lotto 번호 출력
        }
    }

    // todo : 당첨 통계와 수익률을 포함한 전체 결과 출력
    public void printResult( List<Integer> result, double profitRate){
        System.out.println("당첨 통계");
        System.out.println("---");

        // todo : 개수에 맞춰서 출력하기
        System.out.println("3개 일치 (5,000원) - 1개");
        System.out.println("4개 일치 (50,000원) - 0개");
        System.out.println("5개 일치 (1,500,000원) - 0개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        System.out.println("6개 일치 (2,000,000,000원) - 0개");

        System.out.println("총 수익률은 " + profitRate + "%입니다.");

    }


}
