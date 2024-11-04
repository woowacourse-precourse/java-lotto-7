package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp(){
        Map<Prize, Integer> prizeCounts = new HashMap<>();
        prizeCounts.put(Prize.FIRST, 1);  // 예시로 1등 1개를 설정
        prizeCounts.put(Prize.SECOND, 0); // 나머지는 0개
        prizeCounts.put(Prize.THIRD, 0);
        prizeCounts.put(Prize.FOURTH, 0);
        prizeCounts.put(Prize.FIFTH, 0);

        double roi = 150.0; // 수익률

        // LottoResult 생성
        lottoResult = new LottoResult(prizeCounts, roi);
    }

    @DisplayName("toString 함수가 요구사항에 맞게 결과값을 출력해주는지 테스트")
    @Test
    void toStringTest(){
        String expectedOutput = "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n" +
                "총 수익률은 150.0%입니다.\n";

        // 실제 출력값과 예상 출력값 비교
        assertThat(lottoResult.toString()).isEqualTo(expectedOutput);
    }
}