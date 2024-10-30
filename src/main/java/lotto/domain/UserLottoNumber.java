package lotto.domain;

import java.util.List;

public class UserLottoNumber {

    private final List<Integer> lottoNumber;

    public UserLottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
