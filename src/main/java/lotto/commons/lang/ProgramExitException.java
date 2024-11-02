package lotto.commons.lang;

public class ProgramExitException extends RuntimeException {

    public ProgramExitException() {
        super("프로그램을 종료합니다.");
    }

    public ProgramExitException(String message) {
        super(message);
    }

}
