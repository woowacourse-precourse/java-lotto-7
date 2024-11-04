package lotto;


    public enum LottoResults{
        THREE_MATCH("3개 일치", 5000), FOUR_MATCH("4개 일치", 50000), FIVE_MATCH("5개 일치", 1500000), FIVE_BONUS_MATCH("5개 일치, 보너스 볼 일치", 30000000), SIX_MATCH("6개 일치", 2000000000);
        private final String howMany;
        private final int prize;

        LottoResults(String howMany, int prize){
            this.howMany = howMany;
            this.prize = prize;
        }
        public String getHowMany(){
            return howMany;
        }
        public int getPrize(){
            return prize;
        }
    }