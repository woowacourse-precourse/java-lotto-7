package lotto;

import domain.lotto.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest2 {
    @Test
    void 로또_생성_성공() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        assertThat(lotto.getNumbers()).isEqualTo(6);
    }

    @Test
    void 로또_생성_실패_번호_개수_불일치() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_생성_실패_번호_중복() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(5)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @Test
    void 로또_번호_정렬_확인() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(45),
                new LottoNumber(1),
                new LottoNumber(23),
                new LottoNumber(5),
                new LottoNumber(30),
                new LottoNumber(17)
        ));
        assertThat(lotto.getNumbers()).extracting("number")
                .containsExactly(1, 5, 17, 23, 30, 45);
    }
}
