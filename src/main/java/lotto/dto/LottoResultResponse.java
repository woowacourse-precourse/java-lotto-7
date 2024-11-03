package lotto.dto;

import lotto.model.LottoRank;
import lotto.model.LottoResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record LottoResultResponse(
        List<String> lottoResultResponse
) {
    public static final String LOTTO_RESULT_RESPONSE_FORMAT = "%s - %d개";

    public static LottoResultResponse from(LottoResult lottoResult) {
        List<String> lottoResultResponse = Stream.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)
                .map(rank -> String.format(LOTTO_RESULT_RESPONSE_FORMAT, rank.getDescription(), lottoResult.getLottoResults(rank)))
                .collect(Collectors.toList());

        return new LottoResultResponse(lottoResultResponse);
    }
}
