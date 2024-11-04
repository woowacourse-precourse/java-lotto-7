package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.UserMoney;
import lotto.domain.WinningNumbers;
import lotto.service.LottoMachine;
import lotto.service.PrizeCalculator;
import lotto.util.Parser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new UserMoney("hello"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_정수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new UserMoney("1000.23"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_Integer_타입을_벗어나는_큰_수면_예외가_발생한다() {
        assertThatThrownBy(() -> new UserMoney("999999999999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_음수면_예외가_발생한다() {
        assertThatThrownBy(() -> new UserMoney("-3000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_0이면_예외가_발생한다() {
        assertThatThrownBy(() -> new UserMoney("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new UserMoney("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_올바르게_입력되면_통과() {
        assertDoesNotThrow(() -> new UserMoney("3000"));
    }

    @Test
    void 구입_금액에_따른_발행할_로또_장수_계산_메서드_테스트() {
        // given : 구입 금액 및 로또 금액 설정
        UserMoney userMoney = new UserMoney("5000");
        final int lottoPrice = 1000;

        // expected
        int expectedLottoCount = userMoney.getUserMoney() / lottoPrice;

        // when : 로또 발행
        List<Lotto> issuedLottos = LottoMachine.issueLotto(userMoney);

        // then : 발행된 로또의 장수의 예상 값과 실제 값 비교
        assertEquals(expectedLottoCount, issuedLottos.size());
    }

    @Test
    void 로또_번호_입력의_구분자가_쉼표가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Parser.parseToIntegerList("1.2.3.4.5.6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력으로_숫자_이외의_값이_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> Parser.parseToIntegerList("A,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_범위가_1에서_45가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 모든_로또_번호가_올바르게_입력되면_통과() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 11, 21, 31, 41, 45)));
    }

    @Test
    void 공백이_섞여_있어도_올바른_입력이라면_통과() {
        assertDoesNotThrow(() -> Parser.parseToIntegerList("1, 2, 3, 4, 5, 6"));
    }

    @Test
    void 당첨_로또_장수_계산_메서드_테스트() {
        // given: 로또 발행 리스트와 당첨 번호 및 보너스 번호 설정
        List<Lotto> issuedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),    // 1등 (6개 일치)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),    // 2등 (5개 + 보너스)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)),   // 3등 (5개 일치)
                new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)),  // 4등 (4개 일치)
                new Lotto(Arrays.asList(1, 2, 3, 13, 14, 15))  // 5등 (3개 일치)
        );

        WinningNumbers winningNumbers = new WinningNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                7
        );

        // expected
        Map<Integer, Integer> expectedPrizeCounts = new HashMap<>();
        expectedPrizeCounts.put(1, 1); // 1등: 1개
        expectedPrizeCounts.put(2, 1); // 2등: 1개
        expectedPrizeCounts.put(3, 1); // 3등: 1개
        expectedPrizeCounts.put(4, 1); // 4등: 1개
        expectedPrizeCounts.put(5, 1); // 5등: 1개

        // when : 등수별 당첨 로또 장수 계산
        Map<Integer, Integer> actualPrizeCounts = PrizeCalculator.calculatePrizes(issuedLottos, winningNumbers);

        // then: 예상 결과와 실제 결과 비교
        assertEquals(expectedPrizeCounts, actualPrizeCounts);
    }

    @Test
    void 수익률_계산_메서드_테스트() {
        // given : 구입 금액과 당첨 개수 설정
        UserMoney userMoney = new UserMoney("10000");

        Map<Integer, Integer> prizeCounts = new HashMap<>();
        prizeCounts.put(5, 3); // 5등 당첨 3장
        prizeCounts.put(4, 1); // 4등 당첨 1장

        // expected
        double expectedProfitRate = (65_000.0 / 10_000.0) * 100;

        // when : 수익률 계산
        double actualProfitRate = PrizeCalculator.calculateProfitRate(prizeCounts, userMoney);

        // then : 예상 결과와 실제 결과 비교
        assertEquals(expectedProfitRate, actualProfitRate, 0.001);
    }
}
