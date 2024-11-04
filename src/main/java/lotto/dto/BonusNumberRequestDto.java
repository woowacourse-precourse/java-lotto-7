package lotto.dto;

public class BonusNumberRequestDto {
    private final int bonusNumber;

    public BonusNumberRequestDto(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
