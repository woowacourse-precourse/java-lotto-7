package lotto.service;

public enum Rank {
    first("3개 일치 (5,000원) - ",5000,4),
    second("4개 일치 (50,000원) - ",50000,3),
    third("5개 일치 (1,500,000원) - ",1500000,2),
    fourth("5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000,1),
    fifth("6개 일치 (2,000,000,000원) - ",2000000000,0);

    private final String message;
    private final int money;
    private final int match;


    Rank(String message,int money,int match) {
        this.message = message;
        this.money = money;
        this.match = match;
    }

    public int getMoney(){
        return this.money;
    }

    public void print(int cnt){
        Output.showRanks(message,cnt);
    }

}
