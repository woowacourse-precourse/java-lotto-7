package lotto.common.config;

import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoService;
import lotto.domain.matcher.LottoTicketMatcher;
import lotto.domain.ticket.LottoTicketCreator;
import lotto.infrastructures.RandomLottoGenerator;
import lotto.interfaces.input.InputHandler;
import lotto.interfaces.lotto.LottoController;
import lotto.interfaces.output.OutputHandler;

public class LottoConfig {

    public LottoController provideLottoController() {
        LottoTicketCreator lottoTicketCreator = provideLottoTicketCreator();
        LottoTicketMatcher lottoTicketMatcher = new LottoTicketMatcher();
        LottoService lottoService = new LottoService(lottoTicketCreator, lottoTicketMatcher);
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        return new LottoController(lottoService, inputHandler, outputHandler);
    }

    private LottoTicketCreator provideLottoTicketCreator() {
        LottoGenerator lottoGenerator = provideLottoGenerator();
        return new LottoTicketCreator(lottoGenerator);
    }

    private LottoGenerator provideLottoGenerator() {
        LottoCreator lottoCreator = new LottoCreator();
        return new RandomLottoGenerator(lottoCreator);
    }

}
