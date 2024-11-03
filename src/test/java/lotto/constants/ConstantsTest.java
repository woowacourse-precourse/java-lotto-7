package lotto.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConstantsTest {

    @Test
    @DisplayName("로또 길이 값 검증")
    void 로또_길이_값_검증() {
        //when
        int value = Constants.LOTTO_LENGTH.getValue();

        //then
        assertThat(value).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 최소 값 검증")
    void 로또_최소_값_검증() {
        //when
        int value = Constants.LOTTO_MIN_NUMBER.getValue();

        //then
        assertThat(value).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 최대 값 검증")
    void 로또_최대_값_검증() {
        //when
        int value = Constants.LOTTO_MAX_NUMBER.getValue();

        //then
        assertThat(value).isEqualTo(45);
    }

    @Test
    @DisplayName("숫자 값 0 검증")
    void 숫자_값_0_검증() {
        //when
        int value = Constants.ZERO.getValue();

        //then
        assertThat(value).isEqualTo(0);
    }

    @Test
    @DisplayName("천원 값 검증")
    void 천원_값_검증() {
        //when
        int value = Constants.ONE_THOUSAND.getValue();

        //then
        assertThat(value).isEqualTo(1000);
    }

    @Test
    @DisplayName("오천원 값 검증")
    void 오천원_값_검증() {
        //when
        int value = Constants.FIVE_THOUSAND.getValue();

        //then
        assertThat(value).isEqualTo(5000);
    }

    @Test
    @DisplayName("오만원 값 검증")
    void 오만원_값_검증() {
        //when
        int value = Constants.FIFTY_THOUSAND.getValue();

        //then
        assertThat(value).isEqualTo(value);
    }

    @Test
    @DisplayName("백오십만원 값 검증")
    void 백_오십만원_값_검증() {
        //when
        int value = Constants.ONE_MILLION_FIVE_HUNDRED_THOUSAND.getValue();

        //then
        assertThat(value).isEqualTo(value);
    }

    @Test
    @DisplayName("삼천만원 값 검증")
    void 삼천만원_값_검증() {
        //when
        int value = Constants.THIRTY_MILLION.getValue();

        //then
        assertThat(value).isEqualTo(30000000);
    }

    @Test
    @DisplayName("이십억원 값 검증")
    void 이십억원_값_검증() {
        //when
        int value = Constants.TWO_BILLION.getValue();

        //then
        assertThat(value).isEqualTo(2000000000);
    }
}
