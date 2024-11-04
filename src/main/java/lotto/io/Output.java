package lotto.io;

import java.util.List;

import lotto.Lotto;

public class Output {
    public static void money() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void number() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void purchase(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto l : lottos) {
            System.out.println(l.getNumbers());
        }
        System.out.println();
    }

    public static void statistic(long[] count, double interest) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + count[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + count[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + count[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + count[1] + "개");
        System.out.println("총 수익률은 " + String.format("%.1f", interest) + "%입니다.");
    }
}
