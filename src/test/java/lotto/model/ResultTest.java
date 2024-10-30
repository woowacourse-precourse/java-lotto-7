package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("resultTest")
    @DisplayName("당첨 금액 테스트")
    void result_totalMoneyTest(List<Integer> prizeCount, String message, int totalMoney) {
        Map<Prize, Integer> sampleMap = new HashMap<>();
        for (Prize prize : Prize.values()) {
            sampleMap.put(prize, prizeCount.get(prize.ordinal()));
        }
        Result sampleResult = new Result(sampleMap);

        assertEquals(sampleResult.totalMoney(), totalMoney);
    }

    static Stream<Arguments> resultTest() {
        return Stream.of(
                Arguments.of(List.of(1, 0, 0, 1, 2), "당첨 금액 테스트 1", 2_000_060_000),
                Arguments.of(List.of(0, 1, 1, 0, 3), "당첨 금액 테스트 2", 31_515_000),
                Arguments.of(List.of(0, 0, 2, 7, 7), "당첨 금액 테스트 3", 3_385_000),
                Arguments.of(List.of(0, 0, 0, 0, 0), "당첨 금액 테스트 4", 0)
        );
    }

}
