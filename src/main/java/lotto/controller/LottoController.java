package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.service.LottoGroupService;
import lotto.utils.LottoNumberGenerator;
import lotto.utils.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoNumberGenerator lottoNumberGenerator = new RandomLottoGenerator();
    private final LottoGroupService lottoGroupService = new LottoGroupService();

    public void start() {
        outputView.printBuyingRequest();
        int purchaseAmount = inputView.inputBuyingPrice();
        outputView.responseQuantity(purchaseAmount);

        int lottoCount = purchaseAmount / 1000;
        List<Lotto> userLottos = createLottos(lottoCount);
        LottoGroup lottoGroup = new LottoGroup(userLottos);

        outputView.responseUserLottoNumber(lottoGroup);

        outputView.askLottoNumbers();
        List<Integer> winningNumbers = parseLottoNumbers(inputView.inputLottoNumbersView());
        outputView.askBonusNumber();
        int bonusNumber = Integer.parseInt(inputView.inputBonusNumberView());

        Lotto winningLotto = new Lotto(winningNumbers);
        lottoGroupService.calculateResults(lottoGroup, winningLotto, bonusNumber);

        outputView.responseWinningHistory(lottoGroup.getMatchCounts());
        double yield = lottoGroup.calculateYield(purchaseAmount);
        outputView.responseYieldOfLotto(String.format("%.1f", yield));
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = lottoNumberGenerator.generateNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private List<Integer> parseLottoNumbers(String input) {
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            numbers.add(Integer.parseInt(part.trim()));
        }
        return numbers;
    }
}