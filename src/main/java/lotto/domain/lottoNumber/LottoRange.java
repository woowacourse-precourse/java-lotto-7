package lotto.domain.lottoNumber;

public enum LottoRange {

    LOTTO(1, 45, 6);

    private final int start;
    private final int end;
    private final int count;

    LottoRange(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getCount() {
        return count;
    }

}
