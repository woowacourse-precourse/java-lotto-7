package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.controller.LottoController;
import lotto.dto.LottoResponseDTO;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.model.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoControllerTest {
    private LottoController lottoController;
    private InputView inputView;
    private OutputView outputView;
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        inputView = new InputView();  // 실제 인스턴스
        outputView = new OutputView(); // 실제 인스턴스
        lottoService = new LottoService(); // 실제 인스턴스
        lottoController = new LottoController(inputView, outputView, lottoService);
    }

    @Test
    void 로또_구매_금액에_따라_정확한_개수의_로또를_생성해야_한다() {
        int purchaseAmount = 5000;
        // 로또 생성 개수에 따라 로또 목록 생성
        List<Lotto> generatedLottos = lottoService.generateLottos(purchaseAmount);
        // 예상 값 설정
        int expectedLottoCount = purchaseAmount / 1000;
        // 검증
        assertEquals(expectedLottoCount, generatedLottos.size());
    }

    @Test
    void 결과를_정확하게_계산하고_출력해야_한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7))   // 2등
        );
        // 결과 계산
        LottoResponseDTO responseDTO = lottoService.calculateResult(userLottos, winningLotto, bonusNumber);
        LottoResults results = responseDTO.getResults();
        // 예상 결과 설정
        Map<Rank, Integer> expectedResults = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0,
                Rank.MISS, 0
        );
        // 검증
        assertEquals(expectedResults, results.getResultMap());
    }
}
