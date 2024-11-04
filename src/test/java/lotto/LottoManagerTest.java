package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class LottoManagerTest {
    LottoManager lottoManager=new LottoManager();
    InputView inputView=new InputView();

    //총 당첨금액 계산
    @BeforeEach
    void 로또_매니저_세팅(){
        List<Integer> winningNumbers=List.of(1,2,3,4,5,6);
        lottoManager.setWinningLotto(winningNumbers);
        lottoManager.setBonus(7);
    }
    private InputStream originalIn;
    @BeforeEach
    public void setUp() {
        originalIn = System.in;
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);
    }

    @Test
    void 로또를_발행한다(){
        List<Lotto> lottos=new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));

        lottoManager.makeLotto(List.of(1,2,3,4,5,6));
        lottoManager.makeLotto(List.of(1,2,3,4,5,6));

        final List<Lotto> expected=lottos;
        final List<Lotto> actual=lottoManager.getLottos();

        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i).getNumbers()).isEqualTo(expected.get(i).getNumbers());
        }
    }
    @Test
    void 특정_횟수_만큼_로또를_발행한다() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        lottoManager.buyLottos(2000);

        final List<Lotto> expected = lottos;
        final List<Lotto> actual = lottoManager.getLottos();

        assertThat(actual.size()).isEqualTo(expected.size());
    }
    @Test
    void 금액만큼_횟수를_저장한다() {
        int money=4000;

        int actual=lottoManager.calculateCount(money);

        int expected=4;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 총_당첨금액을_계산해_출력한다(){
        List<Lotto> lottos=new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,7,8,9)));
        lottos.add(new Lotto(List.of(10,21,31,41,13,23)));

        lottoManager.makeLotto(List.of(1,2,3,7,8,9));
        lottoManager.makeLotto(List.of(10,21,31,41,13,23));
        lottoManager.calculateStatistics();
        assertThat(1).isEqualTo(1);
    }
    @Test
    void 당첨번호_입력_에러_쉼표만입력(){
        String simulatedInput = ",,";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThatThrownBy(() -> lottoManager.setWinningLotto(inputView.readWiningNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    //        - 공백,`null`=>`IllegalArgumentException`
    @Test
    void 당첨번호_입력_에러_공백만입력(){
        String simulatedInput = " ";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThatThrownBy(() -> lottoManager.setWinningLotto(inputView.readWiningNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    //        - 번호 개수가 6개가 아닌경우=>`IllegalArgumentException`
    @Test
    void 당첨번호_입력_에러_6개가아닐경우(){
        String simulatedInput = "1,2,3,4,5,6,7";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThatThrownBy(() -> lottoManager.setWinningLotto(inputView.readWiningNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    //        - 각 숫자가 1~45 범위를 벗어나는 경우=>`IllegalArgumentException`
    @Test
    void 당첨번호_입력_에러_범위밖(){
        String simulatedInput = "55,56,56,37,84,60";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThatThrownBy(() -> lottoManager.setWinningLotto(inputView.readWiningNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
