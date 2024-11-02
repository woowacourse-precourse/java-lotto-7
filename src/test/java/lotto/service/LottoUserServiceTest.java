package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.EmptyInputException;
import lotto.exception.user.LottoMaximumExceededException;
import lotto.exception.user.NotEnoughMoneyException;
import lotto.exception.user.NotThousandUnitException;
import lotto.model.user.LottoResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoUserServiceTest {

    private LottoUserService service;

    @BeforeEach
    void setUp() {
        service = new LottoUserService();
    }

    private List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        return numbers;
    }

    @Nested
    @DisplayName("로또 번호 생성 검증 테스트")
    class CreateLottoResultTests {

        @Test
        void 빈값_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> service.createLottoResult(""))
                            .isInstanceOf(EmptyInputException.class)
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void Integer_범위_초과_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> service.createLottoResult(String.valueOf(Long.MAX_VALUE)))
                            .isInstanceOf(LottoMaximumExceededException.class)
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 최대값_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> service.createLottoResult("101000"))
                            .isInstanceOf(LottoMaximumExceededException.class)
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 최대값_테스트() {
            assertSimpleTest(() ->
                    assertDoesNotThrow(() -> service.createLottoResult("100000"))
            );
        }

        @Test
        void 금액_부족_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> service.createLottoResult("0"))
                            .isInstanceOf(NotEnoughMoneyException.class)
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 금액_단위_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> service.createLottoResult("1500"))
                            .isInstanceOf(NotThousandUnitException.class)
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    void 로또_번호_자동_추첨_테스트() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            LottoResultDto lottoResultDto = service.createLottoResult("1000");
            List<Set<Integer>> comparableObject = new ArrayList<>();
            comparableObject.add(new HashSet<>(createNumbers()));
            assertEquals(lottoResultDto.lottoResults(), comparableObject);
        }, createNumbers());
    }
}