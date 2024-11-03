package lotto;

import java.util.List;
import lotto.domain.LotteryProcess;
import lotto.domain.Lotto;
import lotto.input.UserAmountInput;
import lotto.input.UserBonusNumberInput;
import lotto.input.UserLottoNumberInput;
import lotto.service.PrintResult;
import lotto.service.PrintTicketCount;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자 금액 입력 및 검증
        UserAmountInput userAmountInput = new UserAmountInput();
        int amount = userAmountInput.validation();

        // 2. 로또 티켓 생성 및 출력
        PrintTicketCount printTicketCount = new PrintTicketCount(userAmountInput.getLottoTicketCount());
        List<List<Integer>> lottoTickets = printTicketCount.getLottoTickets();
        printTicketCount.printCountAndTickets(lottoTickets);

        // 3. 당첨 번호 입력 및 검증
        UserLottoNumberInput userLottoNumberInput = new UserLottoNumberInput();
        Lotto lotto = userLottoNumberInput.validation();
        List<Integer> lottoNumbers = lotto.getNumbers();

        // 4. 보너스 번호 입력 및 중복 검증
        UserBonusNumberInput userBonusNumberInput = new UserBonusNumberInput();
        int bonusNumber = userBonusNumberInput.validation(lottoNumbers);

        // 5. 로또 추첨 및 결과 출력
        LotteryProcess lotteryProcess = new LotteryProcess(lottoNumbers, bonusNumber, lottoTickets);
        List<Integer> rankingCount = lotteryProcess.countMatchNumbers(); // 로또 추첨

        PrintResult printResult = new PrintResult(rankingCount);
        printResult.printPrizeAndEarnings(amount); // 당첨 통계 및 수익률 출력
    }
}
