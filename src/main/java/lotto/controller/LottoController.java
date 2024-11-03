package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.LottoDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LottoDto run() {
        int payment = pay();
        List<Lotto> lottos = buyLottos(payment);
        List<Integer> winningNumbers = postWinningNumbers();
        int bonus = postBonus();

        return new LottoDto(payment, lottos, winningNumbers, bonus);
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
