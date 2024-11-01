package lotto.core;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.core.constants.WinningStatistics;
import lotto.util.InputValidationUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoRunner {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final int MINIMUM_UNIT = 1000;

    private int payment;
    private List<Lotto> lotteries;      // 뽑은 로또들
    private WinningNumbers winning;     // 당첨 번호 && 보너스 번호

    public void executeDraw() {
        int purchaseAmount = this.getPurchaseAmount();
        lotteries = this.selection(purchaseAmount);
        winning = new WinningNumbers();
        this.displayWinningStatistics();
    }

    private void displayWinningStatistics() {
        StringBuilder result = this.buildResultIntro();

        List<LottoMatchResult> matchResults = this.getLottoMatchResults();
        long prize = 0L;

        for (WinningStatistics stats : WinningStatistics.values()) {
            long matches = this.countWinningLottoByRank(matchResults, stats);
            prize += stats.getWinningPrize(matches);
            result.append(this.getStatsByRank(stats, matches));
        }
        result.append(this.getRateOfReturn(prize));

        System.out.println(result);
    }

    private StringBuilder buildResultIntro() {
        return new StringBuilder("당첨 통계")
            .append(System.lineSeparator())
            .append("---")
            .append(System.lineSeparator());
    }

    private String getRateOfReturn(long prize) {
        return String.format("총 수익률은 %.1f%%입니다.", (double) prize / payment * 100);
    }

    private String getStatsByRank(WinningStatistics stats, long matches) {
        String format = "%d개 일치 (%,d원) - %d개%n";
        if (stats.getMatchBonus()) {
            format = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
        }
        return String.format(format, stats.getMatchCount(), stats.getWinnings(), matches);
    }

    /**
     * 각 로또의 당첨 번호 일치 개수 및 보너스 번호 일치 여부
     */
    private List<LottoMatchResult> getLottoMatchResults() {
        List<LottoMatchResult> matchResults = new ArrayList<>();
        for (Lotto lotto : lotteries) {
            Set<Integer> matchedNumbers = new HashSet<>(lotto.getNumbers());
            boolean isBonusMatching = matchedNumbers.contains(winning.getBonusNumber());
            matchedNumbers.retainAll(winning.getWinningNumbers());      // 당첨된 숫자만 남기기
            matchResults.add(new LottoMatchResult(matchedNumbers.size(), isBonusMatching));
        }
        return matchResults;
    }

    private long countWinningLottoByRank(List<LottoMatchResult> matchResults, WinningStatistics stats) {
        return matchResults.stream().filter(match -> {
            boolean isCountMatch = match.matchCount() == stats.getMatchCount();
            if (stats.getMatchBonus()) {
                isCountMatch = isCountMatch && match.matchBonus();
            }
            return isCountMatch;
        }).count();
    }

    /**
     * 로또 구매 수량
     */
    private int getPurchaseAmount() {
        while (true) {
            try {
                payment = InputValidationUtils.parseInteger(this.inputPayment());
                this.validatePayment(payment);
                return this.calculatePurchaseAmount(payment);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    private String inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private int calculatePurchaseAmount(int payment) {
        int amount = payment / MINIMUM_UNIT;
        System.out.printf("%d개를 구매했습니다.\n", amount);
        return amount;
    }

    private void validatePayment(int payment) {
        if (payment % MINIMUM_UNIT > 0) {
            throw new IllegalArgumentException("구매 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    /**
     * 구매 수량만큼 무작위 로또 생성
     */
    private List<Lotto> selection(int amount) {
        List<Lotto> lotteries = new ArrayList<>();
        StringBuilder lottoSelectionOutput = new StringBuilder();

        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(this.getRandomNumbers());
            lotteries.add(lotto);
            lottoSelectionOutput
                .append(lotto.getNumberString())
                .append(System.lineSeparator());
        }
        System.out.println(lottoSelectionOutput);

        return lotteries;
    }

    private List<Integer> getRandomNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
