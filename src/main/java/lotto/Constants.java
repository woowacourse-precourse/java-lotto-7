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
        FIRST_PRIZE( "6개 일치", 2000000000, "2,000,000,000원", 1 ),
        SECOND_PRIZE( "5개 일치, 보너스 볼 일치", 30000000, "30,000,000원", 2 ),
        THIRD_PRIZE( "5개 일치", 1500000, "1,500,000원", 3 ),
        FOURTH_PRIZE( "4개 일치", 50000, "50,000원", 4 ),
        FIFTH_PRIZE( "3개 일치", 5000, "5,000원", 5 ),
        FAILED( "꽝", 0, "0원", 6 );
        private final String condition;
        private final int prize;
        private final String price;
        private final int grade;
        LottoGrade( String condition, int prize,  String price, int grade ){
            this.condition = condition;
            this.prize = prize;
            this.price = price;
            this.grade = grade;
        }
        public String getCondition() { return this.condition; }
        public int getPrize() { return this.prize; }
        public String getPrice() { return this.price; }
        public int getGrade() { return this.grade; }
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
