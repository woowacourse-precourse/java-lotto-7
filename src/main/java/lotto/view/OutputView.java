package lotto.view;

import static lotto.enums.Message.SEPARATOR;
import static lotto.enums.Message.PURCHASE_HEADER;
import static lotto.enums.Message.WINNING_STATISTICS_HEADER;
import static lotto.enums.Message.RATE_RETURN;
import static lotto.enums.Symbol.CLOSE_BRACKET;
import static lotto.enums.Symbol.COMMA_SPACE;
import static lotto.enums.Symbol.NEW_LINE;
import static lotto.enums.Symbol.OPEN_BRACKET;
import java.math.BigDecimal;
import lotto.enums.Message;
import lotto.enums.Prize;
import lotto.model.Lotto;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {}

    public static OutputView getInstance() {
        return instance;
    }

    public void showMessage(Message message) {
        System.out.println(message.getText());
    }

    public void showLottoNumbers(List<Lotto> lottos) {
        String formattedLottos = formatLottos(lottos);
        System.out.println(NEW_LINE.getValue() + lottos.size() + PURCHASE_HEADER.getText()
                + NEW_LINE.getValue() + formattedLottos + NEW_LINE.getValue());
    }

    public void showFinalResult(Map<Prize, Integer> finalResult, BigDecimal rate) {
        System.out.print(formatFinalResult(finalResult)
                + NEW_LINE.getValue()
                + formatRateMessage(rate));
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }

    private String formatLottos(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::formatSingleLotto)
                .collect(Collectors.joining(NEW_LINE.getValue()));
    }

    private String formatSingleLotto(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(
                        COMMA_SPACE.getValue(),
                        OPEN_BRACKET.getValue(),
                        CLOSE_BRACKET.getValue()));
    }

    private StringBuilder formatFinalResult(Map<Prize, Integer> finalResult) {
        StringBuilder finalResultBuilder = new StringBuilder()
                .append(NEW_LINE.getValue())
                .append(WINNING_STATISTICS_HEADER.getText())
                .append(NEW_LINE.getValue())
                .append(SEPARATOR.getText())
                .append(NEW_LINE.getValue());

        for (Prize prize : Prize.values()) {
            finalResultBuilder.append(formatPrizeMessage(prize, finalResult)).append(NEW_LINE.getValue());
        }

        return finalResultBuilder;
    }

    private String formatPrizeMessage(Prize prize, Map<Prize, Integer> finalResult) {
        int matches = finalResult.getOrDefault(prize, 0);
        return prize.createMessage(matches);
    }

    private String formatRateMessage(BigDecimal rate) {
        return String.format(RATE_RETURN.getText(), rate);
    }
}
