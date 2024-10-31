package lotto.View;

import lotto.Model.Lotto;

import java.util.List;

public class OutputView {

    public void printLottoNum(List<Lotto> numbers) {

        for (Lotto lotto : numbers) {
            lotto.print();
        }
    }

    public void printPrize(List<Integer> prizeNum, int tryCount, int totalPrize) {
        System.out.println(prizeNum.toString() + tryCount + totalPrize);
        System.out.println("3개 일치 (5,000원) - " + prizeNum.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeNum.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeNum.get(3) + "개");
        System.out.println("5개 일치 (30,000,000원) - " + prizeNum.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeNum.get(1) + "개");
        System.out.println("총 수익률은 " +  Math.round((((double) totalPrize/(tryCount*1000))*100)*10)/10.0 + "%입니다.");
    }

}
