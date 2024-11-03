package lotto;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import lotto.service.BasicLottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BasicLottoServiceTest {

    private BasicLottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new BasicLottoService();
    }

    @DisplayName("구입 금액에 따른 발행 가능한 로또 수를 반환한다")
    @Test
    void get_issue_count() {
        int cost = 5000;
        int lottoPrice = 1000;
        int issueCount = lottoService.getIssueCount(cost, lottoPrice);

        assertThat(issueCount).isEqualTo(5);
    }

    @DisplayName("발행된 로또 목록을 반환한다")
    @Test
    void issue_lotto() {
        List<Integer> list1 = List.of(10, 11, 12, 13, 14, 15);
        List<Integer> list2 = List.of(16, 17, 18, 19, 20, 21);
        List<Integer> list3 = List.of(22, 23, 24, 25, 26, 27);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    int issueCount = 3;
                    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
                    List<Lotto> issuedLotto = lottoService.issueLotto(issueCount);

                    assertThat(issuedLotto).hasSize(issueCount);
                    System.out.println(issuedLotto.get(0).getNumbers());
                    assertThat(issuedLotto.get(0).getNumbers()).containsExactlyElementsOf(list1);
                },
                list1,
                list2,
                list3
        );
    }

    @DisplayName("발행된 로또가 오름차순으로 정렬되어 있는지 확인한다")
    @Test
    void issue_lotto_is_sorted() {
        int issueCount = 3;
        List<Lotto> issuedLotto = lottoService.issueLotto(issueCount);
        List<Integer> numbers1 = issuedLotto.get(0).getNumbers();
        List<Integer> numbers2 = issuedLotto.get(1).getNumbers();
        List<Integer> numbers3 = issuedLotto.get(2).getNumbers();

        assertThat(numbers1).isSorted();
        assertThat(numbers2).isSorted();
        assertThat(numbers3).isSorted();
    }

    @DisplayName("발행된 로또 목록과 당첨 번호에 따라 로또 랭크 목록을 반환한다")
    @Test
    void rank_lotto() {
        List<Lotto> issuedLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        List<LottoRank> ranks = lottoService.rankLotto(issuedLotto, winningLotto);

        assertThat(ranks).hasSize(2);
        assertThat(ranks.get(0)).isEqualTo(LottoRank.FIRST);
        assertThat(ranks.get(1)).isEqualTo(LottoRank.NONE);
    }
}
