package lotto.view;

import lotto.dto.LottoStatisticDTO;
import lotto.model.Lotto;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoStatistics;

public class LottoView {
    public void displayError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void displayLottoCount(LottoStatisticDTO lottoStatistic) {
        System.out.println(lottoStatistic.quantity() + "개를 구매했습니다.");
    }

    public void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public int readPurchaseAmount() {
        System.out.print("로또 구입 금액을 입력해 주세요: ");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> readUserLotto() {
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

    public void printLottoResult(LottoStatistics lottoStatistic) {
        LottoStatisticDTO lottoStatisticDTO = lottoStatistic.toDTO();
        System.out.println("당첨 통계\n---");
        lottoStatisticDTO.statistics().forEach((key, value) -> System.out.printf("%s - %d개%n", key, value));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoStatisticDTO.yield());
    }

}
