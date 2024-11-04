package lotto.view;

import lotto.dto.LottoResultMessageDto;

public class LottoResultView implements View {

    private static final String LOTTO_RESULT_OUTPUT_HEADLINE = "%n당첨 통계%n---%n";
    private static final String LOTTO_WINNING_RATE_OUTPUT_HEADLINE = "총 수익률은 %s%%입니다.";
    private final LottoResultMessageDto lottoResultMessageDtoDto;

    public LottoResultView(LottoResultMessageDto lottoResultMessageDtoDto) {
        this.lottoResultMessageDtoDto = lottoResultMessageDtoDto;
    }

    private void showHeadLine() {
        System.out.printf(LOTTO_RESULT_OUTPUT_HEADLINE);
    }

    @Override
    public String display() {
        showHeadLine();
        System.out.printf(lottoResultMessageDtoDto.getResultMessage());
        System.out.printf(LOTTO_WINNING_RATE_OUTPUT_HEADLINE, lottoResultMessageDtoDto.getWinningRate());
        return "";
    }
}
