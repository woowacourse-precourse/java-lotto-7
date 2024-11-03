package lotto;

public final class LottoConfig {

    private static final LottoConfig INSTANCE = new LottoConfig();

    private LottoConfig() {

    }

    public static LottoConfig getInstance() {
        return INSTANCE;
    }

    public LottoApplication lottoApplication() {
        return new LottoApplication(applicationView());
    }

    public ApplicationView applicationView() {
        return new ApplicationConsoleView();
    }
}
