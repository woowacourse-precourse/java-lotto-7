package lotto.model.dto;

public class LottoGameResult {

    private int num;
    private int prize;
    private int count;

    public LottoGameResult(int num, int prize, int count) {
        this.num = num;
        this.prize = prize;
        this.count = count;
    }

    public int getNum() {
        return num;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

}
