package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 발행")
    void constructor() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    Lotto lotto = new Lotto(Lotto.generate());
                    assertThat(lotto).isEqualTo(new Lotto(List.of(
                            new LottoNumber(8),
                            new LottoNumber(21),
                            new LottoNumber(23),
                            new LottoNumber(41),
                            new LottoNumber(42),
                            new LottoNumber(43))));
                    assertThat(lotto.toString()).isEqualTo("[8, 21, 23, 41, 42, 43]");
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    @DisplayName("일치 번호 개수 반환")
    void calcMatchCount() {
        assertSimpleTest(() -> {
            Lotto lotto = Lotto.from("1,3,5,14,22,45");
            Lotto other = Lotto.from("1,2,3,4,5,6");
            assertThat(lotto.calcMatchCount(other)).isEqualTo(3);
        });
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    void validateSize() {
        assertThatThrownBy(() -> new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    void validateDuplicate() {
        assertThatThrownBy(() -> new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(5))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
