package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.MatchLevel;
import lotto.utils.Validator;

public class LottoView {

    public long getPurchaseAmount() {

        try {
            System.out.println("구입 금액을 입력 해 주세요.");
            String input = Console.readLine();

            Validator.validatePurchaseInput(input);

            return Long.parseLong(input);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    public List<Integer> getWinningNumbers() {

        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            Validator.validateWinningNumbersInput(input);

            return List.of(input.split(",")).stream()
                                                    .map(Integer::parseInt)
                                                    .collect(Collectors.toList());

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {

        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            Validator.validateBonusNumberInput(input, winningNumbers);

            return Integer.parseInt(input);

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    public void displayPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void displayResult(Map<MatchLevel, Integer> result) {
        System.out.println("당첨 통계\n---");

        result.forEach((level, count) -> {
            if(level.isWin()) {
                System.out.printf(level.toString() + String.format(" - %d개\n", count));
            }
        });
    }

    public void displayProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }
}
