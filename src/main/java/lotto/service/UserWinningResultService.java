package lotto.service;

import lotto.collection.Lotto;
import lotto.collection.LottoTickets;
import lotto.domain.LottoResult;
import lotto.domain.user.User;
import lotto.enums.LottoConstant;
import lotto.util.LottoWinningPriceList;
import lotto.view.OutputView;

import static lotto.view.OutputView.WINNING_STATISTICS;

public class UserWinningResultService {
    // 싱글톤 패턴
    private static final UserWinningResultService instance = new UserWinningResultService();
    private final UserService userService = UserService.getInstance();

    private UserWinningResultService() {

    }

    public static UserWinningResultService getInstance() {
        return instance;
    }

    public void getWinningResult(LottoResult lottoResult, int userId) {
        User user = userService.findById(userId);

        OutputView.newLine();
        OutputView.printMessage(WINNING_STATISTICS);
        double rateOfRevenue = generateStatistics(lottoResult, user);

        OutputView.printTotalReturn(rateOfRevenue);
    }

    private double generateStatistics(LottoResult lottoResult, User user) {
        int[][] lottoMatchCount = countMatchWinningNumber(lottoResult, user);
        for (int match = 3; match <= LottoConstant.COUNT.getValue(); match++) {
            OutputView.printWinningResult(match, lottoMatchCount);
        }
        return user.getRateOfReturn();
    }

    private int[][] countMatchWinningNumber(LottoResult lottoResult, User user) {
        int[][] resultTable = new int[LottoConstant.COUNT.getValue() + 1][2];
        LottoTickets lottoTickets = user.getLottoTickets();

        for (Lotto lotto : lottoTickets.getTickets()) {
            int matchCount = lotto.countMatchNumberWithWinningNumber(lottoResult.getWinningNumbers());
            if (matchCount == 5 && lotto.isBonusNumberIncludeInWinningNumbers(lottoResult.getBonusNumber())) {
                resultTable[matchCount][1]++;
                user.addRevenue(LottoWinningPriceList.getIncludeBonus);
                continue;
            }
            resultTable[matchCount][0]++;
            user.addRevenue(LottoWinningPriceList.get[matchCount]);
        }
        return resultTable;
    }

}
