package lotto.dto;

public class BonusNumberRequestDTO {
    private static final String NOT_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 숫자이어야 합니다.";

    private int bonusNumber;

    public BonusNumberRequestDTO(String bonusNumberInput) {
        bonusNumber = Integer.parseInt(bonusNumberInput);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int parseBonusNumber(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }
}
