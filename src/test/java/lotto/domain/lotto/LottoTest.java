package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() ->
                LottoFactory.createCustomLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoFactory.createCustomLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 오름차순으로 정렬한다.")
    @Test
    void 로또_번호를_오름차순으로_정렬한다() {
        Lotto lotto1 = LottoFactory.createCustomLotto(List.of(6, 5, 4, 3, 2, 1));
        Lotto lotto2 = LottoFactory.createCustomLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto1).isEqualTo(lotto2);
    }

    @DisplayName("같은 값으로 생성한 두 Lotto 객체는 equals 하고, 같은 hashCode 를 가진다.")
    @Test
    void 같은_값으로_생성한_두_Lotto_객체는_equals_하고_같은_hashCode를_가진다() {
        Lotto lotto1 = LottoFactory.createCustomLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = LottoFactory.createCustomLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto1).isEqualTo(lotto2);
        assertThat(lotto1.hashCode()).isEqualTo(lotto2.hashCode());
    }

    @DisplayName("다른 값으로 생성한 두 Lotto 객체는 equals 하지 않다.")
    @Test
    void 다른_값으로_생성한_두_Lotto_객체는_equals_하지_않다() {
        Lotto lotto1 = LottoFactory.createCustomLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = LottoFactory.createCustomLotto(List.of(2, 3, 4, 5, 6, 7));

        assertNotEquals(lotto1, lotto2);
    }

    @DisplayName("동일 객체를 비교할때도 equals 하다.")
    @Test
    void 동일_객체를_비교할때도_equasl_하다() {
        Lotto lotto = LottoFactory.createCustomLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(lotto);
    }

    @DisplayName("Lotto 객체의 toString 메소드로 로또 번호들을 문자열로 반환한다.")
    @Test
    void Lotto_객체의_toString_메소드로_로또_번호들을_문자열로_반환한다() {
        Lotto lotto = LottoFactory.createCustomLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]\n");
    }
}
