package lotto;

public enum Level {
    SIX_CORRECT(0){
        public int apply(){
            return getCount()*2000000000;
        }
    },
    FIVE_CORRECT_BONUS(0){
        public int apply(){
            return getCount()*30000000;
        }
    },
    FIVE_CORRECT(0){
        public int apply(){
            return getCount()*2000000000;
        }
    },
    FOUR_CORRECT(0){
        public int apply(){
            return getCount()*50000;
        }
    },
    THREE_CORRECT(0){
        public int apply(){
            return getCount()*5000;
        }
    };

    private int count;

    Level(int count){
        this.count=count;
    }

    public void check(){
        count+=1;
    }

    public int getCount(){
        return count;
    }

    public abstract int apply();
}
