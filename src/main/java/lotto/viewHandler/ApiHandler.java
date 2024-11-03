package lotto.viewHandler;

import lotto.viewHandler.api.Api;
import lotto.viewHandler.api.message.ServerMessage;
import lotto.viewHandler.api.dto.input.BonusNumberDto;
import lotto.viewHandler.api.dto.input.MoneyDto;
import lotto.viewHandler.api.dto.input.WinningLottoNumbersDto;
import lotto.viewHandler.validator.ValidatorImpl;

public class ApiHandler {
    private final ValidatorImpl validator;

    public ApiHandler(ValidatorImpl validator) {
        this.validator = validator;
    }

    public Api<MoneyDto> transformMoneyDto(String input) {
        MoneyDto dto = new MoneyDto(validator.validateMoney(input));
        return new Api<>(ServerMessage.클라이언트_성공, dto);
    }

    public Api<WinningLottoNumbersDto> transformLottoNumbers(String input) {
        WinningLottoNumbersDto dto = new WinningLottoNumbersDto(validator.validateLottoNumbers(input));
        return new Api<>(ServerMessage.클라이언트_성공, dto);
    }

    public Api<BonusNumberDto> transformLottoBonusNumber(String input) {
        BonusNumberDto dto = new BonusNumberDto(validator.validBonusLottoNumber(input));
        return new Api<>(ServerMessage.클라이언트_성공, dto);
    }
}
