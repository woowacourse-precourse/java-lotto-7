package lotto.common;

public enum LottoConst {
    STARTRANGENUMBER(1),
    ENDRANGENUMBER(45),
    LOTTONUMBERCOUNT(6),
    LOTTOPERAMOUNT(1000);

    private final int lottoConst;

    LottoConst(int lottoConst) {
        this.lottoConst = lottoConst;
    }

    public int getLottoConst() {
        return lottoConst;
    }

}
