package lotto;

public class BonusNumber {
    private final int BONUS_NUMBER;

    public BonusNumber(String bonusNumber) {
        validateNull(bonusNumber);
        validateSpace(bonusNumber);
        validateNotNumber(bonusNumber);
        int BONUS_NUMBER = Integer.parseInt(bonusNumber);
        validateRange(BONUS_NUMBER);
        this.BONUS_NUMBER = BONUS_NUMBER;
    }

    private void validateRange(int BONUS_NUMBER) {
        if (BONUS_NUMBER < 1 || BONUS_NUMBER > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45중 양수여야 합니다.");
        }
    }

    private void validateNull(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이 아닌 보너스 번호를 입력해 주세요.");
        }
    }

    private void validateSpace(String bonusNumber) {
        if (bonusNumber.equals(" ")) {
            throw new IllegalArgumentException("[ERROR] 스페이스 값이 아닌 보너스 번호를 입력해 주세요.");
        }
    }

    private void validateNotNumber(String bonusNumber) {
        try{
            Integer.parseInt(bonusNumber);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
