package lotto.application.prize.message;

public class Message {
    public static final String BONUS_SHOULD_BETWEEN_ONE_FOURTYFIVE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_SHOULD_DIFFERENT_FROM_WINNUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String UNVALID_PRIZE_ID = "[ERROR] 존재 하지 않는 당첨 ID 입니다.";

    public static final String INPUT_PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private Message() {
    }
    
}
