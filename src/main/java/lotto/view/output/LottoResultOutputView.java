package lotto.view.output;

import lotto.dto.LottoResultDto;

public class LottoResultOutputView implements OutputView {

    private final LottoResultDto lottoResultDto;

    public LottoResultOutputView(LottoResultDto lottoResultDto) {
        this.lottoResultDto = lottoResultDto;
    }

    @Override
    public void print() {
        System.out.println("당첨 통계");
        System.out.println("---");

        lottoResultDto.prizes()
                .forEach(p -> {
                    System.out.print(p.matchCount() + "개 일치");

                    if (p.isBonusBallMatched()) {
                        System.out.print(", 보너스 볼 일치");
                    }
                    String money = String.format("%,d", p.money());
                    System.out.println(" (" + money + "원) - " + p.numberOfMatchedLotto() + "개");
                });
        System.out.println("총 수익률은 " + lottoResultDto.rateOfReturn() + "%입니다.");
    }
}
