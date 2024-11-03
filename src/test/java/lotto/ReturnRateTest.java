package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReturnRateTest {

    private SpyResult result;
    private Payment payment;

    @BeforeEach
    void setUp() {
        result = new SpyResult();
        payment = Payment.from("10000");
    }

    @DisplayName("당첨이 되지 않은 경우 수익률은 0.0%이다.")
    @Test
    void 당첨이_되지_않은_경우_수익률은_영퍼센트이다() {
        ReturnRate returnRate = new ReturnRate();

        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "0.0%");
    }

    @DisplayName("구입 금액과 당첨 금액이 같을 경우 수익률은 100.0%이다.")
    @Test
    void 구입_금액과_당첨_금액이_같을_경우_수익률은_백퍼센트이다() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(10000);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "100.0%");
    }

    @DisplayName("수익률은 천단위로 쉼표(,)를 찍어 출력한다.")
    @Test
    void 수익률은_천단위로_쉼표를_찍어_출력한다() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(2000000000);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "20,000,000.0%");
    }

    @DisplayName("소수점이 없는 경우 소수점은 첫째 자리만 0으로 나타낸다.")
    @Test
    void 소수점이_없는_경우_소수점은_첫째_자리만_0으로_나타낸다() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(5000);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "50.0%");
    }

    @DisplayName("수익률 0.05%는 0.1%로 출력한다.")
    @Test
    void 경계값_테스트_1() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(5);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "0.1%");
    }

    @DisplayName("수익률 0.04%는 0.0%로 출력한다.")
    @Test
    void 경계값_테스트_2() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(4);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "0.0%");
    }

    @DisplayName("당첨 금액이 최대일 경우 수익률을 정상적으로 출력한다.")
    @Test
    void 최대값_테스트_1() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(2000000000L * 100);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "2,000,000,000.0%");
    }

    @DisplayName("당첨 내역이 다양한 경우 수익률을 정상적으로 출력한다.")
    @Test
    void 최대값_테스트_3() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(2000000000L * 96 + 30000000 + 1500000 + 50000 + 5000);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "1,920,315,550.0%");
    }

    @DisplayName("수익률 100% 미만에서 둘째_자리가_5_이하인_경우_버림한다")
    @Test
    void 백퍼센트_미만에서_둘째_자리가_5_미만인_경우_버림한다() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(3333);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "33.3%");
    }

    @DisplayName("수익률 100% 미만에서 둘째_자리가_5_이상인_경우_올림한다")
    @Test
    void 백퍼센트_미만에서_둘째_자리가_5_이상인_경우_올림한다() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(6666);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "66.7%");
    }

    @DisplayName("수익률 100% 이상에서 둘째_자리가_5_이하인_경우_버림한다")
    @Test
    void 백퍼센트_이상에서_둘째_자리가_5_미만인_경우_버림한다() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(9876544);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "98,765.4%");
    }

    @DisplayName("수익률 100% 이상에서 둘째_자리가_5_이상인_경우_올림한다")
    @Test
    void 백퍼센트_이상에서_둘째_자리가_5_이상인_경우_올림한다() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(9999995);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "99,999.9%");
    }

    @DisplayName("모든 자리가 9인 경우 정상적으로 반올림한다")
    @Test
    void 모든_자리가_9인_경우_정상적으로_반올림한다() {
        ReturnRate returnRate = new ReturnRate();

        result.setTotalPrize(9999999);
        String formatReturnRate = returnRate.calculate(result, payment);

        assertEquals(formatReturnRate, "100,000.0%");
    }
}
