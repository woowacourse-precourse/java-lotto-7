package lotto.io;


public class View {
    public static void printLotto(Integer count, String lottos) {
        System.out.println(count + "개를 구매했습니다.");
        System.out.println(lottos);
    }

    public static void printWinningResult(String results) {
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println(results);
    }

    public static void printProfit(Double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    public static void printInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printInputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void showError(String message) {
        System.out.println(message);
    }
}
