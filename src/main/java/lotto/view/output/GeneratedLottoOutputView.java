package lotto.view.output;

import lotto.dto.LottoDto;

public class GeneratedLottoOutputView implements OutputView {

    private final LottoDto lottoDto;

    public GeneratedLottoOutputView(LottoDto lottoDto) {
        this.lottoDto = lottoDto;
    }

    @Override
    public void print() {
        System.out.println();
        System.out.println(lottoDto.count() + "개를 구매했습니다.");
        lottoDto.lottos().forEach(numbers ->
                System.out.println("[" + numbers + "]"));
        System.out.println();
    }
}
