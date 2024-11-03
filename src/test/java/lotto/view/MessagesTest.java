package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.winningResult.WinningRank;
import lotto.view.output.Messages;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MessagesTest {
    @Test
    void 발행된_로또_내역_메세지() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 3, 2, 5, 6, 4));

        String issuedLottoMsg = Messages.ISSUED_LOTTO(numbers);

        assertThat(issuedLottoMsg).isEqualTo("[1, 3, 2, 5, 6, 4]");
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST:6개 일치", "SECOND:5개 일치, 보너스 볼 일치", "THIRD:5개 일치", "FOURTH:4개 일치", "FIFTH:3개 일치"}
            , delimiter = ':')
    void 등수별_일치_조건_메세지(WinningRank winningRank, String expectedMessage) {
        String matchingConditionMsg = Messages.MATCHING_CONDITION(winningRank);

        assertThat(matchingConditionMsg).isEqualTo(expectedMessage);
    }

    @ParameterizedTest
    @CsvSource(value = {"5000:5,000"
            , "50000:50,000"
            , "1500000:1,500,000"
            , "30000000:30,000,000"
            , "2000000000:2,000,000,000"}
            , delimiter = ':')
    void 등수별_당첨금액_메세지(int price, String expectedMessage) {
        String priceMsg = Messages.PRICE(price);

        assertThat(priceMsg).isEqualTo(expectedMessage);
    }
}
