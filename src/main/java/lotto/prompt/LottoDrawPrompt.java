package lotto.prompt;

import camp.nextstep.edu.missionutils.Console;
import java.text.NumberFormat;
import lotto.domain.BonusNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoWinningRule;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.WinningNumber;

public class LottoDrawPrompt {

    public static final String WINNING_NUMBER_SPLIT_REGEX = ",";
    private static final String WINNING_NUMBER_INPUT_MSG = "당첨 번호를 입력해 주세요.\n";
    private static final String BONUS_NUMBER_INPUT_MSG = "보너스 번호를 입력해 주세요.\n";

    private static final String DRAW_RESULT_OUTPUT_MSG = "당첨 통계\n---\n";
    private static final String DRAW_WINNING_OUTPUT_MSG = "%d개 일치 (%s원) - %d개\n";
    private static final String DRAW_WINNING_BONUS_OUTPUT_MSG = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String RATE_OF_RETURN_OUTPUT_MSG = "총 수익률은 %s입니다.\n";


    /*
     * User Input
     * */
    public WinningNumber enterWinningNumber() {
        while (true) {
            try {
                System.out.print(WINNING_NUMBER_INPUT_MSG);
                WinningNumber winningNumber = WinningNumber.parse(Console.readLine());
                System.out.println();
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNumber enterBonusNumber(WinningNumber winningNumber) {
        while (true) {
            try {
                System.out.print(BONUS_NUMBER_INPUT_MSG);
                BonusNumber bonusNumber = BonusNumber.parse(Console.readLine(), winningNumber);
                System.out.println();
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /*
     * User Output
     * */
    public void printDrawResult(LottoWinningStatistics statistics) {
        System.out.print(DRAW_RESULT_OUTPUT_MSG);
        for (LottoRank rank : LottoRank.reverseValues()) {
            if (rank != LottoRank.NONE) {
                System.out.print(getDrawWinningResult(statistics, rank));
            }
        }
    }

    public void printReturnRate(double returnRate) {
        System.out.printf(RATE_OF_RETURN_OUTPUT_MSG, formatDecimal(returnRate));
    }

    private String getDrawWinningResult(LottoWinningStatistics statistics, LottoRank rank) {
        String msg = DRAW_WINNING_OUTPUT_MSG;
        long prize = LottoWinningRule.getPrize(rank);
        int winningNumber = statistics.search(rank);

        if (rank == LottoRank.SECOND) {
            msg = DRAW_WINNING_BONUS_OUTPUT_MSG;
        }
        return String.format(msg, rank.matches, formatInteger(prize), winningNumber);
    }

    private String formatInteger(long value) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        return formatter.format(value);
    }

    private String formatDecimal(double value) {
        NumberFormat formatter = NumberFormat.getPercentInstance();
        formatter.setMinimumFractionDigits(1);
        formatter.setMaximumFractionDigits(1);
        return formatter.format(value);
    }
}
