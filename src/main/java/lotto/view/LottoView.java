package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.prize.LottoPrizeInfo;

public class LottoView {
    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static final String PURCHASED_TICKETS_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE = "당첨 통계";
    private static final String WINNING_STATISTICS_SEPARATOR = "---";
    private static final String YIELD = "총 수익률은 %.1f%%입니다.";

    private static final List<LottoPrizeInfo> PRIZE_ORDER = List.of(
            LottoPrizeInfo.FIFTH_PRIZE,
            LottoPrizeInfo.FOURTH_PRIZE,
            LottoPrizeInfo.THIRD_PRIZE,
            LottoPrizeInfo.SECOND_PRIZE,
            LottoPrizeInfo.FIRST_PRIZE
    );

    private Supplier<String> inputSupplier;
    private Consumer<String> outputConsumer;

    public LottoView(Supplier<String> inputSupplier, Consumer<String> outputConsumer) {
        this.inputSupplier = inputSupplier;
        this.outputConsumer = outputConsumer;
    }

    public String inputPurchaseAmount() {
        outputConsumer.accept(PROMPT_PURCHASE_AMOUNT);
        return inputSupplier.get();
    }

    public String inputWinningNumbers() {
        outputConsumer.accept(PROMPT_WINNING_NUMBERS);
        return inputSupplier.get();
    }

    public String inputBonusNumber() {
        outputConsumer.accept(PROMPT_BONUS_NUMBER);
        return inputSupplier.get();
    }

    public void printStatistics(Map<LottoPrizeInfo, Integer> prizeCounts, Double rate) {
        outputConsumer.accept(WINNING_STATISTICS_TITLE);
        outputConsumer.accept(WINNING_STATISTICS_SEPARATOR);

        PRIZE_ORDER.forEach(prizeInfo -> printPrizeInfo(prizeInfo, prizeCounts.getOrDefault(prizeInfo, 0)));

        outputConsumer.accept("");
        outputConsumer.accept(String.format(YIELD, rate));
    }

    public void printRottos(List<Lotto> lottos) {
        outputConsumer.accept(String.format(PURCHASED_TICKETS_MESSAGE, lottos.size()));
        lottos.forEach(this::printLotto);
        outputConsumer.accept("");
    }

    private void printLotto(Lotto lotto) {
        String formattedNumbers = lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        outputConsumer.accept(formattedNumbers);
    }

    private void printPrizeInfo(LottoPrizeInfo prizeInfo, int count) {
        String formattedAmount = formatPrizeAmount(prizeInfo.getPrizeAmount());
        String matchMessage = buildMatchMessage(prizeInfo, formattedAmount);
        outputConsumer.accept(matchMessage + " - " + count + "개");
    }

    private String buildMatchMessage(LottoPrizeInfo prizeInfo, String formattedAmount) {
        StringBuilder matchMessage = new StringBuilder();
        matchMessage.append(prizeInfo.matchCount).append("개 일치");
        if (prizeInfo.hasBonus) {
            matchMessage.append(", 보너스 볼 일치");
        }
        matchMessage.append(" (").append(formattedAmount).append("원)");
        return matchMessage.toString();
    }

    private String formatPrizeAmount(long amount) {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(amount);
    }

    public void printError(String message) {
        outputConsumer.accept(message);
    }
}
