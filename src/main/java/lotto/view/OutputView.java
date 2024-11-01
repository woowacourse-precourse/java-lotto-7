package lotto.view;

import lotto.dto.LottoResult;
import lotto.dto.LottoResultDto;

import java.util.Map;

public class OutputView {

    public void printPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printPurchaseLottoList(LottoResultDto lottoDto) {
        System.out.println();
        System.out.println(lottoDto.getPurchaseQuantity() + "개를 구매했습니다.");
        lottoDto.getLottoList().forEach(System.out::println);
        System.out.println();
    }

    public void printWinningNumberInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoStatistics(Map<LottoResult, Integer> printResultList) {
        System.out.println("당첨 통계\n" + "---");
        for (LottoResult resultType : LottoResult.values()) {
            int count = printResultList.getOrDefault(resultType, 0);
            System.out.println(resultType.getMessage() + " - " + count + "개");
        }
    }

    public void printWinningRate(double winningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", winningRate);
    }
}
