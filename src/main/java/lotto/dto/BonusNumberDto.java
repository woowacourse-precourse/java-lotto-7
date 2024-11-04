package lotto.dto;

public record BonusNumberDto (int bonusNumber) {
    private static BonusNumberDto bonusNumberDto;

    public BonusNumberDto {
        bonusNumberDto = new BonusNumberDto(bonusNumber);
    }

    public static BonusNumberDto getBonusNumberDto() {
        return bonusNumberDto;
    }
}
