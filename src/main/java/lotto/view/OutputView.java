package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.dto.LottoNumbers;
import lotto.constant.prize.Prize;

public class OutputView {
    public void displayPurchasePriceRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void displayPurchaseQuantity(final int quantity) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", quantity);
    }

    public void displayLottoNumbers(final List<LottoNumbers> lottoNumbers) {
        String result = lottoNumbers.stream()
                .map(LottoNumbers::numbers)
                .map(List::toString)
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }

    public void displayWinningNumbersRequest() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void displayBonusNumberRequest() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void displayWinningResult(final Map<Prize, Integer> result, final double rateOfReturn) {
        System.out.println("\n당첨 통계\n---");
        System.out.println(buildResult(result));
        System.out.printf("총 수익률은 %.2f%%입니다.%n", rateOfReturn);
    }

    private String buildResult(final Map<Prize, Integer> result) {
        return result.entrySet().stream()
                .map(entry -> String.format(entry.getKey().getResultMessage(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
