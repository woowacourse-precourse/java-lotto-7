package lotto.view.output;

import lotto.dto.LottoResponse;
import lotto.dto.LottoResultResponse;

import java.util.List;

public class ConsoleOutputView implements OutPutView{

    @Override
    public void displayPurchaseAmountPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void displayPurchaseCount(Integer purchaseCount) {
        System.out.printf("\n%d개를 구매했습니다.\n", purchaseCount);
    }
    @Override
    public void displayPurchaseLotto(List<LottoResponse> lottoResponses) {
        for (LottoResponse lottoResponse : lottoResponses) {
            System.out.println(lottoResponse.lottoNumber());
        }
        System.out.println();
    }

    @Override
    public void displayWinningNumberPrompt() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void displayBonusNumberPrompt() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void displayLottoResults(LottoResultResponse lottoResultResponse) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (String lottoResult : lottoResultResponse.lottoResultResponse()) {
            System.out.println(lottoResult);
        }
    }

    @Override
    public void displayTotalReturnOfRate(Double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }

    @Override
    public void displayExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
