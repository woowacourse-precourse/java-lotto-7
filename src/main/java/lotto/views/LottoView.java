package lotto.views;

import lotto.domain.Lotto;
import lotto.domain.LottoPrice;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public static String inputWinningLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readLine();
    }

    public static void outputBuyLottoNumber(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    public static void outputLottoResult(int price, int matchCount) {
        System.out.println(LottoPrice.toString(price) + " - " + matchCount + "개");
    }

    public static void outputProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }

}