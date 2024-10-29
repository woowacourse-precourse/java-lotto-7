package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {


    @Test
    @DisplayName("발행한 로또 번호 값 출력 포맷에 맞게 반환 테스트")
    void testGetAllLottoNumbers() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        LottoTickets lottoTickets = new LottoTickets(lottos);

        // When
        String result = lottoTickets.toString();

        // Then
        String expected = """
                [1, 2, 3, 4, 5, 6]
                [7, 8, 9, 10, 11, 12]
                [13, 14, 15, 16, 17, 18]""";
        assertThat(result).isEqualTo(expected);
    }
}