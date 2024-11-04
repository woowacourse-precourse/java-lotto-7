package lotto.view.output;

import lotto.dto.LottoResponse;
import lotto.dto.LottoResultResponse;

import java.util.List;

public class ConsoleOutputView implements OutPutView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_STATISTICS_HEADER = "당첨 통계\n---";
    private static final String TOTAL_RETURN_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    @Override
    public void displayPurchaseAmountPrompt() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
    }

    @Override
    public void displayPurchaseCount(Integer purchaseCount) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, purchaseCount);
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
        System.out.println(WINNING_NUMBER_PROMPT);
    }

    @Override
    public void displayBonusNumberPrompt() {
        System.out.println(BONUS_NUMBER_PROMPT);
    }

    @Override
    public void displayLottoResults(LottoResultResponse lottoResultResponse) {
        System.out.println();
        System.out.println(LOTTO_STATISTICS_HEADER);
        for (String lottoResult : lottoResultResponse.lottoResultResponse()) {
            System.out.println(lottoResult);
        }
    }

    @Override
    public void displayTotalReturnOfRate(Double rate) {
        System.out.printf(TOTAL_RETURN_RATE_MESSAGE, rate);
    }

    @Override
    public void displayExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
