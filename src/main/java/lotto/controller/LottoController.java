package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.Constants;
import lotto.service.LottoService;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService service = new LottoService();
    InputView inputView;
    OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int money = getMoney();
        int lottoAmount = buyLotto(money);
        List<Lotto> lottos = makeLottos(lottoAmount);
        printLottos(lottos);
        List<Integer> winningNumbers = getWinningNumbers();
    }

    private int buyLotto(int money) {
        int lottoAmount = money / Constants.MONEY_UNIT.getValue();
        outputView.printLottoAmount(lottoAmount);
        return lottoAmount;
    }

    private int getMoney() {
        try {
            String inputMoney = inputView.promptMoney();
            LottoValidator.validateInputMoney(inputMoney);
            return Integer.parseInt(inputMoney);
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error.getMessage());
        }
        return getMoney();
    }

    private List<Lotto> makeLottos(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottoAmount-- > 0) {
            List<Integer> numbers = service.getLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        outputView.printLottos(lottos);
    }

    private List<Integer> getWinningNumbers() {
        try {
            String inputWinningNumbers = inputView.promptNumbers();
            LottoValidator.validateWinningNumbers(inputWinningNumbers);
            return service.getWinningNumbers();
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error.getMessage());
        }
        return getWinningNumbers();
    }
}
