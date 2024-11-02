package lotto.service;

public class LottoService {
    public int purchaseLotto(int lottoPrice) {
        int lottoNum = lottoPrice / 1000;

        return lottoNum;
    }
}
