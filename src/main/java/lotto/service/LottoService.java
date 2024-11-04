package lotto.service;

public class LottoService {

    public String extractLottoNumber(String lotto) {
        return lotto.substring(1, lotto.length() - 1);
    }
}
