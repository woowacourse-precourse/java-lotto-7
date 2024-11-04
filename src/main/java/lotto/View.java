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
}
