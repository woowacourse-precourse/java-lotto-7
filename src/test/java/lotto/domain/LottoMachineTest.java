package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import lotto.service.MockLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private static final String EXPECT = """
            [1, 2, 3, 4, 5, 6]
            [7, 8, 9, 10, 11, 12]
            [13, 14, 15, 16, 17, 18]""";

    @DisplayName("지정 갯수 만큼 로또 발행")
    @Test
    void buyLottoTest() {
        Lotto mockLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto mockLotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto mockLotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));
        List<Lotto> mockLottos = List.of(mockLotto1, mockLotto2, mockLotto3);

        String lottos = LottoMachine.buyLotto(3, new MockLottoGenerator(mockLottos)).toLottos();
        assertThat(lottos).isEqualTo(EXPECT);
    }

}
