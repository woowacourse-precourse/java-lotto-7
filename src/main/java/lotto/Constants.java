package lotto;

public class Constants {

    public enum LottoRule {
        MIN_NUMBER(1),
        MAX_NUMBER(45),
        NUM_AMOUNT(6);

        private final int number;
        LottoRule( int number ){
            this.number = number;
        }
        public int getNumber(){ return this.number; }

    }
}
