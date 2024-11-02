package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest extends NsTest {
    
    private static final String ERROR_MESSAGE = "[ERROR]";
    
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    
    @Test
    @DisplayName("로또 번호가 1미만, 45초과 일 경우 예외가 발생한다.")
    void 로또_번호가_1미만_45초과일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("로또 번호의 size가 6이 아닐 경우 예외가 발생한다.")
    void 로또_번호의_size가_6이_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    
    @Test
    @DisplayName("로또의 번호들이 배열형식으로 출력이 되는지 확인하는 테스트")
    void 로또_번호들_배열형식으로_출력이_되는지_확인() {
        
        Assertions.assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .contains("[")
                    .contains("]")
                    .contains(",")
                    .doesNotContain("null")
                    .containsPattern("\\[\\d+, \\d+, \\d+, \\d+, \\d+, \\d+\\]");
        });
    }
    
    @Test
    @DisplayName("당첨 통계 출력 - 모든 번호가 일치하는 경우")
    void 당첨_통계_출력_모두_번호_일치() {
        // given
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 6개 일치
        int bonusNumber = 7;
        int purchaseMoney = 1000;
        
        // when
        winningLotto.checkWinningLotto(lottos, bonusNumber, purchaseMoney);
        
        // then
        assertThat(output())
                .contains("6개 일치 (2,000,000,000원) - 1개")
                .contains("총 수익률은 200,000,000.0%입니다.");
    }
    
    @Test
    @DisplayName("당첨 통계 출력 - 5개 일치 + 보너스 번호 일치")
    void 당첨_통계_출력_번호_5개_일치_그리고_보너스_번호_일치() {
        // given
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        
        List<Lotto> lottos = new ArrayList<>();
        
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 5개 + 보너스
        int bonusNumber = 7;
        int purchaseMoney = 1000;
        
        // when
        winningLotto.checkWinningLotto(lottos, bonusNumber, purchaseMoney);
        
        // then
        assertThat(output())
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개")
                .contains("총 수익률은 3,000,000.0%입니다.");
    }
    
    @Test
    @DisplayName("당첨 통계 출력 - 여러 등수가 섞여 있는 경우")
    void 당첨_통계_출력_여러_등수_섞인_경우() {
        // given
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 45))); // 3등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 45, 44))); // 4등
        lottos.add(new Lotto(List.of(1, 2, 3, 45, 44, 43))); // 5등
        int bonusNumber = 7;
        int purchaseMoney = 5000;
        
        // when
        winningLotto.checkWinningLotto(lottos, bonusNumber, purchaseMoney);
        
        // then
        assertThat(output())
                .contains("3개 일치 (5,000원) - 1개")
                .contains("4개 일치 (50,000원) - 1개")
                .contains("5개 일치 (1,500,000원) - 1개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개")
                .contains("6개 일치 (2,000,000,000원) - 1개");
    }
    
    @Test
    @DisplayName("당첨 통계 출력 - 당첨되지 않은 경우")
    void 당첨_통계_출력_당첨_안된_경우() {
        // given
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(40, 41, 42, 43, 44, 45))); // 미당첨
        int bonusNumber = 7;
        int purchaseMoney = 1000;
        
        // when
        winningLotto.checkWinningLotto(lottos, bonusNumber, purchaseMoney);
        
        // then
        assertThat(output())
                .contains("3개 일치 (5,000원) - 0개")
                .contains("4개 일치 (50,000원) - 0개")
                .contains("5개 일치 (1,500,000원) - 0개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개")
                .contains("6개 일치 (2,000,000,000원) - 0개")
                .contains("총 수익률은 0.0%입니다.");
    }
    
    @Test
    @DisplayName("수익률 계산 - 소수점 첫째 자리까지 반올림")
    void 수익률_계산_소수점_첫째_자리까지_반올림() {
        // given
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 45, 44, 43))); // 3개 일치 (5,000원)
        int bonusNumber = 7;
        int purchaseMoney = 8000;
        
        // when
        winningLotto.checkWinningLotto(lottos, bonusNumber, purchaseMoney);
        
        // then
        assertThat(output())
                .contains("총 수익률은 62.5%입니다.");
    }
    
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
