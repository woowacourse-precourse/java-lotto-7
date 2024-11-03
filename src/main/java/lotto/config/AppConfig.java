package lotto.config;

import lotto.controller.LottoController;
import lotto.repository.MemoryRepository;
import lotto.repository.Repository;
import lotto.servcie.LottoService;
import lotto.servcie.LottoServiceImpl;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

/** 설정한 클래스 구현체를 바탕으로 클래스를 생성해서 반환한다. */
public final class AppConfig {
    
    private Repository getRepository() {
        return new MemoryRepository();
    }
    
    private OutputView getOutputView() {
        return new ConsoleOutputView();
    }
    
    private InputView getInputView() {
        return new ConsoleInputView();
    }
    
    private LottoService getLottoService() {
        return new LottoServiceImpl(getRepository());
    }
    
    public LottoController getLottoController() {
        return new LottoController(getInputView(), getOutputView(), getLottoService());
    }
    
}
