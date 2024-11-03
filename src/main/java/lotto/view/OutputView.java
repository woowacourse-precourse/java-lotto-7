package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.constant.WinningType;
import lotto.model.Lotto;
import lotto.model.WinningCondition;
import lotto.model.WinningResult;

public class OutputView {

    public static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String ISSUED_LOTTO_PRINTING_START_MESSAGE = "%d개를 구매했습니다.";
    public static final String ISSUED_LOTTO_PRINT_MESSAGE = "[%s]";
    public static final String WINNING_RESULT_PRINTING_START_MESSAGE = "당첨 통계\n---";
    public static final String WINNING_RESULT_CONTENT_MESSAGE = "%d개 일치 %s(%,d원) - %d개";
    public static final String BONUS_NUMBER_MATCHED_MESSAGE = "보너스 볼 일치 ";
    public static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f%%입니다.";
    public static final String INPUT_EXCEPTION_MESSAGE = "[ERROR] %s";

    public void printEmptyLine() {
        System.out.println();
    }

    public void printPurchasePriceInputMessage() {
        System.out.println(PURCHASE_PRICE_INPUT_MESSAGE);
    }

    public void printWinningNumberInputMessage() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printIssuedLottoCount(int count) {
        String startingMessage = String.format(ISSUED_LOTTO_PRINTING_START_MESSAGE, count);
        System.out.println(startingMessage);
    }

    public void printIssuedLotto(List<Lotto> issuedLotto) {
        for (Lotto lotto : issuedLotto) {
            String lottoContent = String.format(ISSUED_LOTTO_PRINT_MESSAGE, lotto.printLottoNumbers());
            System.out.println(lottoContent);
        }
    }

    public void printWinningResult(WinningResult winningResult) {
        System.out.println(WINNING_RESULT_PRINTING_START_MESSAGE);

        EnumMap<WinningType, Integer> countPerWinningType = winningResult.getCountPerWinningType();
        List<WinningType> allWinningTypes = List.of(WinningType.values()).reversed();
        allWinningTypes.forEach(type -> printWinningResultContent(type, countPerWinningType.get(type)));
    }

    private void printWinningResultContent(WinningType winningType, int count) {
        WinningCondition winningCondition = winningType.getCondition();

        String bonusBoolContent = "";
        if (winningCondition.isBonusNumberRequired()) {
            bonusBoolContent = BONUS_NUMBER_MATCHED_MESSAGE;
        }

        String content = String.format(
                WINNING_RESULT_CONTENT_MESSAGE,
                winningCondition.getMatchedNumberCount(), bonusBoolContent,
                winningType.getPrizeMoney(), count);
        System.out.println(content);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn));
    }

    public void printInputExceptionMessage(String exceptionMessage) {
        String content = String.format(INPUT_EXCEPTION_MESSAGE, exceptionMessage);
        System.out.println(content);
    }
}
