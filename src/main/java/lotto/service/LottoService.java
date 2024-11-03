package lotto.service;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final LottoResultChecker lottoResultChecker;

    public LottoService(LottoGenerator lottoGenerator, LottoResultChecker lottoResultChecker) {
        this.lottoGenerator = lottoGenerator;
        this.lottoResultChecker = lottoResultChecker;
    }
}
