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
        outputView.printBuyingRequest();
        int purchaseAmount = inputView.inputBuyingPrice();
        outputView.responseQuantity(purchaseAmount);

        int lottoCount = purchaseAmount / LOTTO_TICKET_PRICE;
        List<Lotto> userLottos = lottoFactory.createLottos(lottoCount);
        LottoGroup lottoGroup = new LottoGroup(userLottos);

        outputView.responseUserLottoNumber(lottoGroup);

        outputView.askLottoNumbers();
        List<Integer> winningNumbers = inputView.inputLottoNumbersView();
        outputView.askBonusNumber();
        int bonusNumber = Integer.parseInt(inputView.inputBonusNumberView());

        Lotto winningLotto = new Lotto(winningNumbers);
        lottoGroupService.calculateResults(lottoGroup, winningLotto, bonusNumber);

        outputView.responseWinningHistory(lottoGroup.getMatchCounts());
        double yield = lottoGroup.calculateYield(purchaseAmount);
        outputView.responseYieldOfLotto(String.format(YIELD_FORMAT, yield));
    }
}