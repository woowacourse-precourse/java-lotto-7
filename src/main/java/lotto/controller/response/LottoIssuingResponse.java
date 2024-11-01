package lotto.controller.response;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public record LottoIssuingResponse(
        int quantity,
        List<LottoDto> lottoTickets
) {
    public static LottoIssuingResponse from(List<Lotto> lottoTickets) {
        return new LottoIssuingResponse(
                lottoTickets.size(),
                lottoTickets.stream()
                        .map(LottoDto::from)
                        .toList()
        );
    }

    public record LottoDto(
            List<Integer> lotto
    ) {
        public static LottoDto from(Lotto lotto) {
            return new LottoDto(
                    lotto.numbers().stream()
                            .map(LottoNumber::number)
                            .toList()
            );
        }
    }
}
