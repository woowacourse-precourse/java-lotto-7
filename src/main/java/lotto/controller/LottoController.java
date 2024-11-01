package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoService = new LottoService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public int pay() {
        while (true) {
            try {
                String input = inputView.readPayment();
                return lottoService.parsePayment(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> buyLottos(int payment) {
        List<Lotto> lottos = lottoService.issueLottos(payment);
        outputView.printLotto(lottos);
        return lottos;
    }

    public List<Integer> postWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                return lottoService.parseWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int postBonus() {
        while (true) {
            try {
                String input = inputView.readBonus();
                return lottoService.parseBonus(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
