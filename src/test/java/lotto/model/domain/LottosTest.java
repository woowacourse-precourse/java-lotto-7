package lotto.model.domain;

import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("유효한 로또 목록이 주어지면 Lottos 객체가 성공적으로 생성된다")
    void givenValidLottoList_whenCreatingLottos_thenLottosIsCreated() {
        // given
        List<Lotto> validLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        // when
        Lottos lottos = new Lottos(validLottos);

        // then
        assertNotNull(lottos);
        assertEquals(validLottos.size(), lottos.getLottos().size());
    }

    @Test
    @DisplayName("로또 목록이 비어있으면 예외가 발생한다")
    void givenEmptyLottoList_whenCreatingLottos_thenThrowsException() {
        // given
        List<Lotto> emptyLottos = List.of();

        // when & then
        assertThrows(IllegalStateException.class, () -> new Lottos(emptyLottos));
    }

    @Test
    @DisplayName("로또 목록이 null이면 예외가 발생한다")
    void givenNullLottoList_whenCreatingLottos_thenThrowsException() {
        // given
        List<Lotto> nullLottos = null;

        // when & then
        assertThrows(IllegalStateException.class, () -> new Lottos(nullLottos));
    }

    @Test
    @DisplayName("LottosDto로 생성된 Lottos 객체는 동일한 로또 목록을 포함한다")
    void givenLottosDto_whenCreatingLottos_thenLottosContainsSameLottos() {
        // given
        LottosDto lottosDto = new LottosDto(List.of(
                new LottoDto(List.of(1, 2, 3, 4, 5, 6)),
                new LottoDto(List.of(7, 8, 9, 10, 11, 12))
        ));

        // when
        Lottos lottos = new Lottos(lottosDto);

        // then
        assertEquals(2, lottos.getLottos().size());
        assertEquals(List.of(1, 2, 3, 4, 5, 6), lottos.getLottos().get(0).getNumbers());
        assertEquals(List.of(7, 8, 9, 10, 11, 12), lottos.getLottos().get(1).getNumbers());
    }

    @Test
    @DisplayName("getLottos 메서드는 로또 목록을 반환한다")
    void whenCallingGetLottos_thenReturnsLottoList() {
        // given
        List<Lotto> lottosList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        Lottos lottos = new Lottos(lottosList);

        // when
        List<Lotto> result = lottos.getLottos();

        // then
        assertEquals(lottosList, result);
    }
}