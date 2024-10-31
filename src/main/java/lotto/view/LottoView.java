package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public void displayLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public int readPurchaseAmount() {
        System.out.print("로또 구입 금액을 입력해 주세요: ");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> readWinningNumbers() {
        System.out.print("당첨 번호를 입력해 주세요: ");
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int readBonusNumber() {
        System.out.print("보너스 번호를 입력해 주세요: ");
        return Integer.parseInt(Console.readLine());
    }

    public void printLottoResult(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계\n---");
        lottoStatistics.getStatistics().forEach((key, value) -> {
            System.out.printf("%s - %d개%n", key, value);
        });
        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoStatistics.getYield());
    }

}
