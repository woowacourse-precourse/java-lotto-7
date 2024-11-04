package lotto.application.ticket.domain.ticket;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Lottos - 생성")
class LottosTest {

    @Test
    @DisplayName("유효한 로또 목록으로 생성 성공")
    void 정상_로또목록_생성_성공() {
        // given
        List<Lotto> lottoList = List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(7, 8, 9, 10, 11, 12))
        );

        // expect
        Assertions.assertThatCode(() -> Lottos.of(lottoList))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("null 로또 목록으로 생성시 예외 발생")
    void null_로또목록_생성시_예외발생() {

        // expect
        Assertions.assertThatThrownBy(() -> Lottos.of(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 목록은 null일 수 없습니다.");
    }

    @Test
    @DisplayName("빈 로또 목록으로 생성시 예외 발생")
    void 빈_로또목록_생성시_예외발생() {

        // expect
        Assertions.assertThatThrownBy(() -> Lottos.of(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 목록은 비어있을 수 없습니다.");
    }

}


