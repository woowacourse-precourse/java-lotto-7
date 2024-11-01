package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.validation.LotteryValidator;
import lotto.view.OutputView;

public class LotteryService {
    private final OutputView outputView;
    private final LotteryValidator lotteryValidator;

    public LotteryService() {
        this.outputView = new OutputView();
        this.lotteryValidator = new LotteryValidator();
    }

    public void getPurchaseAmount() {
        outputView.printRequirePurchaseAmount();

        final String inputPurchaseAmount = Console.readLine();
        final int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        lotteryValidator.validatePurchaseAmount(purchaseAmount);
        // 구매 개수 ->
        int lottoPurchaseAmount = purchaseAmount / 1000;
        outputView.printPurchaseAmount(lottoPurchaseAmount);

        issueLottoTickets(lottoPurchaseAmount);
    }

    private void issueLottoTickets(final int lottoIssueNumber) {
        for (int i = 0; i < lottoIssueNumber; i++) {
            System.out.println(getTicketNumbers());
        }
    }

    private List<Integer> getTicketNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
