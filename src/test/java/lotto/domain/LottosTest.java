package lotto.domain;

import lotto.domain.factory.NumberLottoFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    static List<Lotto> sampleLotto;
    static Lotto lotto1;


    @BeforeAll
    static void setUp() {
        lotto1 = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(ComponentNumber::new)
                .collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Stream.of(2, 3, 4, 5, 6, 7)
                .map(ComponentNumber::new)
                .collect(Collectors.toList()));
        Lotto lotto3 = new Lotto(Stream.of(3, 4, 5, 6, 7, 8)
                .map(ComponentNumber::new)
                .collect(Collectors.toList()));
        sampleLotto = List.of(lotto1, lotto2, lotto3);
    }


    @Test
    @DisplayName("로또는 중복된 값이 들어가지 않는다")
    void testLottosDuplicateValidation() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lottos lottos = new Lottos(3, new NumberLottoFactory(1, 45, 6));
                    assertThat(lottos.getLottos()).isEqualTo(sampleLotto);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(3, 4, 5, 6, 7, 8)
        );
    }

    @Test
    @DisplayName("Lottos의 getter로 얻은 List는 수정이 불가능하다")
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lottos lottos = new Lottos(3, new NumberLottoFactory(1, 45, 6));
                    assertThatThrownBy(() -> {
                        lottos.getLottos().add(lotto1);
                    }).isInstanceOf(UnsupportedOperationException.class);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(3, 4, 5, 6, 7, 8)
        );
    }
}
