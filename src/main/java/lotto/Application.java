package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.LottoController;
import lotto.domain.InputLotto;
import lotto.domain.Lottos;
import lotto.dto.LottoBuyRequest;
import lotto.dto.LottoBuyResponse;
import lotto.dto.LottoCalculateRequest;
import lotto.exception.LottoInputException;
import lotto.service.LottoService;
import lotto.utility.StringUtility;
import lotto.validator.LottoBuyMoneyValidator;
import lotto.validator.LottoWinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    private final static LottoController lottoController = new LottoController(new LottoService());

    public static void main(String[] args) {
        int buyMoney = InputLotto.inputBuyMoney();
        Lottos lottos = buyLotto(buyMoney);
        List<Integer> winningNumbers = InputLotto.inputWinningNumbers();
        int bonusNumber = InputLotto.inputBonusNumber();
        LottoCalculateRequest lottoCalculateRequest = new LottoCalculateRequest(buyMoney,winningNumbers,bonusNumber);
        OutputView.print(lottoController.calLottos(lottoCalculateRequest,lottos));
    }

    public static Lottos buyLotto(int buyMoney) {
        LottoBuyResponse lottoBuyResponse = lottoController.buyLottos(new LottoBuyRequest(buyMoney));
        Lottos lottos = lottoBuyResponse.lottos();
        OutputView.print(lottoBuyResponse.buyLottoHistory());
        return lottos;
    }
}
