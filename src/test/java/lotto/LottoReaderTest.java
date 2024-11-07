package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoReaderTest extends IOTest{

    @Test
    void givenWinningNumber_when_thenSetWinningNumber() {

        LottoReader reader = new LottoReader();

        systemIn("1,2,3,4,5,6\n8");

        reader.setWinningNum();
        reader.setBonusNum();

        assertThat(reader.winningNum).isEqualTo(List.of(1,2,3,4,5,6));
        assertThat(reader.bonus).isEqualTo(8);
        System.setIn(null);
    }

    @Test()
    void givenDuplicationWinningNumber_when_thenErrorMessageAndAgain() {

        //Given
        LottoReader reader = new LottoReader();

        systemIn("1,2,3,4,5,5\n1,2,3,4,5,6");

        //When
        reader.setWinningNum();
        //Then
        assertThat(getOutput()).contains("[ERROR] 로또 번호는 중복되지 않은 6개여야 합니다.");
        System.setIn(null);
    }

    @Test
    void givenOver45Number_when_thenError() {

        //Given
        LottoReader reader = new LottoReader();

        systemIn("1,2,3,4,5,46\n1,2,3,4,5,6");

        //When
        reader.setWinningNum();
        //Then
        assertThat(getOutput()).contains("[ERROR] 로또 번호는 1~45 사이의 숫자입니다.");
        System.setIn(null);
    }

    @Test
    void givenLotto_when_thenPrize() {
        //Given
        LottoReader reader = new LottoReader();
        Customer kim = new Customer();

        systemIn("1,2,3,4,5,6\n7");

        reader.setWinningNum();
        reader.setBonusNum();

        kim.myLotto.add(new Lotto(List.of(1,2,3,4,5,6)));
        kim.myLotto.add(new Lotto(List.of(1,2,3,4,5,7)));

        //When
        reader.checkResult(kim);

        //Then
        assertThat(kim.prize).isEqualTo(2030000000);
    }

    @Test
    void givenPayAndPrize_when_thenBenefitRate() {

        //Given
        LottoReader reader = new LottoReader();
        Customer kim = new Customer();
        kim.count = 5;
        kim.prize = 500000;

        //When
        reader.printBenefitRate(kim);
        //Then
        assertThat(getOutput()).contains("총 수익률은 10000.0%입니다.");

    }
}