package lotto.view;

import static lotto.view.Prompt.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class OutputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_NOTICE_HEADER = "개를 구매했습니다.";
    private static final String MATCH_MESSAGE = "%d개 일치 (%s원) - ";
    private static final String MATCH_BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String COUNT_SUFFIX = "개";
    private static final String YIELD_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String OPEN_LOTTO_NUMBER = "[";
    private static final String CLOSE_LOTTO_NUMBER = "]";
    private static final String NUMBER_SEPARATOR = ", ";
    private static final String PRIZE_THREE_MATCH = "5,000";
    private static final String PRIZE_FOUR_MATCH = "50,000";
    private static final String PRIZE_FIVE_MATCH = "1,500,000";
    private static final String PRIZE_SIX_MATCH = "2,000,000,000";
    private static final String NEW_LINE = "\n";

    public static void showPrompt(Prompt prompt) {
        if (prompt.equals(PURCHASE_AMOUNT)) {
            System.out.println(PURCHASE_AMOUNT_PROMPT);
        }

        if (prompt.equals(WINNING_NUMBERS)) {
            System.out.println(WINNING_NUMBERS_PROMPT);
        }

        if (prompt.equals(BONUS_NUMBER)) {
            System.out.println(NEW_LINE + BONUS_NUMBER_PROMPT);
        }
    }

    public static void showLottoNumbers(List<Lotto> lottos) {
        String formattedLottoNumbers = lottos.stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining(NUMBER_SEPARATOR, OPEN_LOTTO_NUMBER, CLOSE_LOTTO_NUMBER)))
                .collect(Collectors.joining(NEW_LINE));

        System.out.println(NEW_LINE + lottos.size() + PURCHASE_NOTICE_HEADER
                + NEW_LINE + formattedLottoNumbers + NEW_LINE);
    }

    public static void showFinalResult(Map<Integer, Integer> matchCounts, double yield) {
        StringBuilder winningResultOutput = prepareWinningResult(matchCounts);
        String yieldOutput = prepareYield(yield);
        System.out.print(winningResultOutput + NEW_LINE + yieldOutput);
    }

    private static StringBuilder prepareWinningResult(Map<Integer, Integer> matchCounts) {
        StringBuilder winningResultOutput = new StringBuilder();

        appendHeader(winningResultOutput);
        appendWinningMessages(winningResultOutput, matchCounts);

        return winningResultOutput;
    }

    private static String prepareYield(double yield) {
        String yieldOutput = String.format(YIELD_MESSAGE, yield);

        return yieldOutput;
    }

    public static void showErrorMessage(String message) {
        System.out.println(message);
    }

    private static void appendHeader(StringBuilder result) {
        result.append(NEW_LINE)
                .append(WINNING_STATISTICS_HEADER)
                .append(NEW_LINE)
                .append(DIVIDER)
                .append(NEW_LINE);
    }

    private static void appendWinningMessages(StringBuilder result, Map<Integer, Integer> matchCounts) {
        Map<Integer, String> messages = prepareMessages();
        ArrayList<Integer> keys = new ArrayList<>(messages.keySet());

        for (int i = 0; i < keys.size(); i++) {
            Integer key = keys.get(i);
            String message = messages.get(key);
            result.append(message)
                    .append(matchCounts.get(key))
                    .append(COUNT_SUFFIX);

            if (i < keys.size() - 1) {
                result.append(NEW_LINE);
            }
        }
    }

    private static Map<Integer, String> prepareMessages() {
        Map<Integer, String> messages = new LinkedHashMap<>();
        messages.put(3, String.format(MATCH_MESSAGE, 3, PRIZE_THREE_MATCH));
        messages.put(4, String.format(MATCH_MESSAGE, 4, PRIZE_FOUR_MATCH));
        messages.put(5, String.format(MATCH_MESSAGE, 5, PRIZE_FIVE_MATCH));
        messages.put(-5, MATCH_BONUS_MESSAGE);
        messages.put(6, String.format(MATCH_MESSAGE, 6, PRIZE_SIX_MATCH));

        return messages;
    }
}
