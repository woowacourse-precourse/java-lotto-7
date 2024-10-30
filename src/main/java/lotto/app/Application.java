package lotto.app;

import lotto.domain.LotteryProcess;
import lotto.domain.Lotto;
import lotto.input.UserAmountInput;
import lotto.input.UserBonusNumberInput;
import lotto.input.UserLottoNumberInput;
import lotto.service.PrintResult;
import lotto.service.PrintTicketCount;

public class Application {
    public static void main(String[] args) {

        UserAmountInput userAmountInput = new UserAmountInput();
        userAmountInput.userAmountInput();

        System.out.println();

        PrintTicketCount printTicketCount = userAmountInput.createPrintTicket();
        printTicketCount.printCount();
        printTicketCount.repeatPrintNumber();

        System.out.println();

        UserLottoNumberInput lottoInput = new UserLottoNumberInput();
        lottoInput.userLottoNumberInput();

        Lotto lotto = lottoInput.saveLottoNumber();

        UserBonusNumberInput userBonusNumberInput = new UserBonusNumberInput();
        userBonusNumberInput.bonusDuplicationCheck(lotto); // 보너스 번호 중복 체크

        System.out.println();

        LotteryProcess lotteryProcess = new LotteryProcess(lotto, userBonusNumberInput, printTicketCount);
        lotteryProcess.countMatchNumbers(); // 로또 추첨

        PrintResult printResult = new PrintResult(lotteryProcess);
        printResult.printPrize(); // 당첨 통계 출력

        userAmountInput.printEarningsRate(printResult.calculateEarnings()); // 수익률 출력
    }
}
