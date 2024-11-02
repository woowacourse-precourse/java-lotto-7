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
}
