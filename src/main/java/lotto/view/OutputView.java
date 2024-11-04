package lotto.view;

import lotto.constants.RequestMessage;
import lotto.constants.ResultMessage;
import lotto.domain.LottoWinningTierManager;

import static lotto.constants.LottoConstants.EMPTY;
import static lotto.constants.LottoConstants.ZERO;

public class OutputView {
    public void printMessage (String message) {
        System.out.println(message);
    }
    public void printNewLine() {
        printMessage(EMPTY);
    }

    // 요정 관련 출력
    public void printRequestPurchaseAmount () {
        printMessage(RequestMessage.ENTER_PURCHASE_AMOUNT.getMessage());
    }
    public void printRequestWinningNumbers () {
        printNewLine();
        printMessage(RequestMessage.ENTER_WINNING_NUMBERS.getMessage());
    }
    public void printRequestBonusNumber () {
        printNewLine();
        printMessage(RequestMessage.ENTER_BONUS_NUMBER.getMessage());
    }

    // 결과 관련 출력
    public void printPurchasedLottoCount (int lottoCount) {
        printNewLine();
        printMessage(ResultMessage.PURCHASED_LOTTO.getIntMessage(lottoCount));
    }
    public void printStartWinResult () {
        printNewLine();
        printMessage(ResultMessage.WIN_RESULT.getMessage());
    }
    public void printTotalProfitRate (double profitRate) {
        printMessage(ResultMessage.TOTAL_PROFIT_RATE.getProfitRateMessage(profitRate));
    }
    public void printLottoPlace (LottoWinningTierManager lottoWinningTierManager) {
        lottoWinningTierManager.getLottoWinningTiers().forEach(((tier, value) -> {
            if (tier.getMatchCount() != ZERO && tier.getCountMessage(lottoWinningTierManager.getWinningTierCount(tier)) != null) {
                printMessage(tier.getCountMessage(lottoWinningTierManager.getLottoWinningTiers().get(tier)));
            }
        }));
    }
}
