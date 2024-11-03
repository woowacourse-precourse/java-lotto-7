package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LottosTest {

    private Lottos lottos;
    private List<Lotto> primitiveLottos;

    @BeforeEach
    void setUp() {
        primitiveLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        lottos = new Lottos(primitiveLottos);
    }

    @Test
    @DisplayName("Lottos 객체가 정상적으로 생성되는지 확인")
    void testLottosCreation() {
        assertNotNull(lottos);
    }

    @Test
    @DisplayName("Lottos 객체에 포함된 Lotto 개수가 정확한지 확인")
    void testGetLottoCount() {
        assertEquals(2, lottos.getLottoCount());
    }

    @Test
    @DisplayName("Lottos 객체가 올바른 리스트를 반환하는지 확인")
    void testGetLottos() {
        assertEquals(primitiveLottos, lottos.getLottos());
    }

    @Test
    @DisplayName("toString 메서드의 결과가 예상과 일치하는지 확인")
    void testToString() {
        String expectedOutput = "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n";
        assertEquals(expectedOutput, lottos.toString());
    }
}
