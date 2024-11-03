package lotto.view;

import lotto.domain.LottoWinningTierManager;

import static lotto.constants.LottoConstants.EMPTY;

public class OutputView {
    public void printMessage (String message) {
        System.out.println(message);
    }
    public void printNewLine() {
        printMessage(EMPTY);
    }
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
            if (tier.getMatchCount() != 0 && tier.getCountMessage(lottoWinningTierManager.getWinningTierCount(tier)) != null) {
                printMessage(tier.getCountMessage(lottoWinningTierManager.getLottoWinningTiers().get(tier)));
            }
        }));
    }
}
