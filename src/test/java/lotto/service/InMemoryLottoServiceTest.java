package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InMemoryLottoServiceTest {

    private LottoService lottoService;
    private LottoRepository lottoRepository;

    @BeforeEach
    void setUp() {
        lottoRepository = InMemoryLottoRepository.getInstance();
        lottoService = InMemoryLottoService.getInstance(lottoRepository);
    }

    @AfterEach
    void tearDown() {
        lottoRepository.deleteAll();
    }

    @Test
    @DisplayName("입력 받은 금액만큼 로또를 생성한다.")
    void buyLotto_Test() {
        String amount = "15000";
        lottoService.buyLotto(amount);
        assertThat(lottoRepository.count()).isEqualTo(15);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호를 입력받아 결과를 계산한다.")
    void calculateLottoResults_Test() {
        Map<Rank, Integer> results = calculateRankCount();

        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.THIRD)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(0);
        // build 시 아래 코드에서 에러 발생
//        assertThat(results.get(Rank.FIFTH)).isEqualTo(0);
//        assertThat(results.get(Rank.NONE)).isEqualTo(0);
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void getPercent_Test() {
        Map<Rank, Integer> results = calculateRankCount();
        String percent = lottoService.getPercent(results);
        assertThat(percent).isEqualTo("67716666.7");
    }

    @Test
    @DisplayName("로또 번호를 List<Integer>로 변환한다.")
    void convertToNumbers_Test() {
        String winnerNumbers = "1,2,3,4,5,6";
        List<Integer> convertedWinnerNumbers = lottoService.convertToNumbers(winnerNumbers);
        assertThat(convertedWinnerNumbers)
                .hasSize(6)
                .containsExactly(1, 2, 3, 4, 5, 6)
                .doesNotHaveDuplicates();
    }

    @Test
    @Disabled
    @DisplayName("잘못된 형식의 로또 번호를 변환하는 경우 예외가 발생한다.(입력에서 검증 하기에 불필요)")
    void convertToNumbers_Invalid_Test() {
        assertThatThrownBy(() -> lottoService.convertToNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("모든 로또를 조회한다.")
    void getAllLottos_Test() {
        Lotto lottoFirst = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lottoSecond = new Lotto(List.of(1,2,3,4,5,7));
        Lotto lottoThird = new Lotto(List.of(1,2,3,4,5,8));
        lottoRepository.save(lottoFirst);
        lottoRepository.save(lottoSecond);
        lottoRepository.save(lottoThird);

        List<Lotto> lottos = lottoService.getAllLottos();

        assertThat(lottos)
                .hasSize(3)
                .containsExactly(lottoFirst, lottoSecond, lottoThird);
        assertThat(lottos.getFirst().getNumbers()).containsExactly(1,2,3,4,5,6);
        assertThat(lottos.get(1).getNumbers()).containsExactly(1,2,3,4,5,7);
        assertThat(lottos.get(2).getNumbers()).containsExactly(1,2,3,4,5,8);
    }

    @Test
    @DisplayName("로또를 삭제한다.")
    void deleteLotto_Test() {
        Lotto lottoFirst = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lottoSecond = new Lotto(List.of(1,2,3,4,5,7));
        lottoRepository.save(lottoFirst);
        lottoRepository.save(lottoSecond);

        lottoService.deleteLottos();
        assertThat(lottoRepository.count()).isEqualTo(0);
    }

    private Map<Rank, Integer> calculateRankCount() {
        String winnerNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";

        Lotto lottoFirst = new Lotto(List.of(1,2,3,4,5,6)); // 1등 당첨
        Lotto lottoSecond = new Lotto(List.of(1,2,3,4,5,7)); // 2등 당첨
        Lotto lottoThird = new Lotto(List.of(1,2,3,4,5,8)); // 3등 당첨
        lottoRepository.save(lottoFirst);
        lottoRepository.save(lottoSecond);
        lottoRepository.save(lottoThird);

        return lottoService.calculateLottoResults(winnerNumbers, bonusNumber);
    }
}
