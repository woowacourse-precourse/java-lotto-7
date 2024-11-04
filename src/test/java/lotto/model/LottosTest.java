package lotto.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("Lottos 인스턴스가 유효한 Lotto 목록으로 생성될 수 있는지 테스트")
    void testLottosCreation() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        assertDoesNotThrow(() -> new Lottos(lottoList));
    }

    @Test
    @DisplayName("forEachLotto 메서드가 모든 Lotto 객체에 대해 액션을 수행하는지 테스트")
    void testForEachLotto() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        Lottos lottos = new Lottos(lottoList);

        AtomicInteger counter = new AtomicInteger();
        lottos.forEachLotto(lotto -> counter.incrementAndGet());

        assertEquals(2, counter.get());
    }
}
