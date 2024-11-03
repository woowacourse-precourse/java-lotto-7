package lotto.input;

public class LottoCount {
    private final int lottoCount;

    public LottoCount(String lottoCount) {
        this.lottoCount = parse(lottoCount);
    }

    private int parse(String lottoCount) {
        return Integer.parseInt(lottoCount);
    }

    public int get() {
        return lottoCount;
    }
}
