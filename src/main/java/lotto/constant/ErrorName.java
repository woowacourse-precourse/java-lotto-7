package lotto.constant;

public enum ErrorName {
    ErrorRange("[ERROR] 1부터 45 사이의 숫자를 입력하세요."),
    ErrorSixNumber("[ERROR] 로또 번호는 6개여야 합니다."),
    ErrorDuplication("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
    ErrorDuplicationforAdditionalNumber("[ERROR] 로또 번호와 겹치지 않는 숫자여야 합니다."),
    ErrorNoValue("[ERROR] 금액을 입력하세요."),
    ErrorNotNumber("[ERROR] 숫자를 입력해야 합니다."),
    ErrorThousand("[ERROR] 1000원 단위로 금액을 입력하세요.");

    private final String Message;

    ErrorName(String Message){
        this.Message=Message;
    }

    public String getErrorMessage(){
        return Message;
    }
}