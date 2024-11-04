package lotto.view;

import lotto.contants.message.NoticeMessage;
import lotto.model.Lotto;

import java.util.List;

public class Output {
    public void printCountLotto(int countLotto) {
        System.out.println();
        System.out.println(countLotto + NoticeMessage.CONUT_BUY.getMessage());
    }

    public void printLottoList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResult(List<Integer> lottoSameSize, double rate) {
        System.out.println(NoticeMessage.TOTAL.getMessage());
        System.out.println(NoticeMessage.RANK_FIFTH_PRIZE.getMessage() + lottoSameSize.get(4) + "개");
        System.out.println(NoticeMessage.RANK_FOURTH_PRIZE.getMessage() + lottoSameSize.get(3) + "개");
        System.out.println(NoticeMessage.RANK_THIRD_PRIZE.getMessage() + lottoSameSize.get(2) + "개");
        System.out.println(NoticeMessage.RANK_SECOND_PRIZE.getMessage() + lottoSameSize.get(1) + "개");
        System.out.println(NoticeMessage.RANK_FIRST_PRIZE.getMessage() + lottoSameSize.get(0) + "개");

        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

}
