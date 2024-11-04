package lotto.adapters.output.cli;

import lotto.application.dto.response.EvaluateWinningLottoResponse;
import lotto.application.dto.response.PurchaseLottoResponse;
import lotto.application.dto.response.Response;
import lotto.application.port.output.OutputPort;
import lotto.infrastructure.format.LottoFormatter;

public class CliOutputAdapter implements OutputPort {

    private final LottoFormatter lottoFormatter;

    public CliOutputAdapter(LottoFormatter lottoFormatter) {
        this.lottoFormatter = lottoFormatter;
    }

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void writeNewline() {
        System.out.println();
    }

    @Override
    public void writeResponse(Response response) {
        if (response instanceof PurchaseLottoResponse) {
            System.out.println(lottoFormatter.format(((PurchaseLottoResponse) response)));
            return;
        }

        if (response instanceof EvaluateWinningLottoResponse) {
            System.out.println(lottoFormatter.format(((EvaluateWinningLottoResponse) response)));
            return;
        }

        System.out.println(response);
    }
}
