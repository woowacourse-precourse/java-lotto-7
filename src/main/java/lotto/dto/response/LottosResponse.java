package lotto.dto.response;

import java.util.List;

import lotto.domain.lotto.Lotto;

public record LottosResponse(
    List<InnerLottoResponse> lottos
) {

    public static LottosResponse of(List<Lotto> lottoNumbers) {
        return new LottosResponse(
            lottoNumbers.stream()
                .map(lotto -> new InnerLottoResponse(lotto.getNumbers()))
                .toList()
        );
    }

    public record InnerLottoResponse(
        List<Integer> numbers
    ) {

        private static InnerLottoResponse of(List<Integer> numbers) {
            return new InnerLottoResponse(numbers);
        }
    }
}
