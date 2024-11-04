package lotto.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTest {
    private static final int PRICE = 1_000;

    @Test
    @DisplayName("숫자인지 검사 - 성공")
    void 숫자인지_검사_성공() {
        // given
        String num = "10";

        // when
        boolean result = Validator.isNum(num);

        // then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("숫자인지 검사 - 실패")
    void 숫자인지_검사_실패() {
        // given
        String num1 = "abc";
        String num2 = "";

        // when
        boolean result1 = Validator.isNum(num1);
        boolean result2 = Validator.isNum(num2);

        // then
        assertEquals(false, result1);
        assertEquals(false, result2);
    }

    @Test
    @DisplayName("범위 내 숫자인지 리스트 검사 - 성공")
    void 범위_내_숫자인지_리스트_검사_성공() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 45);

        // when
        boolean result = Validator.inRangeList(list);

        // then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("범위 내 숫자인지 리스트 검사 - 실패")
    void 범위_내_숫자인지_리스트_검사_실패() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 46);

        // when
        boolean result = Validator.inRangeList(list);

        // then
        assertEquals(false, result);
    }

    @Test
    @DisplayName("범위 내 숫자인지 검사 - 성공")
    void 범위_내_숫자인지_검사_성공() {
        // given
        int n = 10;

        // when
        boolean result = Validator.inRange(n);

        // then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("범위 내 숫자인지 검사 - 실패")
    void 범위_내_숫자인지_검사_실패() {
        // given
        int n = 46;

        // when
        boolean result = Validator.inRange(n);

        // then
        assertEquals(false, result);
    }

    @Test
    @DisplayName("1000의 배수인지 검사 - 성공")
    void 천의_배수인지_검사_성공() {
        // given
        int n = 11000;

        // when
        boolean result = Validator.isMulti(n, PRICE);

        // then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("1000의 배수인지 검사 - 실패")
    void 천의_배수인지_검사_실패() {
        // given
        int n = 11111;

        // when
        boolean result = Validator.isMulti(n, PRICE);

        // then
        assertEquals(false, result);
    }

    @Test
    @DisplayName("숫자가 1000초과인 경우 - 성공")
    void 숫자가_천_초과인_경우_성공() {
        // given
        int n = 1001;

        // when
        boolean result = Validator.isOver(n, PRICE);

        // then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("숫자가 1000초과인 경우 - 실패")
    void 숫자가_천_초과인_경우_실패() {
        // given
        int n = 999;

        // when
        boolean result = Validator.isOver(n, PRICE);

        // then
        assertEquals(false, result);
    }

    @Test
    @DisplayName("자연수인 경우 - 성공")
    void 자연수인_경우_성공() {
        //given
        int n = 1000;

        // when
        boolean result = Validator.isNaturalNum(n);

        // then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("자연수인 경우 - 실패")
    void 자연수인_경우_실패() {
        //given
        int n = 0;

        // when
        boolean result = Validator.isNaturalNum(n);

        // then
        assertEquals(false, result);
    }

    @Test
    @DisplayName("리스트 형식 검사 - 성공")
    void 리스트_형식_성공() {
        // given
        String s1 = "123";
        String s2 = "21,32,123";

        // when
        boolean result1 = Validator.isList(s1);
        boolean result2 = Validator.isList(s2);

        // then
        assertEquals(true, result1);
        assertEquals(true, result2);
    }

    @Test
    @DisplayName("리스트 형식 검사 - 실패")
    void 리스트_형식_실패() {
        // given
        String s1 = "";
        String s2 = "21,,123";

        // when
        boolean result1 = Validator.isList(s1);
        boolean result2 = Validator.isList(s2);

        // then
        assertEquals(false, result1);
        assertEquals(false, result2);
    }

    @Test
    @DisplayName("리스트 중복 검사 - 성공")
    void 리스트_중복_검사_성공() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        // when
        boolean result = Validator.isNotDistinct(list);

        // then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("리스트 중복 검사 - 실패")
    void 리스트_중복_검사_실패() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 5);

        // when
        boolean result = Validator.isNotDistinct(list);

        // then
        assertEquals(false, result);
    }

    @Test
    @DisplayName("다른 리스트 중복 검사 - 성공")
    void 다른_리스트_중복_검사_성공() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        int n = 7;

        // when
        boolean result = Validator.isContain(n, list);

        // then
        assertEquals(false, result);
    }

    @Test
    @DisplayName("다른 리스트 중복 검사 - 실패")
    void 다른_리스트_중복_검사_실패() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        int n = 3;

        // when
        boolean result = Validator.isContain(n, list);

        // then
        assertEquals(true, result);
    }
}