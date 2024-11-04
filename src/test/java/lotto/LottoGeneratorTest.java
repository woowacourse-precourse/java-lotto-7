package lotto;

import lotto.Random.RandomGenerator;
import lotto.Random.TestLottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        RandomGenerator randomGenerator = new TestLottoNumberGenerator(List.of(1, 2, 3, 4, 5, 6));
        lottoGenerator = new LottoGenerator(randomGenerator);
    }

    @Test
    @DisplayName("1장에 1000원인 로또로 총 몇개 살 수 있는지 테스트")
    public void getLottoBatchSize(){
        //given
        int purchaseAmount = 5000;
        int expectedLottoBatchSize = 5;

        //when
        int actualLottoBatchSize = lottoGenerator.getLottoBatchSize(purchaseAmount);

        //then
        Assertions.assertThat(actualLottoBatchSize).isEqualTo(expectedLottoBatchSize);
    }

    @Test
    @DisplayName("로또 구입 개수 만큼 로또가 생성되는지 테스트")
    public void validLottoBatchGenerate(){
        //given
        int lottoCount = 5;
        List<Lotto> expectedLottoBatch = IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(lottoGenerator.getRandomNumber()))
                .toList();

        //when
        List<Lotto> actualLottoBatch = lottoGenerator.generateLottoBatch(lottoCount);

        //then
        Assertions.assertThat(actualLottoBatch.size()).isEqualTo(expectedLottoBatch.size());
    }




}