package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;

import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import lotto.domain.WinningRank;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import lotto.repository.UserLottoRepository;
import lotto.repository.UserLottoRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagementServiceTest {

    private UserLottoRepository userLottoRepository;
    private LottoRepository lottoRepository;
    private LottoManagementService lottoManagementService;

    @BeforeEach
    void setUp() {
        userLottoRepository = new UserLottoRepositoryImpl();
        lottoRepository = new LottoRepositoryImpl();
        lottoManagementService = new LottoManagementService(userLottoRepository, lottoRepository);

        userLottoRepository.clear();
        lottoRepository.clear();
    }

    @AfterEach
    void tearDown() {
        userLottoRepository.clear(); // 테스트 후 사용자 로또 저장소 초기화
        lottoRepository.clear(); // 테스트 후 당첨 로또 저장소 초기화
    }

    @Test
    void 사용자로또를_저장할_수_있다() {
        UserLotto userLotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManagementService.joinUserLotto(userLotto);

        List<UserLotto> allUserLottos = lottoManagementService.getAllUserLottos();
        assertThat(allUserLottos).containsExactly(userLotto);
    }

    @Test
    void 당첨로또를_저장할_수_있다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManagementService.joinLotto(winningLotto);

        Lotto foundLotto = lottoRepository.findWinningNums();
        assertThat(foundLotto).isEqualTo(winningLotto);
    }

    @Test
    void 유저로또에_보너스번호를_설정할_수_있다() {
        UserLotto userLotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManagementService.joinUserLotto(userLotto);

        lottoManagementService.setBonusNumForUsers(7);
        userLotto.setHasBonusNum(7);

        List<UserLotto> allUserLottos = lottoManagementService.getAllUserLottos();
        assertThat(allUserLottos.get(0).getHasBonusnum()).isFalse();
    }

    @Test
    void 랜덤_로또_번호를_생성할_수_있다() {
        UserLotto userLotto = lottoManagementService.createLottoNumbers();
        List<Integer> numbers = userLotto.getNumbers();

        assertThat(numbers).hasSize(6); // 6개의 번호가 생성되어야 함
        assertThat(numbers).allMatch(num -> num >= LottoManagementService.MIN_LOTTO_NUMBER && num
                <= LottoManagementService.MAX_LOTTO_NUMBER); // 번호 범위 체크

        // 오름차순 여부 확인
        assertThat(numbers).isSorted();
    }

    @Test
    void 유저로또와_당첨번호를_비교하여_당첨여부를_확인할_수_있다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManagementService.joinLotto(winningLotto);

        UserLotto userLotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManagementService.joinUserLotto(userLotto);

        lottoManagementService.drawLotto(); // 유저 로또를 통해 당첨 확인

        assertThat(userLotto.getWinningRank()).isEqualTo(WinningRank.FIRST); // 1등일 경우 확인
    }

    @Test
    void 당첨통계를_가져올_수_있다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManagementService.joinLotto(winningLotto);

        UserLotto userLotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        userLotto.setWinningRank(WinningRank.FIRST); // 유저 로또에 당첨 등수 설정
        lottoManagementService.joinUserLotto(userLotto);

        // 통계 계산
        Map<WinningRank, Long> statistics = lottoManagementService.getWinningStatistics();
        assertThat(statistics.get(WinningRank.FIRST)).isEqualTo(1); // 1등 당첨 수가 1개여야 함
    }

    @Test
    void 총상금을_계산할_수_있다() {
        // Assuming the WinningRank has predefined prizes
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManagementService.joinLotto(winningLotto);

        UserLotto userLotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        userLotto.setWinningRank(WinningRank.FIRST); // 유저 로또에 당첨 등수 설정
        lottoManagementService.joinUserLotto(userLotto);

        Map<WinningRank, Long> statistics = lottoManagementService.getWinningStatistics();
        long totalPrize = lottoManagementService.calculateTotalPrize(statistics);

        // 여기에 예상되는 총 상금 값 검증 (가정)
        long expectedPrize = WinningRank.FIRST.getPrize(); // 예시로 1등 당첨금 확인
        assertThat(totalPrize).isEqualTo(expectedPrize);
    }
}
