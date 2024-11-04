package lotto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoCheckerTest {
    private LottoChecker lottoChecker;
    private Logger log = Logger.getLogger(LottoCheckerTest.class.getName());

    @BeforeEach
    void setUp() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        int bonusNum = 7;

        lottoChecker = new LottoChecker(nums, bonusNum);
    }

    @DisplayName("수익률 계산하는 메서드")
    @ParameterizedTest
    @MethodSource("calculateRateOfReturn")
    void calculateRateOfReturnTest(int[] ranks) {
        double result = lottoChecker.calculateRateOfReturn(ranks);
        log.info("결과: " + result);
        assertTrue(result >= 0);
    }

    public static Stream<Arguments> calculateRateOfReturn() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 1, 1, 1, 1, 1}),
                Arguments.of((Object) new int[]{1, 0, 0, 0, 0, 0}),
                Arguments.of((Object) new int[]{0, 0, 0, 0, 0, 1})
        );
    }
}
