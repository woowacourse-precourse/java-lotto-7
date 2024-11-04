package lotto.util;

public enum LottoInfo {
    NUMBER_COUNT(6);
    
    private final int num;

    LottoInfo(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
