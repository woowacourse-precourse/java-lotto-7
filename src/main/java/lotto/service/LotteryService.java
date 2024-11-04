package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBonus;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LotteryService {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoBuyer lottoBuyer;
    private final Lotto winningLottery;
    private final LottoBonus lottoBonus;
    private final LottoResult lottoResult;

    public LotteryService() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.lottoBuyer = new LottoBuyer();
        this.winningLottery = new Lotto();
        this.lottoBonus = new LottoBonus();
        this.lottoResult = new LottoResult();
    }

    public void purchaseLotto() {
        outputView.printRequirePurchaseAmount();
        final int purchaseAmount = inputView.readPurchaseAmount();
        int lottoPurchaseAmount = purchaseAmount / 1000;
        lottoBuyer.setLottoPurchaseAmount(lottoPurchaseAmount);
        outputView.printLottoPurchaseAmount(lottoPurchaseAmount);
        issueLottoTickets(lottoBuyer, lottoPurchaseAmount);
    }

    public void setWinningLotto() {
        outputView.printRequireWinningNumber();
        List<Integer> lottoWinningNumbers = inputView.readLottoNumbers();
        winningLottery.addWinningNumbers(lottoWinningNumbers);
    }

    public void setLottoBonusNumber() {
        outputView.printRequireBonusNumber();
        int lottoBonusNumber = inputView.readLottoBonusNumber();
        lottoBonus.setLottoBonusNumber(lottoBonusNumber);
        System.out.println();
    }

    public void getLottoWinningStatistics() {
        outputView.printWinningStatistics();

        // 개수 일치 여부 판단 필요
        final List<Lotto> lottos = lottoBuyer.getLottos();
        final List<Integer> winningNumbers = winningLottery.getNumbers();
        final int bonusNumber = lottoBonus.getBonusNumber();
        boolean isBonus = false;

        for (Lotto lotto : lottos) {
            List<Integer> ticketNumbers = lotto.getNumbers();
            int matchingCount = 0;
            for (Integer number : ticketNumbers) {
                if (winningNumbers.contains(number)) {
                    matchingCount++;
                }
            }

            if (ticketNumbers.contains(bonusNumber)) {
                isBonus = true;
            }
            lottoResult.updateLottoResult(matchingCount, isBonus);
            lottoBuyer.addMoney(matchingCount, isBonus);
        }

        lottoResult.printLottoWinningStatistics();

        final int totalWinningAmount = lottoBuyer.getLottoWinningAmount();
        System.out.println("totalWinningAmount = " + totalWinningAmount);
        final int purchaseAmount = lottoBuyer.getLottoPurchaseAmount() * 1000;
        System.out.println("purchaseAmount = " + purchaseAmount);
        getLotteryYield(purchaseAmount, totalWinningAmount);
    }

    public void getLotteryYield(final int purchaseAmount, final int totalWinningAmount) {
        final double lotteryYield = lottoBuyer.calculateLotteryYield(purchaseAmount, totalWinningAmount);
        System.out.println("총 수익률은 " + lotteryYield + "%입니다.");
    }

    private void issueLottoTickets(final LottoBuyer lottoBuyer, final int lottoIssueNumber) {
        for (int i = 0; i < lottoIssueNumber; i++) {
            List<Integer> ticketNumbers = getTicketNumbers();
            Lotto lotto = new Lotto(ticketNumbers);
            lottoBuyer.addLotto(lotto);
            System.out.println(ticketNumbers);
        }
        System.out.println();
    }

    private List<Integer> getTicketNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
