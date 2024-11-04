package lotto.model;

public enum WinLotto {
    WIN_TREE("3","5,000", 0),
    WIN_FOUR("4","50,000", 0),
    WIN_FIVE("5","1,500,000", 0),
    WIN_FIVE_AND_BONUS("5","30,000,000", 0),
    WIN_SIX("6","2,000,000,000", 0);

    private final String prizeMoney;
    private final String cnt;
    private int win;
    WinLotto(String cnt, String prizeMoney, int win) {
        this.cnt = cnt;
        this.prizeMoney = prizeMoney;
        this.win = win;
    }

    public void setWin(int count){
        this.win += count;
    }

    public int getWin(){
        return win;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public String getCnt() {
        return cnt;
    }
}
