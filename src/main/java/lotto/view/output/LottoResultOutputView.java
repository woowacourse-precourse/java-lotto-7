package lotto.view.output;

import lotto.dto.LottoResultDto;

public class LottoResultOutputView implements OutputView {
    private static final String LOTTO_RESULT_TITLE = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String MATCHED_COUNT_MESSAGE = "%d개 일치";
    private static final String MATCHED_BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private static final String MATCHED_LOTTO_MESSAGE = " (%,d원) - %d개\n";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private final LottoResultDto lottoResultDto;

    public LottoResultOutputView(LottoResultDto lottoResultDto) {
        this.lottoResultDto = lottoResultDto;
    }

    @Override
    public void print() {
        System.out.println(LOTTO_RESULT_TITLE);
        System.out.println(DIVIDER);

        lottoResultDto.prizes()
                .forEach(p -> {
                    System.out.printf(MATCHED_COUNT_MESSAGE, p.matchCount());

                    if (p.isBonusBallMatched()) {
                        System.out.print(MATCHED_BONUS_BALL_MESSAGE);
                    }
                    System.out.printf(MATCHED_LOTTO_MESSAGE, p.money(), p.numberOfMatchedLotto());
                });
        System.out.printf(RATE_OF_RETURN_MESSAGE, lottoResultDto.rateOfReturn());
    }
}
