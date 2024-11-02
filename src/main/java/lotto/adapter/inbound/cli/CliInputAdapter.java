package lotto.adapter.inbound.cli;

import lotto.application.dto.request.ManageLottoRequest;
import lotto.application.dto.response.ManageLottoResponse;
import lotto.application.port.inbound.CreateLottoUseCase;
import lotto.application.port.inbound.InputAdapter;
import lotto.application.port.inbound.InputPort;
import lotto.application.port.inbound.ManageLottoUseCase;
import lotto.application.port.outbound.OutputPort;
import lotto.application.validator.LottoInputValidator;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.cost.Cost;
import lotto.domain.rank.RankResult;
import lotto.domain.rank.vo.RevenueRate;
import lotto.infrastructure.constant.PromptMessage;

import java.util.List;

public class CliInputAdapter implements InputAdapter {
    private final ManageLottoUseCase manageLottoUseCase;
    private final CreateLottoUseCase createLottoUseCase;
    private final OutputPort outputPort;
    private final InputPort inputPort;
    private final LottoInputValidator lottoInputValidator;

    public CliInputAdapter(ManageLottoUseCase manageLottoUseCase,
                           CreateLottoUseCase createLottoUseCase,
                           OutputPort outputPort, InputPort inputPort,
                           LottoInputValidator lottoInputValidator) {
        this.manageLottoUseCase = manageLottoUseCase;
        this.createLottoUseCase = createLottoUseCase;
        this.outputPort = outputPort;
        this.inputPort = inputPort;
        this.lottoInputValidator = lottoInputValidator;
    }

    @Override
    public void run() {
        Cost cost = getCost();
        int count = cost.getPurchaseCount();

        List<Lotto> lottos = createLottoUseCase.create(count);
        writeInfo(count, lottos);

        WinningLotto winningLotto = getWinningLotto();

        ManageLottoRequest request = new ManageLottoRequest(cost, lottos, winningLotto);
        ManageLottoResponse response = manageLottoUseCase.getResult(request);

        writeResult(response.rankResult(), response.revenueRate());
    }

    private Cost getCost() {
        while (true) {
            try {
                outputPort.writeMessage(PromptMessage.COST_INPUT);
                return lottoInputValidator.validateCost(inputPort.get());
            } catch (IllegalArgumentException e) {
                outputPort.writeMessage(e.getMessage());
            }
        }
    }

    private WinningLotto getWinningLotto() {
        while (true) {
            try {
                outputPort.writeMessage(PromptMessage.WINNING_NUMBERS_INPUT);
                String winningInput = inputPort.get();
                outputPort.writeMessage(PromptMessage.BONUS_NUMBER_INPUT);
                String bonusInput = inputPort.get();
                return lottoInputValidator.validateWinningLotto(winningInput, bonusInput);
            } catch (IllegalArgumentException e) {
                outputPort.writeMessage(e.getMessage());
            }
        }
    }

    private void writeInfo(int count, List<Lotto> lottos) {
        outputPort.writeMessage(PromptMessage.PURCHASE_COUNT_OUTPUT(count));
        final StringBuffer stringBuffer = new StringBuffer();
        lottos.forEach(lotto -> {
            stringBuffer.append(lotto.toString()).append('\n');
        });
        outputPort.writeMessage(stringBuffer.toString());
    }

    private void writeResult(RankResult rankResult, RevenueRate rate) {
        outputPort.writeMessage(PromptMessage.RESULT_OUTPUT);
        outputPort.writeMessage(rankResult.toString());
        outputPort.writeMessage(PromptMessage.REVENUE_RATE_OUTPUT(rate.toString()));
    }
}
