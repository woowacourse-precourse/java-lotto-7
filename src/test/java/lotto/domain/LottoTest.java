package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Nested
    class 로또_번호_개수_검증 {

        @Test
        void 로또_번호가_정확히_6개일_경우_Lotto_객체를_생성할_수_있다() {
            // given
            List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

            // when
            Lotto lotto = new Lotto(validNumbers);

            // then
            assertThat(lotto).isInstanceOf(Lotto.class);
        }

        @Test
        void 로또_번호가_6개가_아니면_Lotto_객체_생성에_실패한다() {
            // given
            List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

            // when & then
            assertThatThrownBy(() -> new Lotto(invalidNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    @Nested
    class 로또_번호_중복_검증 {

        @Test
        void 로또_번호에_중복된_숫자가_있으면_Lotto_객체_생성에_실패한다() {
            // given
            List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5, 5);

            // when & then
            assertThatThrownBy(() -> new Lotto(duplicateNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DUPLICATE_LOTTO_NUMBER_NOT_ALLOWED.getMessage());
        }
    }

    @Nested
    class 로또_번호_범위_검증 {

        @Test
        void 로또_번호가_1에서_45_사이가_아니면_Lotto_객체_생성에_실패한다() {
            List<Integer> outOfRangeNumbers = List.of(0, 2, 3, 4, 5, 46);
            assertThatThrownBy(() -> new Lotto(outOfRangeNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

}