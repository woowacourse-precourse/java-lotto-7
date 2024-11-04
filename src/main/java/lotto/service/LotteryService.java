package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBonus;
import lotto.domain.LottoBuyer;
import lotto.validation.LotteryValidator;
import lotto.view.OutputView;

public class LotteryService {
    private final OutputView outputView;
    private final LotteryValidator lotteryValidator;
    private final LottoBuyer lottoBuyer;

    public LotteryService() {
        this.outputView = new OutputView();
        this.lotteryValidator = new LotteryValidator();
        this.lottoBuyer = new LottoBuyer();
    }

    public void purchaseLotto() {
        outputView.printRequirePurchaseAmount();

        final String inputPurchaseAmount = Console.readLine();
        final int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        lotteryValidator.validatePurchaseAmount(purchaseAmount);

        int lottoPurchaseAmount = purchaseAmount / 1000;
        lottoBuyer.setLottoPurchaseAmount(lottoPurchaseAmount);
        issueLottoTickets(lottoBuyer, lottoPurchaseAmount);
    }

    public void setWinningLotto() {
        String inputLottoWinningNumbers = Console.readLine();

        List<Integer> lottoWinningNumbers = null;

        for (final String winningNumber : inputLottoWinningNumbers.split(",")) {
            lottoWinningNumbers.add(Integer.parseInt(winningNumber));
        }

        Lotto winningLottery = new Lotto(lottoWinningNumbers);
    }

    public void getLottoBonusNumber() {
        int lottoBonusNumber = Integer.parseInt(Console.readLine());
        LottoBonus lottoBonus = new LottoBonus(lottoBonusNumber);
    }

    public void getLottoWinningStatistics() {
        outputView.printWinningStatistics();
    }

    public void getLotteryYield(final LottoBuyer lottoBuyer, final int purchaseAmount, final int totalWinningAmount) {
        final int lotteryYield = lottoBuyer.calculateLotteryYield(purchaseAmount, totalWinningAmount);
        System.out.println("총 수익률은 " + lotteryYield + "%입니다.");
    }

    private void issueLottoTickets(final LottoBuyer lottoBuyer, final int lottoIssueNumber) {
        for (int i = 0; i < lottoIssueNumber; i++) {
            List<Integer> ticketNumbers = getTicketNumbers();
            Lotto lotto = new Lotto(ticketNumbers);
            lottoBuyer.addLotto(lotto);
            System.out.println(ticketNumbers);
        }
    }

    private List<Integer> getTicketNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
