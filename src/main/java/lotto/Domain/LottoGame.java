package lotto.Domain;

public class LottoGame {
    private final LottoNumber lottoNumber;
    private

    public LottoGame(String lottoNumber) {
        this.lottoNumber = new LottoNumber();
        this.lottoNumber.generateNumbers();
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }

    public
}
