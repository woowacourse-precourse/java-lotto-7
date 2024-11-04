package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottiesTest {
    private Lotties lotties;

    @BeforeEach
    void setUp() {
        lotties = new Lotties();
    }

    @DisplayName("로또 티켓을 추가할 수 있는지 테스트")
    @Test
    void 로또_티켓을_추가할_수_있는지_테스트() {
        // Given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // When
        lotties.addLotto(lottoNumbers);

        // Then
        assertThat(lotties.getLottoTickets()).hasSize(1); // 티켓이 1개 추가되어야 함
    }

    @DisplayName("추가한 로또 티켓을 조회할 수 있는지 테스트")
    @Test
    void 추가한_로또_티켓을_조회할_수_있는지_테스트() {
        // Given
        List<Integer> lottoNumbers1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = List.of(7, 8, 9, 10, 11, 12);
        lotties.addLotto(lottoNumbers1);
        lotties.addLotto(lottoNumbers2);

        // When
        List<Lotto> tickets = lotties.getLottoTickets();

        // Then
        assertThat(tickets).hasSize(2); // 두 개의 티켓이 추가되어야 함
        assertThat(tickets.get(0).countMatchingNumbers(lottoNumbers1)).isEqualTo(6);
        assertThat(tickets.get(1).countMatchingNumbers(lottoNumbers2)).isEqualTo(6);
    }

    @DisplayName("로또 티켓 조회는 불변의 리스트를 반환하는지 테스트")
    @Test
    void 로또_티켓_조회는_불변의_리스트를_반환하는지_테스트() {
        // Given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        lotties.addLotto(lottoNumbers);

        // When & Then
        assertThatThrownBy(() -> lotties.getLottoTickets().add(new Lotto(List.of(7, 8, 9, 10, 11, 12))))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
