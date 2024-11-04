package lotto.lotto.infrastructure;

import java.util.List;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoResult;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.service.port.LottoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRepositoryImplTest {

    private LottoRepository repository;
    private LottoResults lottoResults;

    @BeforeEach
    void setUp() {
        repository = LottoRepositoryImpl.getInstance();
        lottoResults = LottoResults.of(List.of(LottoResult.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)))));
    }

    @Test
    @DisplayName("repository에 LottoResults 객체를 저장하고 찾는다.")
    void repositorySaveTest() {
        // when
        repository.save(lottoResults);

        // then
        Assertions.assertThat(repository.findById(lottoResults.getId())).isEqualTo(lottoResults);
    }

    @Test
    @DisplayName("저장되어있지 않은 객체를 찾으려고 시도하면 IllegalArgumentException을 던진다")
    void repositoryNotFoundExceptionTest() {
        // given
        String id = lottoResults.getId();

        // when-then
        Assertions.assertThatThrownBy(() -> repository.findById(id)).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("저장 시 null인 객체로 시도하면 IllegalArgumentException을 던진다")
    void repositoryNullValueSaveExceptionTest() {
        // given
        LottoResults lottoResults = null;

        // when-then
        Assertions.assertThatThrownBy(() -> repository.save(lottoResults)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("객체를 찾을 때 null인 id로 시도하면 IllegalArgumentException을 던진다.")
    void repositoryNullIdFindExceptionTest() {
        // given
        String id = null;

        // when-then
        Assertions.assertThatThrownBy(() -> repository.findById(id)).isInstanceOf(IllegalArgumentException.class);
    }

}