package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.text.DecimalFormat;
import lotto.dto.IssuedLottosDto;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;
import lotto.dto.ResultItemDto;

public class ConsoleView implements View {
    private static final String EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s\n\n";
    private static final String NUMBER_OF_LOTTO_ISSUED_MESSAGE = "%d개를 구매했습니다.\n";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(" (#,##0원)");

    private static class PromptMessages {
        static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
        static final String WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
        static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

        private PromptMessages() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void displayException(String message) {
        System.out.printf(EXCEPTION_MESSAGE_FORMAT, message);
    }

    @Override
    public String promptPurchaseAmount() {
        return getUserInput(PromptMessages.PURCHASE_AMOUNT);
    }

    @Override
    public String promptWinningNumbers() {
        return getUserInput(PromptMessages.WINNING_NUMBERS);
    }

    @Override
    public String promptBonusNumber() {
        return getUserInput(PromptMessages.BONUS_NUMBER);
    }

    @Override
    public void displayIssuedLottos(IssuedLottosDto issuedLottos) {
        System.out.printf(NUMBER_OF_LOTTO_ISSUED_MESSAGE, issuedLottos.numberOfLottos());
        for (LottoDto lotto : issuedLottos.lottos()) {
            System.out.println(lotto.numbers());
        }
        System.out.println();
    }

    @Override
    public void displayResult(ResultDto result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (ResultItemDto resultItem : result.resultItems()) {
            System.out.println(getResultItemMessage(resultItem));
        }
        System.out.printf("총 수익률은 %s%%입니다.\n", result.roi().toString());
    }

    private String getResultItemMessage(ResultItemDto resultItem) {
        StringBuilder message = new StringBuilder();
        message.append(resultItem.numberOfMatch()).append("개 일치");
        if (resultItem.isBonusMatch()) {
            message.append(", 보너스 볼 일치");
        }
        message.append(DECIMAL_FORMAT.format(resultItem.prizeMoney()));
        message.append(" - ");
        message.append(resultItem.count()).append("개");
        return message.toString();
    }

    private String getUserInput(String message) {
        System.out.println(message);
        String input = readLine();
        System.out.println();
        return input;
    }
}
