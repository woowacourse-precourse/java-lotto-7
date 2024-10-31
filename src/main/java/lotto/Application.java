package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.LottoController;
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

    private final static String LOTTO_SPLITTER = ",";

    private final static LottoController lottoController = new LottoController(new LottoService());


    public static void main(String[] args) {
        int buyMoney = inputBuyMoney();
        Lottos lottos = buyLotto(buyMoney);
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        LottoCalculateRequest lottoCalculateRequest = new LottoCalculateRequest(buyMoney,winningNumbers,bonusNumber);
        OutputView.print(lottoController.calLottos(lottoCalculateRequest,lottos));
    }

    private static Lottos buyLotto(int buyMoney) {
        LottoBuyResponse lottoBuyResponse = lottoController.buyLottos(new LottoBuyRequest(buyMoney));
        Lottos lottos = lottoBuyResponse.lottos();
        OutputView.print(lottoBuyResponse.buyLottoHistory());
        return lottos;
    }
    private static int inputBuyMoney() {
        int buyMoney = -1;
        while (buyMoney == -1){
            try{
                String input = InputView.inputBuyMoney();
                LottoBuyMoneyValidator.validateLottoBuyMoney(input);
                buyMoney = Integer.parseInt(input);
            }catch (LottoInputException e){
                OutputView.printError(e);
            }
        }
        return buyMoney;
    }

    private static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = null;
        while (winningNumbers == null){
            try{
                String input = InputView.inputWinningNumber();
                LottoWinningNumberValidator.validateLottoWinningNumber(input);
                winningNumbers = StringUtility.splitBySplitter(input,LOTTO_SPLITTER).stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            }catch (LottoInputException e){
                OutputView.printError(e);
            }
        }
        return winningNumbers;
    }

    private static int inputBonusNumber() {
        int bonusNumber = -1;
        while (bonusNumber == -1){
            try{
                String input = InputView.inputBonusNumber();
                LottoWinningNumberValidator.validateLottoBonusNumber(input);
                bonusNumber = Integer.parseInt(input);
            }catch (LottoInputException e){
                OutputView.printError(e);
            }
        }
        return bonusNumber;
    }
}
