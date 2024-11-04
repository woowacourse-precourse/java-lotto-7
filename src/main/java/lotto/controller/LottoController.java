package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoGroup;
import lotto.service.LottoGroupService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final String YIELD_FORMAT = "%.1f";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoFactory lottoFactory = new LottoFactory();
    private final LottoGroupService lottoGroupService = new LottoGroupService();

    public void start() {
        int purchaseAmount = requestPurchaseAmount();
        int lottoCount = calculateLottoCount(purchaseAmount);

        LottoGroup lottoGroup = purchaseLottos(lottoCount);
        outputView.responseUserLottoNumber(lottoGroup);

        Lotto winningLotto = inputWinningLotto();
        int bonusNumber = inputBonusNumber();

        printResult(lottoGroup, winningLotto, bonusNumber, purchaseAmount);
    }

    private void printResult(LottoGroup lottoGroup, Lotto winningLotto, int bonusNumber, int purchaseAmount) {
        lottoGroupService.calculateResults(lottoGroup, winningLotto, bonusNumber);
        outputView.responseWinningHistory(lottoGroup.getMatchCounts());
        double yield = lottoGroup.calculateYield(purchaseAmount);
        outputView.responseYieldOfLotto(String.format(YIELD_FORMAT, yield));
    }

    private int inputBonusNumber() {
        outputView.askBonusNumber();
        int bonusNumber = Integer.parseInt(inputView.inputBonusNumberView());
        return bonusNumber;
    }

    private Lotto inputWinningLotto() {
        outputView.askLottoNumbers();
        List<Integer> winningNumbers = inputView.inputLottoNumbersView();
        Lotto winningLotto = new Lotto(winningNumbers);
        return winningLotto;
    }

    private LottoGroup purchaseLottos(int lottoCount) {
        List<Lotto> userLottos = lottoFactory.createLottos(lottoCount);
        LottoGroup lottoGroup = new LottoGroup(userLottos);
        return lottoGroup;
    }

    private static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    private int requestPurchaseAmount() {
        outputView.printBuyingRequest();
        int purchaseAmount = inputView.inputBuyingPrice();
        outputView.responseQuantity(purchaseAmount);
        return purchaseAmount;
    }
}