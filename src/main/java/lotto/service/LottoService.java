package lotto.service;

import lotto.enums.OutputMessage;
import lotto.enums.WinningStatistics;
import lotto.model.Lotto;
import lotto.model.Money;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {

    public Lotto[] LottoIssuer(Money money) {
        int lottoCount = money.getPurchaseAmount() / 1000;
        System.out.println("\n" + lottoCount + OutputMessage.NOTICE_PURCHASE_COUNT.getMessage());
        Lotto[] issuedLottos = new Lotto[lottoCount];

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            issuedLottos[i] = new Lotto(numbers);
        }

        return issuedLottos;
    }

    public void showLottoNumbers(Lotto[] issuedLottos) {
        for (Lotto lotto : issuedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void countMatchingNumbers(Lotto[] issuedLottos, Lotto winningLotto) {
        for (Lotto lotto : issuedLottos) {
            List<Integer> matchingNumbers = new ArrayList<>(lotto.getNumbers());
            matchingNumbers.retainAll(winningLotto.getNumbers());
            int matchCount = matchingNumbers.size();

            if (matchCount == 5) {
                checkBonusNumber(lotto, winningLotto);
                return;
            }
            updateWinningStatistics(matchCount);
        }
    }

    private void checkBonusNumber(Lotto lotto, Lotto winningLotto) {
        if (lotto.getNumbers().contains(winningLotto.getNumbers().get(6))) {
            WinningStatistics.SECOND.setCount(WinningStatistics.SECOND.getCount() + 1);
            return;
        }

        WinningStatistics.THIRD.setCount(WinningStatistics.THIRD.getCount() + 1);
    }

    private void updateWinningStatistics(int matchCount) {
        for (WinningStatistics stat : WinningStatistics.values()) {
            if (stat.getMatchCount() == matchCount) {
                stat.setCount(stat.getCount() + 1);
            }
        }
    }

    public void showWinningStatistics() {
        System.out.println(OutputMessage.WINNING_STATISTICS_MESSAGE.getMessage());
        for (int i = WinningStatistics.values().length - 1; i >= 0; i--) {
            WinningStatistics stat = WinningStatistics.values()[i];
            String formattedPrize = NumberFormat.getNumberInstance(Locale.KOREA).format(stat.getPrize());
            System.out.println(stat.getMatchCount() + "개 일치 (" + formattedPrize + "원) - " + stat.getCount() + "개");
        }
    }

    public double calculateProfitRate(Money money) {
        int totalPrize = 0;
        for (WinningStatistics stat : WinningStatistics.values()) {
            totalPrize += stat.getPrize() * stat.getCount();
        }
        return (double) totalPrize / money.getPurchaseAmount() * 100;
    }

    public void showProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
