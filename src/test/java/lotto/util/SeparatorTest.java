package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.util.Separator.separateLottoNumbers;
import static org.junit.jupiter.api.Assertions.*;

class SeparatorTest {

    @Test
    @DisplayName("문자열 입력 받아 문자열 리스트로 변환 : 정상 테스트")
    void separateInputLottoNumbersTest(){
        String testInput= "3,12,4,5,18,43";

        List<String> lottoNumbers = Separator.separateLottoNumbers(testInput);
        List<String> list = Arrays.stream(testInput.split(",")).toList();

        Assertions.assertThat(lottoNumbers).isEqualTo(list);
    }

    @Test
    @DisplayName("로또 문자열이 NUll일때 오류")
    void invalidInputLottoNumbersTest(){
        String testInput= null;

        assertThrows(IllegalArgumentException.class, () ->{
            Separator.separateLottoNumbers(testInput);
        });
    }

}