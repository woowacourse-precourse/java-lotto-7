package lotto.service;

import lotto.factory.LottoFactory;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Result;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    void 구매금액에_따른_로또_개수_확인() {
        int amount = 5000; // 총 금액
        int expectedCount = amount / 1000; // 예상 로또 개수

        List<Lotto> lottos = lottoService.purchase(amount);

        assertEquals(expectedCount, lottos.size(), "입력한 금액에 따라 올바른 수의 로또가 생성되어야 합니다.");
    }

    @Test
    void 구매금액이_0원일_경우_로또_생성되지_않음() {
        int amount = 0;

        List<Lotto> lottos = lottoService.purchase(amount);

        // 금액이 0원일 경우, 생성된 로또는 없음을 확인
        assertEquals(0, lottos.size(), "구매 금액이 0원이면 로또가 생성되지 않아야 합니다.");
    }

    @Test
    void 구매금액이_부족할_경우_로또_생성되지_않음() {
        int amount = 500; // 로또 가격보다 낮은 금액

        List<Lotto> lottos = lottoService.purchase(amount);

        // 금액이 부족하여 로또가 생성되지 않는지 확인
        assertEquals(0, lottos.size(), "로또 한 장의 가격보다 낮은 금액으로는 로또가 생성되지 않아야 합니다.");
    }

    @Test
    void 유효한_문자열_입력으로_로또_생성() {
        String input = "1, 2, 3, 4, 5, 6";
        Lotto lotto = lottoService.parseLotto(input);

        // 생성된 로또 객체의 번호가 입력과 일치하는지 확인
        assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.getNumbers(), "입력된 문자열에 따라 올바른 로또가 생성되어야 합니다.");
    }

    @Test
    void 숫자가_아닌_값이_포함된_입력_예외_확인() {
        String invalidInput = "1, 2, a, 4, 5, 6";

        // 예외가 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> lottoService.parseLotto(invalidInput), "[ERROR] 숫자가 아닌 값이 포함되어있습니다.");
    }

    @Test
    void 결과_계산_테스트() {
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 10, 11)), // 4등
                new Lotto(List.of(1, 2, 3, 20, 21, 22)) // 5등
        );

        // 당첨 로또 번호 및 보너스 번호 설정
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        // 결과 계산
        Result result = lottoService.calculateResult(userLottos, winningLotto);

        // 예상 결과 검증
        Map<Rank, Integer> matchCount = result.getMatchCount();
        assertEquals(1, matchCount.get(Rank.FIRST));
        assertEquals(1, matchCount.get(Rank.SECOND));
        assertEquals(1, matchCount.get(Rank.THIRD));
        assertEquals(1, matchCount.get(Rank.FOURTH));
        assertEquals(1, matchCount.get(Rank.FIFTH));
        assertEquals(0, matchCount.get(Rank.NONE));
    }

    @Test
    void 총_상금_계산_테스트() {
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7))  // 2등
        );

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Result result = lottoService.calculateResult(userLottos, winningLotto);

        int totalPrize = Rank.FIRST.getPrize() + Rank.SECOND.getPrize();
        assertEquals(totalPrize, result.getTotalPrize(), "총 상금이 올바르게 계산되어야 합니다.");
    }

    @Test
    void 수익률_계산_테스트() {
        // 사용자 로또 생성 (더미 데이터)
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등 당첨용
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        // 당첨 로또 생성
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        // 결과 계산
        Result result = lottoService.calculateResult(userLottos, winningLotto);

        // 예상 수익률 계산
        int totalSpent = userLottos.size() * LottoFactory.PRICE;
        double expectedProfitRate = (double) Rank.FIRST.getPrize() / totalSpent * 100;

        assertEquals(expectedProfitRate, result.getProfitRate(), 0.01, "수익률이 올바르게 계산되어야 합니다.");
    }

}
