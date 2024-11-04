package lotto.exception;

public enum ParserExceptionMessage {
    NUMBER_FORMAT_INCORRECT("범위 외의 입력이 들어왔거나.. 정수가 아닌 값이 입력 되었습니다.");
    private final String message;

    public String getMessage(){
        return "[ERROR] "+ this.message;
    }
    ParserExceptionMessage(String message){
        this.message=message;
    }
}
