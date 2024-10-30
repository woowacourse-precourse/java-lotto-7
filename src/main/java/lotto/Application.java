package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.LottoController;
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


    public static void main(String[] args) {
        LottoRequest lottoRequest = null;
        while (lottoRequest == null) {
            lottoRequest = inputLottoRequestDto();
        }
        LottoController lottoController = new LottoController(new LottoService());
        lottoController.buyLottos(lottoRequest);
    }

    private static LottoRequest inputLottoRequestDto() {
        try {
            buyMoney = inputBuyMoney();
            winningNumbers = inputWinningNumbers();
            bonusNumber = inputBonusNumber();
        }catch(LottoInputException e){
            OutputView.printError(e);
            return null;
        }
        return new LottoRequest(buyMoney,winningNumbers,bonusNumber);
    }

    private static int inputBuyMoney() {
        if(buyMoney != -1) return buyMoney;
        String input = InputView.inputBuyMoney();
        LottoBuyMoneyValidator.validateLottoBuyMoney(input);
        return Integer.parseInt(input);
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
