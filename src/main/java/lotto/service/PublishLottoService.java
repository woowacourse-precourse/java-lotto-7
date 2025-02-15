package lotto.service;

import lotto.domain.PublishCount;
import lotto.domain.PublishLotto;
import lotto.repository.PublishLottoRepository;
import lotto.validator.LottoValidator;

public class PublishLottoService {

    private final PublishLottoRepository publishLottoRepository;
    private final PublishCount publishCount;
    private final LottoValidator lottoValidator;

    public PublishLottoService(final PublishCount publishCount,
        final LottoValidator lottoValidator) {
        this.publishLottoRepository = PublishLottoRepository.getInstance();
        this.publishCount = publishCount;
        this.lottoValidator = lottoValidator;
    }

    public void publishLotto() {
        for (int i = 0; i < publishCount.getPublishCount(); i++) {
            PublishLotto publishLotto = PublishLotto.from(lottoValidator);
            publishLottoRepository.save(publishLotto);
        }
    }

}
