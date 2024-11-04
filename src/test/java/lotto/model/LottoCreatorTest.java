package lotto.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCreatorTest {
    @Test
    void 로또_구매_개수가_알맞게_구해지는_지_확인(){
        //Given
        LottoCreator lottoCreator = new LottoCreator();
        SoftAssertions softly = new SoftAssertions();

        //When
        int numberOfLotto1 = lottoCreator.chooseNumberOfLotto(12000);
        int numberOfLotto2 = lottoCreator.chooseNumberOfLotto(30000);

        //Then
        softly.assertThat(numberOfLotto1).isEqualTo(12);
        softly.assertThat(numberOfLotto2).isEqualTo(30);
        softly.assertAll();
    }

    @Test
    void 로또_구입금액이_1000원이_넘지_않을_때_오류_발생(){
        //Given
        LottoCreator lottoCreator = new LottoCreator();

        //When & Then
        assertThatThrownBy(()->lottoCreator.chooseNumberOfLotto(800))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->lottoCreator.chooseNumberOfLotto(-200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입금액이_1000원으로_떨어지지_않을_때_오류_발생(){
        //Given
        LottoCreator lottoCreator = new LottoCreator();

        //When & Then
        assertThatThrownBy(()->lottoCreator.chooseNumberOfLotto(1234))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->lottoCreator.chooseNumberOfLotto(2001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
