package lotto.viewHandler;

import lotto.view.Input;
import lotto.view.Output;
import lotto.viewHandler.api.Api;
import lotto.viewHandler.api.dto.output.PurchaseLottosDto;
import lotto.viewHandler.api.dto.output.ResultAmountDto;
import lotto.viewHandler.api.dto.output.ResultLottosDto;
import lotto.viewHandler.api.message.ServerMessage;
import lotto.viewHandler.api.dto.input.BonusNumberDto;
import lotto.viewHandler.api.dto.input.InputDto;
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

    public Api<InputDto> inputHandler() {
        MoneyDto moneyDto = purchaseMoney();
        WinningLottoNumbersDto numbersDto = getWinningNumbers();
        BonusNumberDto bonusNumber = getBonusNumber();

        input.closeInput();
        return new Api<>(ServerMessage.클라이언트_성공, new InputDto(moneyDto, numbersDto, bonusNumber));
    }

    public void outputHandler(Api api) {
        purchaseHandler(api);
        resulLottoHandler(api);
        resultAmountHandler(api);
    }

    private MoneyDto purchaseMoney() {
        try{
            String money = input.getPurchaseMoney();
            Api<MoneyDto> dtoApi = apiHandler.transformMoneyDto(money);
            return dtoApi.getData();
        } catch (MyException e) {
            throw e;
        }
    }

    private WinningLottoNumbersDto getWinningNumbers() {
        try{
            String lottoNumbers = input.getWinningLottoNumbers();
            Api<WinningLottoNumbersDto> numbersDtoApi = apiHandler.transformLottoNumbers(lottoNumbers);
            return numbersDtoApi.getData();
        } catch (MyException e) {
            throw e;
        }
    }

    private BonusNumberDto getBonusNumber() {
        try{
            String bonusNumber = input.getBonusNumber();
            Api<BonusNumberDto> numberDtoApi = apiHandler.transformLottoBonusNumber(bonusNumber);
            return numberDtoApi.getData();
        } catch (MyException e) {
            throw e;
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
