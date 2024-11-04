package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;
import java.util.List;

import static lotto.validate.LottoConstants.LOTTO_PRICE;

public class Controller {
    private final Input input;
    private final Output output;
    private final LottoService lottoService;

    public Controller(Input input, Output output, LottoService lottoService) {
        this.input = input;
        this.output = output;
        this.lottoService = lottoService;
    }

    public void run() {
        int amount = input.inputPurchaseAmount();
        List<Lotto> lottos = purchaseLottos(amount);
        output.printLottoNumbers(lottos);

        WinningLotto winningNumbers = getWinningLotto();
        displayStatistics(lottos, winningNumbers, amount);
    }

    private List<Lotto> purchaseLottos(int amount) {
        int numberOfTickets = calculateNumberOfTickets(amount);
        return lottoService.createLotto(numberOfTickets);
    }

    private int calculateNumberOfTickets(int amount) {
        return amount / LOTTO_PRICE.getValue();
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = input.inputWinningNumbers();
        int bonusNumber = input.inputBonusNumber(winningLotto);
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private void displayStatistics(List<Lotto> lottos, WinningLotto winningNumbers, int amount) {
        List<Prize> prizes = lottoService.calculatePrizes(lottos, winningNumbers);
        output.printStatistics(prizes, amount);
    }
}
