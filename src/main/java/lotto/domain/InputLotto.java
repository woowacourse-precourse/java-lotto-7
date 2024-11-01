package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoBuyRequest;
import lotto.dto.LottoBuyResponse;
import lotto.exception.LottoInputException;
import lotto.utility.StringUtility;
import lotto.validator.LottoBuyMoneyValidator;
import lotto.validator.LottoWinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputLotto {

    private final static String LOTTO_SPLITTER = ",";

    public static int inputBuyMoney() {
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

    public static List<Integer> inputWinningNumbers() {
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

    public static int inputBonusNumber() {
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
