package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.global.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        List<Integer> invalidSizeNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> new Lotto(invalidSizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(duplicatedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_NUMBERS_IN_LOTTO.getMessage());
    }

    @DisplayName("로또를 String 으로 변환하면 요구사항의 출력 형식에 맞게 변환된다.")
    @Test
    void 로또를_String_으로_변환하면_요구사항의_출력_형식에_맞게_변환된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto).hasToString("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("당첨 여부에 대한 여러 시나리오를 테스트한다.")
    @Nested
    class MatchTest {
        @DisplayName("당첨 번호가 입력되면 보너스 번호를 제외한 일치율을 계산한다.")
        @Test
        void 당첨_번호가_입력되면_일치율을_계산한다() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningTicket winningTicket = new WinningTicket(List.of(7, 8, 9, 10, 11, 12), 13);

            Prize match = lotto.match(winningTicket);

            Assertions.assertThat(match).isEqualTo(Prize.NONE);
        }

        @DisplayName("3개 번호가 일치하면 3등을 반환한다.")
        @Test
        void 세_개_일치() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
            WinningTicket winningTicket = new WinningTicket(List.of(1, 2, 3, 10, 11, 12), 13);

            Prize match = lotto.match(winningTicket);

            Assertions.assertThat(match).isEqualTo(Prize.THREE);
        }

        @DisplayName("4개 번호가 일치하면 4등을 반환한다.")
        @Test
        void 네_개_일치() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
            WinningTicket winningTicket = new WinningTicket(List.of(1, 2, 3, 4, 11, 12), 13);

            Prize match = lotto.match(winningTicket);

            Assertions.assertThat(match).isEqualTo(Prize.FOUR);
        }

        @DisplayName("5개 번호가 일치하고 보너스 번호가 일치하지 않으면 5등을 반환한다.")
        @Test
        void 다섯_개_일치_보너스_불일치() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
            WinningTicket winningTicket = new WinningTicket(List.of(1, 2, 3, 4, 5, 12), 13);

            Prize match = lotto.match(winningTicket);

            Assertions.assertThat(match).isEqualTo(Prize.FIVE);
        }

        @DisplayName("5개 번호가 일치하고 보너스 번호도 일치하면 2등을 반환한다.")
        @Test
        void 다섯_개_일치_보너스_일치() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
            WinningTicket winningTicket = new WinningTicket(List.of(1, 2, 3, 4, 5, 12), 9);

            Prize match = lotto.match(winningTicket);

            Assertions.assertThat(match).isEqualTo(Prize.FIVE_BONUS);
        }

        @DisplayName("6개 번호가 모두 일치하면 1등을 반환한다.")
        @Test
        void 여섯_개_일치() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningTicket winningTicket = new WinningTicket(List.of(1, 2, 3, 4, 5, 6), 7);

            Prize match = lotto.match(winningTicket);

            Assertions.assertThat(match).isEqualTo(Prize.SIX);
        }
    }
}
