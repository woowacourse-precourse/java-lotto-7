package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTest {

    @ParameterizedTest
    @CsvSource({
        "6,false,FIRST",
        "5, true, SECOND",
        "5, false, THIRD",
        "4, false, FOURTH",
        "4,true,FOURTH",
        "3, false, FIFTH",
        "2, false, LOSE",
        "1,false,LOSE",
        "0, false, LOSE"
    })
    void 랭크_테스트(int matchLotto, boolean matchBonus,Rank rank){
        Rank result = Rank.assign(matchLotto, matchBonus);
        assertEquals(rank,result);

    }

}
