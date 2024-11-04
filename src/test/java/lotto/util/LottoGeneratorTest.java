package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LottoGeneratorTest {

    @RepeatedTest(1000)
    @DisplayName("중복되지 않는 로또 번호 생성 테스트")
    void generateLottoTest_Unique() {
        // given
        // when
        var lotto = LottoGenerator.generateLotto();
        // then
        assertEquals(Lotto.LOTTO_SIZE, lotto.size());
        assertEquals(Lotto.LOTTO_SIZE, lotto.stream().distinct().count());
    }

    @RepeatedTest(1000)
    @DisplayName("로또 번호 생성 범위 테스트")
    void generateLottoTest_Range() {
        // given
        // when
        var lotto = LottoGenerator.generateLotto();
        // then
        assertTrue(lotto.stream()
                .allMatch(number ->
                        number >= Lotto.MIN_NUMBER &&
                        number <= Lotto.MAX_NUMBER
                )
        );
    }
}