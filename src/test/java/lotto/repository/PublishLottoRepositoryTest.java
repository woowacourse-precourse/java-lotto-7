package lotto.repository;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import lotto.domain.PublishLotto;
import lotto.validator.DefaultDuplicateValidator;
import lotto.validator.DefaultRangeValidator;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PublishLottoRepository 클래스 테스트")
public class PublishLottoRepositoryTest {

    private PublishLottoRepository publishLottoRepository;
    private LottoValidator validator;

    @BeforeEach
    void setUp() {
        publishLottoRepository = PublishLottoRepository.getInstance();
        validator = new LottoValidator(new DefaultRangeValidator(),
            new DefaultDuplicateValidator());
    }

    @Test
    void 로또_번호를_저장하고_저장된_번호를_반환한다() {
        // Given
        PublishLotto publishLotto = PublishLotto.from(validator);
        publishLottoRepository.save(publishLotto);

        // When
        List<PublishLotto> publishedLottos = publishLottoRepository.findAll();

        // Then
        assertThat(publishedLottos).containsExactly(publishLotto);
    }

}
