package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AdditionalApplicationTest {
    private final Lotto defaultWinningNumbers = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    private final int defaultBonusNumber = 7;





//
//    @Test
//    void 수익률을_구한다() {
//        int earnings = 5000;
//        int expense = 8000;
//
//        double earningsRate = Application.calculateEarningsRate(earnings, expense);
//
//        assertThat(earningsRate).isEqualTo(62.5);
//    }


}
