package lotto.dto;

public class BonusNumberDto {
    private static int bonusNumber;

    public static void set(int bonusNumber) {
        BonusNumberDto.bonusNumber = bonusNumber;
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }
}
