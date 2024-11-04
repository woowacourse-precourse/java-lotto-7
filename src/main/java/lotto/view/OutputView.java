package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.Result;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void requestMoney() {
        System.out.println("구입금액을 입력해 주세요");
    }
    public static void printLottos(List<Lotto> lottos) {
        printNumberOfLotto(lottos);
        for (Lotto lotto : lottos) {
            printNumbers(lotto.getNumbers());
        }
    }
    private static void printNumberOfLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public static void printNumbers(List<Integer> numbers) {
        String result = "[" + numbers.stream()
                .map(String::valueOf).
                collect(Collectors.joining(", ")) + "]";
        System.out.println(result);
    }

    public static void requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printStastistics(Map<String,Integer> statistics) {
        System.out.println("당첨통계");
        System.out.println("'---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", statistics.getOrDefault("3개 일치", 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", statistics.getOrDefault("4개 일치", 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", statistics.getOrDefault("5개 일치", 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", statistics.getOrDefault("5개 일치, 보너스 볼 일치", 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", statistics.getOrDefault("6개 일치", 0));
    }
    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }
    
    public static void printErrorOfRequestMoney() {
        System.out.println("[ERROR] : 구입금액이 잘못 입력 되었습니다.");
    }
    public static void printErrorOfRequestNumbers() {
        System.out.println("[ERROR] : 당첨 번호가 잘못 입력 되었습니다.");
    }
    public static void printErrorOfRequestNumber() {
        System.out.println("[ERROR] : 보너스 번호가 잘못 입력 되었습니다.");
    }
}
