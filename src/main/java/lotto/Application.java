package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.dto.LottoBuyResponse;
import lotto.dto.LottoRequest;
import lotto.exception.LottoInputException;
import lotto.service.LottoService;
import lotto.utility.StringUtility;
import lotto.validator.LottoBuyMoneyValidator;
import lotto.validator.LottoWinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    private final static String LOTTO_SPLITTER = ",";

    private static int buyMoney = -1;
    private static List<Integer> winningNumbers = null;
    private static int bonusNumber = -1;
    private static Lottos lottos = null;
    private static LottoController lottoController = new LottoController(new LottoService());


    public static void main(String[] args) {
        LottoRequest lottoRequest = null;
        while (lottoRequest == null) {
            if((buyMoney = inputBuyMoney()) == -1) {
                continue;
            }
            if(lottos == null){
                buyLotto();
            }
            if((lottoRequest = inputLottoRequestDto())== null){
                continue;
            }
            OutputView.print(lottoController.calLottos(lottoRequest,lottos));
        }
    }

    private static void buyLotto() {
        LottoBuyResponse lottoBuyResponse = lottoController.buyLottos(new LottoRequest(buyMoney, winningNumbers, bonusNumber));
        lottos = lottoBuyResponse.lottos();
        OutputView.print(lottoBuyResponse.buyLottoHistory());
    }

    private static LottoRequest inputLottoRequestDto() {
        try {
            winningNumbers = inputWinningNumbers();
            bonusNumber = inputBonusNumber();
            return new LottoRequest(buyMoney,winningNumbers,bonusNumber);
        }catch(LottoInputException e){
            OutputView.printError(e);
            return null;
        }
    }

    private static int inputBuyMoney() {
        try{
            if(buyMoney != -1) return buyMoney;
            String input = InputView.inputBuyMoney();
            LottoBuyMoneyValidator.validateLottoBuyMoney(input);
            return Integer.parseInt(input);
        }catch (LottoInputException e){
            OutputView.printError(e);
            return -1;
        }
    }

    private static List<Integer> inputWinningNumbers() {
        if(winningNumbers != null) return winningNumbers;
        String input = InputView.inputWinningNumber();
        LottoWinningNumberValidator.validateLottoWinningNumber(input);
        return StringUtility.splitBySplitter(input,LOTTO_SPLITTER).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int inputBonusNumber() {
        if(bonusNumber != -1) return bonusNumber;
        String input = InputView.inputBonusNumber();
        LottoWinningNumberValidator.validateLottoBonusNumber(input);
        return Integer.parseInt(input);
    }
}
