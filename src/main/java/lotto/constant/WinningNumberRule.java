package lotto.constant;

public enum WinningNumberRule {
    ONLY_COMMA_INTEGER("[ERROR] 당첨 번호는 정수와 쉼표(,)만 입력 가능합니다."),
    DOUBLE_COMMA("[ERROR] 쉼표(,)가 연속될 수 없습니다."),
    COMMA_FIRST("[ERROR] 쉼표(,) 앞에는 숫자를 입력해야 합니다."),
    COMMA_LAST("[ERROR] 쉼표(,) 뒤에는 숫자를 입력해야 합니다."),
    COUNT("[ERROR] 6개의 숫자를 입력해야 합니다."),
    SCOPE("[ERROR] 당첨 번호는 1 이상, 45 이하의 숫자만 가능합니다."),
    DUPLICATION("[ERROR] 당첨 번호는 중복된 숫자가 포함될 수 없습니다."),
    BONUS_DUPLICATION("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    COMMA(",");

    private final String message;

    WinningNumberRule(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
