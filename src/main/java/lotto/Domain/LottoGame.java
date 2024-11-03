package lotto.Domain;

public class LottoGame {
    private final LottoNumber lottoNumber;

    public LottoGame() {
        this.lottoNumber = new LottoNumber();
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }
}
