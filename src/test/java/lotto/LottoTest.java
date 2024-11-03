package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest extends NsTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("6개의 무작위 숫자를 생성한다.")
    @Test
    void 무작위_로또를_생성한다(){
        LottoRepository lottoRepository = new LottoRepository();
        LottoGame lottoGame = new LottoGame(lottoRepository);
        lottoGame.setLottoCount(5000);
        lottoGame.generateLotto();

        assertThat(lottoRepository.getLottos()).hasSize(5);
    }

    @DisplayName("로또는 오름차순 정렬된다")
    @Test
    void 로또는_오름차순_정렬된다(){
        LottoRepository lottoRepository = new LottoRepository();
        LottoGame lottoGame = new LottoGame(lottoRepository);
        lottoGame.setLottoCount(1000);
        lottoGame.generateLotto();

        List<Lotto> savedLottos = lottoRepository.getLottos();
        List<Integer> generatedNumbers = savedLottos.get(0).getNumbers();

        boolean isSorted = true;
        for (int i = 0; i < generatedNumbers.size() - 1; i++) {
            if (generatedNumbers.get(i) > generatedNumbers.get(i + 1)) {
                isSorted = false;
                break;
            }
        }
        assertTrue(isSorted, "로또 번호는 오름차순으로 정렬되어야 합니다.");
    }

    @Test
    void 구매금액_1000원_로또_1개_구매_당첨번호와_일치하는_숫자_없음() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("1000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "1개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 0.0%입니다."
                );
            },
            List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    void 구매금액_1000원_로또_1개_구매_6개_모두_일치() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("1000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "1개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 6]",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 1개",
                    "총 수익률은 200000000.0%입니다."
                );
            },
            List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 구매금액_5000원_로또_5개_구매_다양한_당첨_결과() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("5000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "5개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 6]",
                    "[1, 2, 3, 4, 5, 7]",
                    "[1, 2, 3, 4, 5, 8]",
                    "[1, 2, 3, 4, 9, 10]",
                    "[1, 2, 3, 11, 12, 13]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 1개",
                    "총 수익률은 40631100.0%입니다."
                );
            },
            List.of(1, 2, 3, 4, 5, 6),
            List.of(1, 2, 3, 4, 5, 7),
            List.of(1, 2, 3, 4, 5, 8),
            List.of(1, 2, 3, 4, 9, 10),
            List.of(1, 2, 3, 11, 12, 13)
        );
    }

    @Test
    void 구매금액_8000원_로또_8개_구매_전부_낙첨() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("8000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "8개를 구매했습니다.",
                    "[8, 9, 10, 11, 12, 13]",
                    "[14, 15, 16, 17, 18, 19]",
                    "[20, 21, 22, 23, 24, 25]",
                    "[26, 27, 28, 29, 30, 31]",
                    "[32, 33, 34, 35, 36, 37]",
                    "[38, 39, 40, 41, 42, 43]",
                    "[44, 45, 8, 9, 10, 11]",
                    "[12, 13, 14, 15, 16, 17]",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 0.0%입니다."
                );
            },
            List.of(8, 9, 10, 11, 12, 13),
            List.of(14, 15, 16, 17, 18, 19),
            List.of(20, 21, 22, 23, 24, 25),
            List.of(26, 27, 28, 29, 30, 31),
            List.of(32, 33, 34, 35, 36, 37),
            List.of(38, 39, 40, 41, 42, 43),
            List.of(44, 45, 8, 9, 10, 11),
            List.of(12, 13, 14, 15, 16, 17)
        );
    }

    @Test
    void 구매금액_3000원_로또_3개_구매_보너스_볼_일치() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "3개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 7]",
                    "[1, 2, 3, 4, 7, 8]",
                    "[1, 2, 3, 7, 8, 9]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 1001833.3%입니다."
                );
            },
            List.of(1, 2, 3, 4, 5, 7),
            List.of(1, 2, 3, 4, 7, 8),
            List.of(1, 2, 3, 7, 8, 9)
        );
    }

    @Test
    void 구매금액_7000원_로또_7개_구매_5개_일치() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("7000", "10,11,12,13,14,15", "16");
                assertThat(output()).contains(
                    "7개를 구매했습니다.",
                    "[10, 11, 12, 13, 14, 15]",
                    "[10, 11, 12, 13, 14, 16]",
                    "[10, 11, 12, 13, 14, 17]",
                    "[10, 11, 12, 13, 16, 17]",
                    "[10, 11, 12, 16, 17, 18]",
                    "[10, 11, 16, 17, 18, 19]",
                    "[10, 16, 17, 18, 19, 20]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 1개",
                    "총 수익률은 29022212.0%입니다."
                );
            },
            List.of(10, 11, 12, 13, 14, 15),
            List.of(10, 11, 12, 13, 14, 16),
            List.of(10, 11, 12, 13, 14, 17),
            List.of(10, 11, 12, 13, 16, 17),
            List.of(10, 11, 12, 16, 17, 18),
            List.of(10, 11, 16, 17, 18, 19),
            List.of(10, 16, 17, 18, 19, 20)
        );
    }

    @Test
    void 구매금액_2000원_로또_2개_구매_당첨번호와_보너스_볼_일치_없음() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("2000", "31,32,33,34,35,36", "37");
                assertThat(output()).contains(
                    "2개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 6]",
                    "[7, 8, 9, 10, 11, 12]",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 0.0%입니다."
                );
            },
            List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12)
        );
    }

    @Test
    void 구매금액_6000원_로또_6개_구매_모두_3개_일치() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("6000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "6개를 구매했습니다.",
                    "[1, 2, 3, 7, 8, 9]",
                    "[1, 2, 3, 10, 11, 12]",
                    "[1, 2, 3, 13, 14, 15]",
                    "[1, 2, 3, 16, 17, 18]",
                    "[1, 2, 3, 19, 20, 21]",
                    "[1, 2, 3, 22, 23, 24]",
                    "3개 일치 (5,000원) - 6개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 500.0%입니다."
                );
            },
            List.of(1, 2, 3, 7, 8, 9),
            List.of(1, 2, 3, 10, 11, 12),
            List.of(1, 2, 3, 13, 14, 15),
            List.of(1, 2, 3, 16, 17, 18),
            List.of(1, 2, 3, 19, 20, 21),
            List.of(1, 2, 3, 22, 23, 24)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
