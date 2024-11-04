package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IO {
    public String readPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String readWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void printPurchaseLottoResult(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (int i = 0; i < lottos.size(); i++) {
            String result = lottos.get(i)
                    .getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + result + "]");
        }
    }

    public void printResult(Map<WinningStandard, Integer> winningResult, double earningsRate) {
        System.out.println("당첨통계\n---");
        // TODO: 당첨 통계 출력 (n개 일치)
        for (WinningStandard place : WinningStandard.values()) {
            int count = winningResult.get(place);
            System.out.printf("%d개 일치 (%d원) - %d개\n", place.getMatchingNumber(), place.getPrize(), count);
        }
        System.out.printf("총 수익률은 %f입니다", earningsRate);
    }
}
