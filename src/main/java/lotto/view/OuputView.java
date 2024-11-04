package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.WinningResultDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OuputView {
    private static final String LOTTO_COST_PROMPT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_RESULT_HEADER = "당첨 통계\n---";
    private static final String LOTTO_RESULT_FORMAT = """
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개\n
            """;
    private static final String LOTTO_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void displayLottoCostPrompt(){
        System.out.println(LOTTO_COST_PROMPT);
    }

    public void displayLottos(LottosDto lottosDto){
        System.out.printf(LOTTO_COUNT_MESSAGE,lottosDto.lottoCount());

        for(LottoDto lottoDto : lottosDto.lottos()){
            List<Integer> sortedLottoNumbers = new ArrayList<>(lottoDto.numbers());
            Collections.sort(sortedLottoNumbers);
            System.out.println(sortedLottoNumbers);
        }
    }

    public void displayWinningNumbersPrompt(){
        System.out.println(WINNING_NUMBERS_PROMPT);
    }

    public void displayBonusNumberPrompt(){
        System.out.println(BONUS_NUMBER_PROMPT);
    }

    public void displayWinningResult(WinningResultDto winningResultDto){
        System.out.println(LOTTO_RESULT_HEADER);
        System.out.printf(LOTTO_RESULT_FORMAT, winningResultDto.getWinningTypeCounts().toArray());
    }

    public void displayLottoProfitRate(double profitRate){
        System.out.printf(LOTTO_PROFIT_RATE_MESSAGE, profitRate);
    }
}
