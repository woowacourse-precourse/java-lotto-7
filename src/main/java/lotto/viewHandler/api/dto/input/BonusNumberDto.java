package lotto.viewHandler.api.dto.input;

public class BonusNumberDto {
    private final Integer number;

    public BonusNumberDto(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
