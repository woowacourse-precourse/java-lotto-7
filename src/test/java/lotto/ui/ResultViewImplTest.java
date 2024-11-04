package lotto.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 포맷팅 테스트: 테스트시 formatRate() 접근제어자 변경 필요
 */
class ResultViewImplTest {

    private ResultViewImpl resultView;

    @BeforeEach
    void setUp() {
        resultView = new ResultViewImpl();
    }

    /*@ParameterizedTest
    @MethodSource("rateProvider")
    public void 포맷팅(double input, String expectedOutput) {
        String formattedRate = resultView.formatRate(input);
        assertEquals(expectedOutput, formattedRate);
    }

    static Object[][] rateProvider() {
        return new Object[][]{
                {2000000000.0, "2,000,000,000.0%"},
                {1000000.0, "1,000,000.0%"},
                {0.0, "0.0%"}
        };
    }*/
}