package lotto.prompt;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;

public class LottoDrawPrompt {

    private static final String WINNING_NUMBER_INPUT_MSG = "당첨 번호를 입력해 주세요.\n";
    private static final String BONUS_NUMBER_INPUT_MSG = "보너스 번호를 입력해 주세요.\n";
    private static final String DRAW_OUTPUT_MSG = "당첨 통계\n---\n";

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

    public void printDrawResult() {
        System.out.println(DRAW_OUTPUT_MSG);
    }

    public void printReturnRate(double returnRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }
}
