package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.winningResult.rank.Rank;
import lotto.view.output.Messages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MessagesTest {
    @Test
    @DisplayName("[success] 발행된 로또의 숫자를 정해진 형식으로 출력한다.")
    void issuedLottoMessage() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 3, 2, 5, 6, 4));

        String issuedLottoMsg = Messages.ISSUED_LOTTO(numbers);

        assertThat(issuedLottoMsg).isEqualTo("[1, 3, 2, 5, 6, 4]");
    }

    @ParameterizedTest
    @DisplayName("[success] 특정 등수의 일치 조건을 정해진 형식으로 출력한다.")
    @CsvSource(value = {"FIRST:6개 일치", "SECOND:5개 일치, 보너스 볼 일치", "THIRD:5개 일치", "FOURTH:4개 일치", "FIFTH:3개 일치"}
            , delimiter = ':')
    void matchingContidionOfWinningRankMessage(Rank rank, String expectedMessage) {
        String matchingConditionMsg = Messages.MATCHING_CONDITION(rank);

        assertThat(matchingConditionMsg).isEqualTo(expectedMessage);
    }

    @ParameterizedTest
    @DisplayName("[success] 숫자를 세 자리 단위로 끊어서 출력한다.")
    @CsvSource(value = {"5000:5,000"
            , "50000:50,000"
            , "1500000:1,500,000"
            , "30000000:30,000,000"
            , "2000000000:2,000,000,000"}
            , delimiter = ':')
    void priceOfWinningRankMessage(int price, String expectedMessage) {
        String priceMsg = Messages.PRICE(price);

        assertThat(priceMsg).isEqualTo(expectedMessage);
    }
}
