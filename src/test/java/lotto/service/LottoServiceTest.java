package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.Test;
import java.util.List;

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

}
