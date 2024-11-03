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
        FIFTH_PRIZE( "3개 일치", 5000 );
        private final String condition;
        private final int prize;
        LottoGrade( String condition, int prize ){
            this.condition = condition;
            this.prize = prize;
        }
        public String getCondition() { return this.condition; }
        public int getPrize() { return this.prize; }
    }
}
