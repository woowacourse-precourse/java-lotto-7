package lotto;

public final class LottoConfig {

    private static final LottoConfig INSTANCE = new LottoConfig();

    private LottoConfig() {

    }

    public static LottoConfig getInstance() {
        return INSTANCE;
    }

    public LottoApplication lottoApplication() {
        return new LottoApplication(applicationView(), purchaseLottoUseCase());
    }

    private ApplicationView applicationView() {
        return new ApplicationConsoleView();
    }

    private MessageConverter<Lotto> messageConverter() {
        return new LottoMessageConverter();
    }

    private PurchaseLottoUseCase purchaseLottoUseCase() {
        return new PurchaseLottoService(new LottoFactory(), lottoUserRepository());
    }

    private LottoRepository lottoUserRepository() {
        return InMemoryLottoRepository.getInstance();
    }
}
