package lotto.service;

import static lotto.constant.LotteryConstant.DEFAULT_LOTTO_PRICE;

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
        int lottoPurchaseAmount = purchaseAmount / DEFAULT_LOTTO_PRICE;
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

    // 로또 당첨 통계를 조회한다.
    public void getLottoWinningStatistics() {
        outputView.printWinningStatistics();
        final List<Lotto> lottos = lottoBuyer.getLottos();
        final List<Integer> winningNumbers = winningLottery.getNumbers();
        final int bonusNumber = lottoBonus.getBonusNumber();
        lottos.forEach(lotto -> processLottoResult(lotto, winningNumbers, bonusNumber));
        lottoResult.printLottoWinningStatistics();
        printLotteryResult(lottoBuyer);
    }

    // 사용자가 발행한 로또에 대해 당첨 내역 처리를 진행한다.
    private void processLottoResult(final Lotto lotto, final List<Integer> winningNumbers, final int bonusNumber) {
        int matchingCount = getMatchingCount(lotto.getNumbers(), winningNumbers);
        boolean isBonus = lotto.getNumbers().contains(bonusNumber);
        lottoResult.updateLottoResult(matchingCount, isBonus);
        lottoBuyer.addMoney(matchingCount, isBonus);
    }

    // 사용자가 발행한 로또와 당첨 숫자 간의 일치 개수를 판단한다.
    private int getMatchingCount(final List<Integer> ticketNumbers, final List<Integer> winningNumbers) {
        return (int) ticketNumbers.stream().filter(winningNumbers::contains).count();
    }

    // 로또 결과를 출력한다.
    private void printLotteryResult(final LottoBuyer lottoBuyer) {
        final int totalWinningAmount = lottoBuyer.getLottoWinningAmount();
        final int purchaseAmount = lottoBuyer.getLottoPurchaseAmount() * DEFAULT_LOTTO_PRICE;
        getLotteryYield(purchaseAmount, totalWinningAmount);
    }

    // 로또 수익률을 계산한다.
    public void getLotteryYield(final int purchaseAmount, final int totalWinningAmount) {
        final double lotteryYield = lottoBuyer.calculateLotteryYield(purchaseAmount, totalWinningAmount);
        System.out.println("총 수익률은 " + lotteryYield + "%입니다.");
    }

    // 해당 로또 구매자는 로또 개수만큼 로또 티켓을 발행한다.
    private void issueLottoTickets(final LottoBuyer lottoBuyer, final int lottoIssueNumber) {
        for (int i = 0; i < lottoIssueNumber; i++) {
            List<Integer> ticketNumbers = getTicketNumbers();
            Lotto lotto = new Lotto(ticketNumbers);
            lottoBuyer.addLotto(lotto);
            System.out.println(ticketNumbers);
        }
        System.out.println();
    }

    // 1부터 45 사이의 숫자에서 티켓 숫자를 출력한다.
    private List<Integer> getTicketNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
