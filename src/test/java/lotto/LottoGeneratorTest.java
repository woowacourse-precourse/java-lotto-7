package lotto;


import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    LottoGenerator lottoGenerator;

    @BeforeEach
    void setup(){
        lottoGenerator = new LottoGenerator();
    }

    @Test
    @DisplayName("입금액이 올바른 형태일 경우 장당 1000원임을 고려해 발행 매수를 파악할 수 있다.")
    void getTicketCountTest() throws Exception {
        String input = "5000";

        lottoGenerator.getTicketCount(input);

        Assertions.assertThat(lottoGenerator.lottoCount).isEqualTo(5);
    }

    @Test
    @DisplayName("입금액이 올바르지 않을 경우 발행매수를 계산할 수 없다.")
    void failGetTicketCountTest(){
        Assertions.assertThatThrownBy(()->lottoGenerator.getTicketCount(null))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 입금액이 입력되지 않았습니다.");

        Assertions.assertThatThrownBy(()->lottoGenerator.getTicketCount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입금액이 올바르지 않습니다. 1000 단위로 입력해주세요.");

        Assertions.assertThatThrownBy(()->lottoGenerator.getTicketCount(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입금액이 올바르지 않습니다. 1000 단위로 입력해주세요.");

        Assertions.assertThatThrownBy(()->lottoGenerator.getTicketCount("100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입금액이 올바르지 않습니다. 1000 단위로 입력해주세요.");

        Assertions.assertThatThrownBy(()->lottoGenerator.getTicketCount("fail"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입금액이 올바르지 않습니다. 1000 단위로 입력해주세요.");
    }

    @Test
    @DisplayName("발행 매수 만큼 로또 리스트에 로또가 생성된다.")
    void generateLottoTest1(){
        int numberOfLotto = 4;

        lottoGenerator.generateLotto(numberOfLotto);

        Assertions.assertThat(lottoGenerator.lottoList.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("생성된 리스트에는 6개의 숫자가 있다.")
    void generateLottoTest2(){
        int lottoCount =3;
        lottoGenerator.generateLotto(lottoCount);

        Lotto a1 = lottoGenerator.lottoList.get(0);
        Lotto a2 = lottoGenerator.lottoList.get(1);
        Lotto a3 = lottoGenerator.lottoList.get(2);

        Assertions.assertThat(a1.getNumbers()).hasSize(6);
        Assertions.assertThat(a2.getNumbers()).hasSize(6);
        Assertions.assertThat(a3.getNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("입금액을 넣으면 6개의 랜덤 숫자를 가진 로또가 입금액치만큼 반환된다.")
    void getLottoListTest() throws Exception {
        String input = "4000";
        List<Lotto> lottoList = new ArrayList<>();

        lottoList = lottoGenerator.getLottoList(input);

        Assertions.assertThat(lottoList.size()).isEqualTo(4);
    }
}
