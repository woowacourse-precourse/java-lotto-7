package lotto.view;

import lotto.contants.message.NoticeMessage;
import lotto.contants.value.LottoValue;
import lotto.model.Lotto;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {
    public void printNoticeToPayMent() {
        System.out.println(NoticeMessage.PAYMENT);
    }

    public void printNoticeCountBuy(int count) {
        System.out.println();
        System.out.println(count + NoticeMessage.CONUT_BUY);
    }

    public void printLottoList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printNoticePrizeNumber() {
        System.out.println(NoticeMessage.PRIZE_NUMBER);
    }

    public void printNoticeBonusNumber() {
        System.out.println();
        System.out.println(NoticeMessage.BONUS_NUMBER);
    }

    public void printLottoResult(List<Integer> lottoSameSize, double rate) {
        System.out.println(NoticeMessage.TOTAL);
        System.out.println("---");
        System.out.println();
        System.out.println("3개 일치 " +
                "(" + NumberFormat.getInstance().format(LottoValue.RANK_FIFTH_MONEY) + ")"
                + " - " + lottoSameSize.get(4));
        System.out.println("4개 일치 " +
                "(" + NumberFormat.getInstance().format(LottoValue.RANK_FOURTH_MONEY) + ")"
                + " - " + lottoSameSize.get(3));
        System.out.println("5개 일치 " +
                "(" + NumberFormat.getInstance().format(LottoValue.RANK_THRID_MONEY) + ")"
                + " - " + lottoSameSize.get(2));
        System.out.println("5개 일치, 보너스 볼 일치 " +
                "(" + NumberFormat.getInstance().format(LottoValue.RANK_SECOND_MONEY) + ")"
                + " - " + lottoSameSize.get(1));
        System.out.println("6개 일치 " +
                "(" + NumberFormat.getInstance().format(LottoValue.RANK_FIRST_MONEY) + ")"
                + " - " + lottoSameSize.get(0));

        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

}
