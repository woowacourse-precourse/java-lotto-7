package lotto.domain;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.dto.Receipt;
import lotto.utils.LottoMatchStatus;
import lotto.utils.LottoMessages;

public class LottoResultPrinter {
    public void printResult(HashMap<LottoMatchStatus, Integer> lottoResult, Receipt receipt) {
        printOnTopic();
        printAllMatchResults(lottoResult);
        printProfitRate(lottoResult, receipt);
    }

    private void printOnTopic() {
        String message = Stream.of(
                LottoMessages.ENTER.getMessage(),
                LottoMessages.WINNING_STATISTICS.getMessage(),
                LottoMessages.ENTER.getMessage(),
                LottoMessages.LINE_SEPARATOR.getMessage().repeat(3)
        ).collect(Collectors.joining(""));

        System.out.println(message);
    }

    private void printAllMatchResults(HashMap<LottoMatchStatus, Integer> lottoResult) {
        Stream.of(LottoMatchStatus.values()).forEach(status -> {
            String message = Stream.of(
                    LottoMessages.ENTER.getMessage(),
                    status.getStatus(),
                    LottoMessages.LINE_SEPARATOR.getMessage(),
                    lottoResult.getOrDefault(status, 0) + "개"
            ).collect(Collectors.joining(" "));
            System.out.print(message.trim() + "\n");
        });
    }

    private void printProfitRate(HashMap<LottoMatchStatus, Integer> lottoResult, Receipt receipt){
        String message = LottoMessages.TOTAL_PROFIT_RATE.getMessage() +
                String.format("%.1f", calculateProfit(lottoResult, receipt)) + "%" +
                LottoMessages.END_MESSAGE.getMessage();

        System.out.print(message);
    }

    private double calculateProfit(HashMap<LottoMatchStatus, Integer> lottoResult, Receipt receipt){
        int totalProfit = lottoResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double profitRate = ((double) totalProfit / receipt.getPurchaseAmount()) * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}