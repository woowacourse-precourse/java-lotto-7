package lotto.controller;

import static lotto.validator.AmountValidator.isNumber;

import java.util.HashMap;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.User;
import lotto.service.LottoService;
import lotto.util.InputParser;
import lotto.validator.AmountValidator;
import lotto.view.View;

public class LottoController {
    View view;
    LottoService service;

    public LottoController(View view, LottoService service) {
        this.view = view;
        this.service = service;
    }

    public void run(User user) {
        setupTickets(user);
        setupWinningNumbers();
        printResults(user);
    }

    private void setupTickets(User user) {
        int amount = getAmount();
        int ticketCount = calculateTickets(amount);
        view.printPurchaseMessage(ticketCount);
        service.provideLottoTickets(user, ticketCount);
        view.printLottoNumbers(user.getLottoTickets());
    }

    private int getAmount() {
        int amount = isNumber(view.getUserInput());
        AmountValidator.checkAmount(amount);
        return amount;
    }

    private int calculateTickets(int amount) {
        return amount / 1000;
    }

    private void setupWinningNumbers() {
        String[] winningNumbers = InputParser.splitNumbers(view.getWinningNumbers());
        service.setExtra(isNumber(winningNumbers), isNumber(view.getBonusNumbers()));
    }

    private void printResults(User user) {
        Map<Lotto, Map<String, Object>> results =
                service.checkMatches(service.getWinningNumbers(), service.getBonusNumbers());

        // 결과 카운트 초기화 및 업데이트
        Map<LottoRank, Integer> rankCounts = initRanks();
        countMatches(results, rankCounts);

        // 결과 출력
        printCounts(rankCounts);

        // 수익률 계산 및 출력
        printProfit(rankCounts, user);


    }

    // LottoRank 별로 결과 카운트를 0으로 초기화
    private Map<LottoRank, Integer> initRanks() {
        Map<LottoRank, Integer> rankCounts = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }

    // 결과를 LottoRank에 따라 카운트 업데이트
    private void countMatches(Map<Lotto, Map<String, Object>> results, Map<LottoRank, Integer> rankCounts) {
        for (Map<String, Object> lotto : results.values()) {
            int matchCount = (int) lotto.get("matchCount");
            boolean bonusMatch = (boolean) lotto.get("bonusMatch");
            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
    }

    // 각 LottoRank 결과를 출력
    private void printCounts(Map<LottoRank, Integer> rankCounts) {
        for (LottoRank rank : LottoRank.values()) {
            int count = rankCounts.get(rank);
            int prize = rank.getPrize();
            if (rank.getMatchCount() >= 3) { // 3개 이상 일치하는 경우만 출력
                System.out.printf("%d개 일치 (%s원) - %d개%n",
                        rank.getMatchCount(),
                        String.format("%,d", prize), count);
            }
        }
    }

    // 수익률을 계산하고 출력
    private void printProfit(Map<LottoRank, Integer> counts, User user) {
        int totalPrize = 0;
        int ticketCount = user.getLottoTickets().size();
        for (LottoRank rank : LottoRank.values()) {
            totalPrize += counts.get(rank) * rank.getPrize();
        }
        double profitRate = (double) totalPrize / (ticketCount * 1000) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }


}
