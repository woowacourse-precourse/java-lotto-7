package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningState;

import java.util.Map;

public class LottoView {
    public static String inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine().trim();
    }

    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }

    public static void printTurn(int turn) {
        System.out.println(turn + "개를 구매했습니다.");
    }

    public static void printLotto(String result) {
        System.out.println(result);
    }

    public static void printResult(Map<String, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + String.format("%,d", WinningState.valueOf("FIFTH_PRIZE").getAmount()) + "원) - " + result.get("FIFTH_PRIZE"));
        System.out.println("4개 일치 (" + String.format("%,d", WinningState.valueOf("FOURTH_PRIZE").getAmount()) + "원) - " + result.get("FOURTH_PRIZE"));
        System.out.println("5개 일치 (" + String.format("%,d", WinningState.valueOf("THIRD_PRIZE").getAmount()) + "원) - " + result.get("THIRD_PRIZE"));
        System.out.println("5개 일치, 보너스 볼 일치 (" + String.format("%,d", WinningState.valueOf("SECOND_PRIZE").getAmount()) + "원) - " + result.get("SECOND_PRIZE"));
        System.out.println("6개 일치 (" + String.format("%,d", WinningState.valueOf("FIRST_PRIZE").getAmount()) + "원) - " + result.get("FIRST_PRIZE"));
    }
}
