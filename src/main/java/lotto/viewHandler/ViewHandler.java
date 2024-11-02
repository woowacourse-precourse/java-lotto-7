package lotto.viewHandler;

import lotto.view.Input;
import lotto.view.Output;
import lotto.viewHandler.api.Api;
import lotto.dto.output.PurchaseLottosDto;
import lotto.dto.output.ResultAmountDto;
import lotto.dto.output.ResultLottosDto;
import lotto.viewHandler.api.dto.input.BonusNumberDto;
import lotto.viewHandler.api.dto.input.MoneyDto;
import lotto.viewHandler.api.dto.input.WinningLottoNumbersDto;
import lotto.viewHandler.exception.MyException;

public class ViewHandler {
    private final ApiHandler apiHandler;
    private final Input input;
    private final Output output;

    public ViewHandler(ApiHandler apiHandler, Input input, Output output) {
        this.apiHandler = apiHandler;
        this.input = input;
        this.output = output;
    }

    public Api<MoneyDto> purchaseMoney() {
        while (true) {
            try {
                String money = input.getPurchaseMoney();
                return apiHandler.transformMoneyDto(money);
            } catch (MyException e) {
                output.viewExceptionMessage(e.getMessage());
            }
        }
    }

    public Api<WinningLottoNumbersDto> getWinningNumbers() {
        while (true) {
            try {
                String lottoNumbers = input.getWinningLottoNumbers();
                return apiHandler.transformLottoNumbers(lottoNumbers);
            } catch (MyException e) {
                output.viewExceptionMessage(e.getMessage());
            }
        }
    }

    public Api<BonusNumberDto> getBonusNumber() {
        while (true) {
            try {
                String bonusNumber = input.getBonusNumber();
                return apiHandler.transformLottoBonusNumber(bonusNumber);
            } catch (MyException e) {
                output.viewExceptionMessage(e.getMessage());
            }
        }
    }

    public void outputHandler(Api api) {
        exceptionHandler(api);
        purchaseHandler(api);
        resulLottoHandler(api);
        resultAmountHandler(api);
    }

    private void exceptionHandler(Api api) {
        if(api.getCode() != 200) {
            output.viewExceptionMessage(api.getMessage());
        }
    }

    private void purchaseHandler(Api api) {
        if(api.getData() instanceof PurchaseLottosDto) {
            output.viewPurchaseLottos(api);
        }
    }

    private void resulLottoHandler(Api api) {
        if(api.getData() instanceof ResultLottosDto) {
            output.viewResultLottos(api);
        }
    }

    private void resultAmountHandler(Api api) {
        if(api.getData() instanceof ResultAmountDto) {
            output.viewResultAmount(api);
        }
    }
}
