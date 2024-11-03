package lotto.exception.number;

public class CreatedNumberDuplicatedException extends IllegalArgumentException {

    private static final String MESSAGE = "생성된 로또 번호에 중복이 있습니다.";

    public CreatedNumberDuplicatedException() {
        super(MESSAGE);
    }
}
