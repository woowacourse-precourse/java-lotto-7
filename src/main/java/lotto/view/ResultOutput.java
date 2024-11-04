package lotto.view;

import lotto.domain.WinRecord;

import java.util.Arrays;
import java.util.List;

public class ResultOutput {
    private enum OutputMessage {
        OUTPUT_PURCHASE_AMOUNT_COUNT_PROMPT("\n%d개를 구매했습니다.\n"),
        OUTPUT_LOTTO_NUMBER_PROMPT("[%d, %d, %d, %d, %d, %d]\n"),
        OUTPUT_WINNING_PROMPT("\n당첨 통계\n" +
                "---\n"),
        OUTPUT_WINNING_MATCH_PROMPT("3개 일치 (%,d원) - %d개\n" +
                "4개 일치 (%,d원) - %d개\n" +
                "5개 일치 (%,d원) - %d개\n" +
                "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n" +
                "6개 일치 (%,d원) - %d개\n"),
        OUTPUT_TOTAL_YIELD_PROMPT("총 수익률은 %.1f%%입니다.\n");

        final private String message;

        public String getMessage() {
            return message;
        }

        OutputMessage(String message) {
            this.message = message;
        }
    }

    public void displayPurchaseCount(int purchaseCount) {
        System.out.printf(OutputMessage.OUTPUT_PURCHASE_AMOUNT_COUNT_PROMPT.getMessage(),
                purchaseCount);
    }

    public void displayUserLotto(List<Integer> userLotto) {
        String output = String.format(
                OutputMessage.OUTPUT_LOTTO_NUMBER_PROMPT.getMessage(),
                userLotto.toArray()
        );
        System.out.printf(output);
    }

    public void displayWinRecord(List<Integer> winRecord) {
        List<String> winnigMatchLines = Arrays.asList(OutputMessage.OUTPUT_WINNING_MATCH_PROMPT.getMessage().split("\n"));
        StringBuilder output = new StringBuilder();
        output.append(OutputMessage.OUTPUT_WINNING_PROMPT.getMessage());
        for (int i = winRecord.size() - 1, j = 0; i > 0; i--, j++) {
            output.append(String.format(winnigMatchLines.get(j),
                    WinRecord.WINNING_PRIZES.get(i),
                    winRecord.get(i)) + "\n");
        }
        System.out.printf(output.toString());
    }

    public void displayTotalYield(double totalYield){
        System.out.printf(OutputMessage.OUTPUT_TOTAL_YIELD_PROMPT.getMessage(),
                totalYield);
    }
}
