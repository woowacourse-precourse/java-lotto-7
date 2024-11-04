package lotto;

import lotto.model.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    private LottoService lottoService;
    @Test
    void 로또_번호_조합이_정상적으로_생성된다() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        int ticketCount = 8;

        List<List<Integer>> lottoNumbers = lottoService.generateLottoTickets(ticketCount);

        assertThat(lottoNumbers).hasSize(ticketCount);

        for (List<Integer> ticket : lottoNumbers) {
            assertThat(ticket).hasSize(6);
            assertThat(ticket).allMatch(num -> num >= 1 && num <= 45);
            Set<Integer> uniqueNumbers = ticket.stream().collect(Collectors.toSet());
            assertThat(uniqueNumbers).hasSize(6);
        }
    }

}
