package lotto.io;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputHandler {

    private static final String PURCHASE_AMOUNT_INSTRUCTION_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INSTRUCTION_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_RESULT_FORMAT = "%d개를 구매했습니다.%n";
    private static final String BONUS_NUMBER_INSTRUCTION_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATIC_RESULT_MESSAGE = "\n당첨 통계\n---\n";
    private static final String TOTAL_PROFIT_FORMAT = "총 수익률은 %.1f%%입니다.%n";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NOTATION_PREFIX = "[";
    private static final String LOTTO_NOTATION_SUFFIX = "]";

    public void showPurchaseAmountInstruction() {
        System.out.println(PURCHASE_AMOUNT_INSTRUCTION_MESSAGE);
    }

    public void showWinningNumbersInstruction() {
        System.out.println();
        System.out.println(WINNING_NUMBER_INSTRUCTION_MESSAGE);
    }

    public void showBonusNumberInstruction() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INSTRUCTION_MESSAGE);
    }

    public void showWinningStatisticsComment() {
        System.out.printf(STATIC_RESULT_MESSAGE);
    }

    public void showLottos(List<Lotto> lottos) {
        showPurchaseInformation(lottos);
        showLottosNotation(lottos);
    }

    public void showWinningResult(WinningResult result) {
        System.out.println(Rank.notationFrom(result));
    }

    public void showTotalPrize(WinningResult result) {
        System.out.printf(TOTAL_PROFIT_FORMAT, result.getProfitRate());
    }

    private void showPurchaseInformation(List<Lotto> lottos) {
        System.out.println();
        System.out.printf(PURCHASE_RESULT_FORMAT, lottos.size());
    }

    private void showLottosNotation(List<Lotto> lottos) {
        lottos.stream()
            .map(Lotto::getSortedNumbersByAscending)
            .map(this::convertLottoNotation)
            .forEach(System.out::println);
    }

    private String convertLottoNotation(List<Integer> numbers) {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER, LOTTO_NOTATION_PREFIX, LOTTO_NOTATION_SUFFIX));
    }

}
