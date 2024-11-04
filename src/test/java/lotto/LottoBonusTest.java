package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoBonusTest {
    private final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void 로또_보너스_정상_생성() {
        LottoBonus lottoBonus = new LottoBonus(lotto, 7);

        Assertions.assertInstanceOf(LottoBonus.class, lottoBonus);
    }

    @Test
    void 로또_보너스가_중복번호인_경우_에러출력_후_재입력을_받는다() {
        assertThatThrownBy(() -> new LottoBonus(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_보너스가_범위를_벗어난_경우_에러출력_후_재입력을_받는다() {
        assertThatThrownBy(() -> new LottoBonus(lotto, 50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_보너스_조회() {
        LottoBonus lottoBonus = new LottoBonus(lotto, 7);

        Assertions.assertEquals(lottoBonus.getLotto(), lotto);
        Assertions.assertEquals(lottoBonus.getBonus(), 7);
    }
}