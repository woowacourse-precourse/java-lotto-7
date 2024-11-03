package lotto.fixture;

import java.util.List;
import lotto.domain.model.LottoNumber;

public class LottoFixture {

    public static List<LottoNumber> createTestLotto() {
        return List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );
    }

    public static List<LottoNumber> createOverSizeLotto() {
        return List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7)
        );
    }

    public static List<LottoNumber> createDuplicatedLotto() {
        return List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(5)
        );
    }
}
