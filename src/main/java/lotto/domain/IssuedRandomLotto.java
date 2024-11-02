package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class IssuedRandomLotto implements IssuedLotto {
    private final List<Lotto> issuedLottos = new ArrayList<>();
    private final int lottoPurchaseAmount;

    public IssuedRandomLotto(int lottoPurchaseAmount) {
        validate(lottoPurchaseAmount);
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    private void validate(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요.");
        }
        if (lottoPurchaseAmount > 10000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 10,000원 이하로 입력해주세요.");
        }
    }

    @Override
    public List<Integer> selectLottoNumbers() {
        return null;
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }
}
