package lotto.service;

import lotto.domain.PublishCount;
import lotto.domain.PublishLotto;
import lotto.repository.PublishLottoRepository;
import lotto.validator.DefaultDuplicateValidator;
import lotto.validator.DefaultRangeValidator;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PublishLottoService 클래스 테스트")
public class PublishLottoServiceTest {

    private PublishLottoService publishLottoService;
    private PublishCount publishCount;
    private LottoValidator lottoValidator;
    private PublishLottoRepository publishLottoRepository;

    @BeforeEach
    void setUp() {
        publishCount = PublishCount.getInstance(3);
        lottoValidator = new LottoValidator(new DefaultRangeValidator(), new DefaultDuplicateValidator());
        publishLottoRepository = PublishLottoRepository.getInstance();
        publishLottoService = new PublishLottoService(publishCount, lottoValidator);

        publishLottoRepository.clear();
    }

    @Test
    void publishLotto를_호출하면_정해진_수의_로또가_저장된다() {
        // When
        publishLottoService.publishLotto();

        // Then
        List<PublishLotto> publishedLottos = publishLottoRepository.findAll();
        assertThat(publishedLottos).hasSize(3); // 3개의 로또가 저장되어야 함
    }

}
