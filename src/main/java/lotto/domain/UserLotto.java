package lotto.domain;

import java.util.List;

public class UserLotto {

    private final List<Integer> lottoNumber;

    public UserLotto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
