package lotto.io;

import java.util.List;
import java.util.Map;

public class ConsoleOutputHandler implements OutputHandler {
    @Override
    public void showLottoPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    @Override
    public void showLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    @Override
    public void showLottoList(List<Integer> numbers) {
        System.out.println(numbers);
    }

    @Override
    public void showWinningNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void showBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void showMatchResult(Map<String, Integer> matchResults, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (String result : matchResults.keySet()) {
            System.out.printf("%s - %d개%n", result, matchResults.get(result));
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
