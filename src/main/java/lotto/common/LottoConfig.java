package lotto.common;

import lotto.LottoApplication;
import lotto.application.PurchaseLottoUseCase;
import lotto.application.RetrieveLottoUseCase;
import lotto.application.service.PurchaseLottoService;
import lotto.application.service.RetrieveLottoService;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.repository.InMemoryLottoRepository;
import lotto.domain.repository.LottoRepository;
import lotto.view.ApplicationConsoleView;
import lotto.view.ApplicationView;
import lotto.view.converter.LottoMessageParser;
import lotto.view.converter.MessageParser;

public final class LottoConfig {

    private static final LottoConfig INSTANCE = new LottoConfig();

    private LottoConfig() {

    }

    public static LottoConfig getInstance() {
        return INSTANCE;
    }

    public LottoApplication lottoApplication() {
        return new LottoApplication(applicationView(), messageConverter(), purchaseLottoUseCase(), retrieveLottoUseCase());
    }

    private ApplicationView applicationView() {
        return new ApplicationConsoleView();
    }

    private MessageParser<Lotto> messageConverter() {
        return new LottoMessageParser();
    }

    private PurchaseLottoUseCase purchaseLottoUseCase() {
        return new PurchaseLottoService(new LottoFactory(), lottoUserRepository());
    }

    private RetrieveLottoUseCase retrieveLottoUseCase() {
        return new RetrieveLottoService(lottoUserRepository());
    }

    private LottoRepository lottoUserRepository() {
        return InMemoryLottoRepository.getInstance();
    }
}
