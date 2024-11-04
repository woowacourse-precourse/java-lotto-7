package lotto.function.purchase.processor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.util.generator.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoListSaveProcessorTest {

    LottoListSaveProcessor lottoListSaveProcessor;
    LottoRepository lottoRepository;

    @BeforeEach
    void setUp() {
        lottoRepository = new LottoRepository() {
            @Override
            public void saveAll(List<Lotto> lottoList) {
            }

            @Override
            public List<Lotto> findAll() {
                return null;
            }
        };
    }

    @ParameterizedTest
    @MethodSource("saveLottoList")
    void 구매한_개수만큼_로또를_생성해서_저장한다(List<Lotto> lottoList, int purchasableCount) {

        LottoGenerator lottoGenerator = new LottoGenerator() {
            @Override
            public Lotto generate() {
                return null;
            }

            @Override
            public List<Lotto> generateByCount(int count) {
                return lottoList;
            }
        };
        lottoListSaveProcessor = new LottoListSaveProcessor(lottoGenerator, lottoRepository);

        List<Lotto> savedLottoList = lottoListSaveProcessor.saveLottoList(purchasableCount);
        assertThat(savedLottoList).isEqualTo(lottoList);
    }

    public static Stream<Arguments> saveLottoList() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        return Stream.of(Arguments.of(List.of(lotto), 1),
                Arguments.of(List.of(lotto, lotto, lotto), 3));
    }

}