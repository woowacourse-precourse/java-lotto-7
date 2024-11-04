package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {

    public static String purchaseAmountView() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static void showLottoNumbers(int count, List<Lotto> lottoList) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for(Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public static String winningNumberView() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }


    public static String bonusNumberView() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void showResult(List<Integer> result, String increase) {
        System.out.println("3개 일치 (5,000원) - " + result.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(4) + "개");
        System.out.println("총 수익률은 " + increase + "%입니다.");
    }
}
