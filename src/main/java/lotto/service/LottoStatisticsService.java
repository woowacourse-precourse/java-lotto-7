package lotto.service;

import static lotto.constant.GlobalConstant.ROUND_PICK;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.view.OutputView;

public class LottoStatisticsService {
    private static final int THREE_MATCHES = 3;
    private static final int FOUR_MATCHES = 4;
    private static final int FIVE_MATCHES = 5;
    private static final int SIX_MATCHES = 6;
    private static final int BONUS_ENUM_LABEL = 7;
    private static final String DECIMAL_FORMAT = "###,##0.0";

    private final OutputView outputView;
    private Map<Winning, Integer> winningCounts;

    public LottoStatisticsService() {
        this.outputView = new OutputView();
        this.winningCounts = new HashMap<>();
    }

    public void winningStatistics(User user, Lotto winningLotto) {
        winningCounts(user, winningLotto);
        outputView.printWinningHistory(winningCounts);
        outputView.printWinningYield(getWinningYield(user, user.getWinningPrice()));
    }

    public void winningCounts(User user, Lotto winningLotto) {
        user.getLottoTickets().forEach(userLotto ->
                evaluateLottoResult(user, userLotto.getNumbers(), winningLotto));
    }

    public String getWinningYield(User user, int totalPrize) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        return decimalFormat.format((double) totalPrize / user.getPurchaseAmount() * 100);
    }

    public void evaluateLottoResult(User user, List<Integer> userNumbers, Lotto winningLotto) {
        int matchCount = countMatchingNumbers(userNumbers, winningLotto.getNumbers());

        if (isRegularWinning(matchCount)) {
            updateWinningCount(matchCount, user);
            return;
        }

        if (isFiveMatchesWithBonus(matchCount, userNumbers, winningLotto.getBonusNumber())) {
            updateWinningCount(BONUS_ENUM_LABEL, user);
            return;
        }

        if (isFiveMatchesOnly(matchCount, userNumbers, winningLotto.getBonusNumber())) {
            updateWinningCount(matchCount, user);
        }
    }

    public int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int i = 0; i < ROUND_PICK; i++) {
            if (userNumbers.contains(winningNumbers.get(i))) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public void updateWinningCount(int matchCount, User user) {
        Winning winning = Winning.fromMatchCount(matchCount);
        incrementWinningCount(winning);
        user.addWinningPrice(winning.getWinnings());
    }

    public void incrementWinningCount(Winning winning) {
        winningCounts.put(winning, winningCounts.getOrDefault(winning, 0) + 1);
    }

    public boolean isRegularWinning(int matchCount) {
        return matchCount == THREE_MATCHES || matchCount == FOUR_MATCHES || matchCount == SIX_MATCHES;
    }

    public boolean isFiveMatchesWithBonus(int matchCount, List<Integer> numbers, int bonusNumber) {
        return matchCount == FIVE_MATCHES && numbers.contains(bonusNumber);
    }

    public boolean isFiveMatchesOnly(int matchCount, List<Integer> numbers, int bonusNumber) {
        return matchCount == FIVE_MATCHES && !numbers.contains(bonusNumber);
    }
}
