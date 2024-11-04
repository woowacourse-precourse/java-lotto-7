package lotto.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.ExceptionHandler;
import lotto.message.error.ErrorMessage;
import lotto.message.info.InfoMessage;
import lotto.model.domain.Lotto;
import lotto.model.service.LottoService;

import java.util.List;

public class InputView implements Input {

    private final ExceptionHandler exceptionHandler;
    private final LottoService lottoService;
    public InputView(ExceptionHandler exceptionHandler, LottoService lottoService) {
        this.exceptionHandler = exceptionHandler;
        this.lottoService = lottoService;
    }

    @Override
    public int requestPurchaseAmount() {
        int purchaseAmount = -1;
        while (true) {
            try {
                System.out.println(InfoMessage.REQUEST_PURCHASE_AMOUNT.getMessage());
                purchaseAmount = Integer.parseInt(Console.readLine());
                exceptionHandler.validatePurchaseAmount(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
            }
        }
        return purchaseAmount;
    }

    @Override
    public List<Integer> requestLottoNumbers() {
        List<Integer> lottoNumbers = null;
        while(true) {
            try {
                System.out.println("\n" + InfoMessage.REQUEST_WINNING_NUMBERS.getMessage());
                String str = Console.readLine();
                lottoNumbers = lottoService.extractWinningNumbersFromString(str);
                exceptionHandler.validateWinningNumbers(lottoNumbers);
                Lotto lotto = new Lotto(lottoNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoNumbers;
    }

    @Override
    public int requestBonusNumber() {
        int bonusNumber = 0;
        while(true) {
            try {
                System.out.println("\n" + InfoMessage.REQUEST_BONUS_NUMBER.getMessage());
                bonusNumber = Integer.parseInt(Console.readLine());
                exceptionHandler.validateBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_WINNING_NUMBERS.getMessage());
            }
        }
        return bonusNumber;
    }
}
