package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.exception.ErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CorrectStatusTest {

    @ParameterizedTest(name = "매칭 횟수 : {0}, 보너스 숫자 포함 여부 : {1}, 결과 : {2}")
    @MethodSource("correctStatusMatching")
    void 매칭_횟수_특수_숫자_포함_여부_반환_테스트(int matchCount,boolean containSpecialNumber,CorrectStatus result){

        //given


        //when
        CorrectStatus correctStatus = CorrectStatus.findByMatchCountAndSpecialNumber(matchCount,containSpecialNumber);

        //then
        assertThat(correctStatus).isEqualTo(result);

    }

    @ParameterizedTest
    @CsvSource(value = {"1,false","1,true","2,true"})
    void 매칭_횟수_안맞을떄(int matchCount,boolean containSpecialNumber){

        //when
        assertThatThrownBy(()->CorrectStatus.findByMatchCountAndSpecialNumber(matchCount,containSpecialNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.CANT_MATCH_CORRECTNESS.getMessage());
    }

    static Stream<Arguments> correctStatusMatching(){
        return Stream.of(
                Arguments.arguments(3,false, CorrectStatus.THREE_CORRECT),
                Arguments.arguments(3,true, CorrectStatus.THREE_CORRECT),
                Arguments.arguments(4,true,CorrectStatus.FOUR_CORRECT),
                Arguments.arguments(4,false,CorrectStatus.FOUR_CORRECT),
                Arguments.arguments(5,true,CorrectStatus.FIVE_CORRECT_WITH_SPECIAL_NUMBER),
                Arguments.arguments(5,false,CorrectStatus.FIVE_CORRECT_WITH_NO_SPECIAL_NUMBER),
                Arguments.arguments(6,false,CorrectStatus.SIX_CORRECT),
                Arguments.arguments(6,true,CorrectStatus.SIX_CORRECT)
        );
    }

}