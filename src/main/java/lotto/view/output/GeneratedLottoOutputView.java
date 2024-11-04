package lotto.view.output;

import lotto.dto.LottoDto;

public class GeneratedLottoOutputView implements OutputView {
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBERS_MESSAGE = "[%s]\n";
    private final LottoDto lottoDto;

    public GeneratedLottoOutputView(LottoDto lottoDto) {
        this.lottoDto = lottoDto;
    }

    @Override
    public void print() {
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE, lottoDto.count());
        lottoDto.lottos()
                .forEach(numbers ->
                        System.out.printf(LOTTO_NUMBERS_MESSAGE, numbers));
        System.out.println();
    }
}
