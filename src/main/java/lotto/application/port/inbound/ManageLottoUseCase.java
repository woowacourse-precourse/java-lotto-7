package lotto.application.port.inbound;

import lotto.application.dto.request.ManageLottoRequest;
import lotto.application.dto.response.ManageLottoResponse;

public interface ManageLottoUseCase {
    ManageLottoResponse getResult(ManageLottoRequest request);
}
