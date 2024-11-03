package lotto;

public enum Rank {

    FIRST(4), SECOND(3), THIRD(2), FOUR(1), FIFTH(0);

    private final int idx;

    Rank(int idx){
        this.idx = idx;
    }

    public int getIdx(){
        return idx;
    }


}
