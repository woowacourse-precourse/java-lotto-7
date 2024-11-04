package lotto.EnumManagement;

public enum ExceptionEnum {

    LOTTO_NUMBERS_SIZE_SIX("[ERROR] 로또 번호는 6개여야 합니다.");
    private final String massage;

    ExceptionEnum(String message) {
        this.massage = message;
    }

    public String getMessage() {
        return massage;
    }

}
