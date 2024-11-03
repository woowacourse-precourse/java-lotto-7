package lotto;

public class Constants {
    public enum LottoRule {
        MIN_NUMBER(1),
        MAX_NUMBER(45),
        NUM_AMOUNT(6);
        private final int number;
        LottoRule( int number ){ this.number = number; }
        public int getNumber(){ return this.number; }
    }
    public enum LottoGrade {
        FIRST_PRIZE( "6개 일치", 2000000000 ),
        SECOND_PRIZE( "5개 일치, 보너스 볼 일치", 30000000 ),
        THIRD_PRIZE( "5개 일치", 1500000 ),
        FOURTH_PRIZE( "4개 일치", 50000 ),
        FIFTH_PRIZE( "3개 일치", 5000 ),
        FAILED( "꽝", 0 );
        private final String condition;
        private final int prize;
        LottoGrade( String condition, int prize ){
            this.condition = condition;
            this.prize = prize;
        }
        public String getCondition() { return this.condition; }
        public int getPrize() { return this.prize; }
    }
    public enum TUINotice {
        NOTICE_INPUT_PAYMENT("구입금액을 입력해 주세요.", "" ),
        NOTICE_INPUT_BUY_COUNT("개를 구매했습니다.", "" ),
        NOTICE_INPUT_WINNING_NUMBER( "당첨 번호를 입력해 주세요.", "" ),
        NOTICE_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.", "" ),
        NOTICE_OUTPUT_WIN_RESULT( "당첨 통계", "---" ),
        NOTICE_OUTPUT_EARN_RATE( "총 수익률은", "입니다." );
        private final String output;
        private final String helper;
        TUINotice( String output, String helper ){
            this.output = output;
            this.helper = helper;
        }
        public String getOutput() { return this.output; }
        public String getHelper() { return this.helper; }
    }
}
