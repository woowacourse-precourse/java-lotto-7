package lotto.infrastructures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.common.constant.Constants;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    @DisplayName("랜덤 숫자를 생성하여 로또 한장을 발행하는 테스트")
    @Test
    void generateLotto_randomNumber_returnLotto() {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        Lotto lotto = lottoGenerator.generateLotto();
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        assertAll(
                () -> assertThat(lottoNumbers).hasSize(Constants.LOTTO_SIZE),
                () -> assertThat(lottoNumbers)
                        .allMatch(number -> number.getLottoNumber() >= Constants.MIN_LOTTO_NUMBER
                                && number.getLottoNumber() <= Constants.MAX_LOTTO_NUMBER)
        );
    }
}
