package lotto.viewHandler;

import lotto.util.CallBackTemplate;
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

import java.util.Objects;

import static lotto.viewHandler.exception.MyExceptionConstant.SERVER_SUCCESS_CODE;

public class ViewHandler {
    private final CallBackTemplate retry;
    private final ApiHandler apiHandler;
    private final Input input;
    private final Output output;

    public ViewHandler(CallBackTemplate retry, ApiHandler apiHandler, Input input, Output output) {
        this.retry = retry;
        this.apiHandler = apiHandler;
        this.input = input;
        this.output = output;
    }

    public Api<MoneyDto> purchaseMoney() {
        return retry.retry(() -> {
                    String money = input.getPurchaseMoney();
                    return apiHandler.transformMoneyDto(money);
                },
                e -> output.viewExceptionMessage(e.getMessage())
        );
    }

    public Api<WinningLottoNumbersDto> getWinningNumbers() {
        return retry.retry(() -> {
                    String lottoNumbers = input.getWinningLottoNumbers();
                    return apiHandler.transformLottoNumbers(lottoNumbers);
                },
                e -> output.viewExceptionMessage(e.getMessage())
        );
    }

    public Api<BonusNumberDto> getBonusNumber() {
        return retry.retry(() -> {
                    String bonusNumber = input.getBonusNumber();
                    return apiHandler.transformLottoBonusNumber(bonusNumber);
                },
                e -> output.viewExceptionMessage(e.getMessage())
        );
    }

    public void outputHandler(Api api) {
        exceptionHandler(api);
        purchaseHandler(api);
        resulLottoHandler(api);
        resultAmountHandler(api);
    }

    private void exceptionHandler(Api<?> api) {
        if (!Objects.equals(api.getCode(), SERVER_SUCCESS_CODE)) {
            output.viewExceptionMessage(api.getMessage());
        }
    }

    private void purchaseHandler(Api api) {
        retry.handleApiResponse(api, PurchaseLottosDto.class, output::viewPurchaseLottos);
    }

    private void resulLottoHandler(Api api) {
        retry.handleApiResponse(api, ResultLottosDto.class, output::viewResultLottos);
    }

    private void resultAmountHandler(Api api) {
        retry.handleApiResponse(api, ResultAmountDto.class, output::viewResultAmount);
    }
}
