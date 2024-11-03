package lotto.io;

import lotto.Lotto;
import lotto.LottoDrawingMachine;
import lotto.WinningStatics;
import lotto.utils.FormattingUtils;

import java.util.List;

public class ProgramOutput {
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COMPLETION_MESSAGE = "개를 구매했습니다.";
    private static final String REQUEST_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_INFORMATION_MESSAGE = "당첨 통계";
    private static final String HORIZON = "---";
    private static final String THREE_NUMBER_MATCH_MESSAGE = "3개 일치 (";
    private static final String FOUR_NUMBER_MATCH_MESSAGE = "4개 일치 (";
    private static final String FIVE_NUMBER_MATCH_MESSAGE = "5개 일치 (";
    private static final String FIVE_NUMBER_AND_BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (";
    private static final String SIX_NUMBER_MATCH_MESSAGE = "6개 일치 (";
    private static final String CURRENCY_UNIT = "원) - ";
    private static final String EA = "개";
    private static final String RATE_OF_RETURN_INFORMATION_MESSAGE = "총 수익률은 ";

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurChasedLotto(List<Lotto> purChasedLotto) {
        printNewLine();
        System.out.println(purChasedLotto.size() + PURCHASE_COMPLETION_MESSAGE);
        printLottoInformation(purChasedLotto);
        printNewLine();
    }

    public void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatistics(LottoDrawingMachine lottoDrawingMachine, List<Lotto> purChasedLotto) {
        printNewLine();
        System.out.println(WINNING_STATISTICS_INFORMATION_MESSAGE);
        System.out.println(HORIZON);
        WinningStatics statics = lottoDrawingMachine.matchWinningLotto(purChasedLotto);
        printStatistics(statics);
        printRateOfReturn(statics, purChasedLotto.size());
    }

    private void printRateOfReturn(WinningStatics statics, int count) {
        System.out.println(RATE_OF_RETURN_INFORMATION_MESSAGE
                + FormattingUtils.formatRateOfReturnMessage(statics.getRateOfReturn(count)));
    }

    private void printStatistics(WinningStatics statics) {
        System.out.println(THREE_NUMBER_MATCH_MESSAGE + FormattingUtils.formatCurrency(WinningStatics.FIFTH_PLACE_PRIZE)
                + CURRENCY_UNIT + statics.getFifth() + EA);
        System.out.println(FOUR_NUMBER_MATCH_MESSAGE + FormattingUtils.formatCurrency(WinningStatics.FOURTH_PLACE_PRIZE)
                + CURRENCY_UNIT + statics.getFourth() + EA);
        System.out.println(FIVE_NUMBER_MATCH_MESSAGE + FormattingUtils.formatCurrency(WinningStatics.THIRD_PLACE_PRIZE)
                + CURRENCY_UNIT + statics.getThird() + EA);
        System.out.println(FIVE_NUMBER_AND_BONUS_MATCH_MESSAGE
                + FormattingUtils.formatCurrency(WinningStatics.SECOND_PLACE_PRIZE)
                + CURRENCY_UNIT + statics.getSecond() + EA);
        System.out.println(SIX_NUMBER_MATCH_MESSAGE + FormattingUtils.formatCurrency(WinningStatics.FIRST_PLACE_PRIZE)
                + CURRENCY_UNIT + statics.getFirst() + EA);
    }

    private void printLottoInformation(List<Lotto> purchasedLotto) {
        purchasedLotto.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .forEach(System.out::println);
    }

    private void printNewLine() {
        System.out.println();
    }


}
