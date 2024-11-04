package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("로또 결과를 나타낸다.")
    @Test
    void 로또_결과를_나타낸다() {
        Result result = Result.valueOf(5, 0);
        assertEquals(result.matchCount, 5);
        assertEquals(result.winningAmount, 1_500_000);
        assertEquals(result.message, "5개 일치");
    }

    @DisplayName("통계를 반환하는 기능 추가")
    @Test
    void 통계를_반환하는_기능_추가() {
        List<Result> results = new ArrayList<>();
        results.add(Result.FIRST);
        results.add(Result.FIFTH);
        Map<String, Integer> expect = new HashMap<>();
        expect.put("6개 일치" , 1);
        expect.put("3개 일치", 1);

        assertEquals(Result.getStatistics(results), expect);
    }
}