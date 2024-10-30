package lotto.domain.errors;

public enum InputError implements Errors{
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또의 번호 조합에 중복이 숫자가 발견되었습니다.");

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
