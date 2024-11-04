package lotto.controller;

import lotto.helper.ControllerTestHelper;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoControllerTest {

    private InputView stubInputView;
    private OutputView stubOutputView;

    @BeforeEach
    public void 초기화() {
        stubInputView = ControllerTestHelper.createStubInputView("5000", "1,2,3,4,5,6", "7");
        stubOutputView = ControllerTestHelper.createStubOutputView();
    }

    @Test
    public void 로또_생성_테스트() {
        LottoController lottoController = new LottoController();
        List<Lotto> lottos = lottoController.generateLottos(5);

        assertEquals(5, lottos.size()); // 로또 개수가 올바른지 확인
        for (Lotto lotto : lottos) {
            assertEquals(6, lotto.getNumbers().size()); // 각 로또가 6개의 번호를 갖는지 확인
            lotto.getNumbers().forEach(number -> {
                assertTrue(number >= 1 && number <= 45); // 각 번호가 유효 범위 내에 있는지 확인
            });
        }
    }

    @Test
    public void 실행_테스트() {
        LottoController lottoController = new LottoController(stubInputView, stubOutputView);
        lottoController.run();
    }
}
