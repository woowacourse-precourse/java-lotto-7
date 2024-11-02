package lotto.viewHandler.api.dto.input;

public class InputDto {
    private final MoneyDto moneyDto;
    private final WinningLottoNumbersDto winningLottoNumbersDto;
    private final BonusNumberDto bonusNumberDto;

    public InputDto(MoneyDto moneyDto, WinningLottoNumbersDto winningLottoNumbersDto, BonusNumberDto bonusNumberDto) {
        this.moneyDto = moneyDto;
        this.winningLottoNumbersDto = winningLottoNumbersDto;
        this.bonusNumberDto = bonusNumberDto;
    }

    public MoneyDto getMoneyDto() {
        return moneyDto;
    }

    public WinningLottoNumbersDto getWinningLottoNumbersDto() {
        return winningLottoNumbersDto;
    }

    public BonusNumberDto getBonusNumberDto() {
        return bonusNumberDto;
    }
}
