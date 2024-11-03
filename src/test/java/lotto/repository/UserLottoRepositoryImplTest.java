package lotto.repository;

import lotto.domain.UserLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottoRepositoryImplTest {

    private UserLottoRepositoryImpl userLottoRepository;
    private UserLotto sampleUserLotto;

    @BeforeEach
    void setUp() {
        userLottoRepository = new UserLottoRepositoryImpl();
        sampleUserLotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 사용자_로또를_저장하고_찾을_수_있다() {
        UserLotto savedUserLotto = userLottoRepository.save(sampleUserLotto);
        assertThat(savedUserLotto).isEqualTo(sampleUserLotto);

        List<UserLotto> foundUserLottos = userLottoRepository.findAll();
        assertThat(foundUserLottos).containsExactly(sampleUserLotto);
    }
}
