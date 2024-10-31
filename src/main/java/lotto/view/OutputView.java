package lotto.view;

import java.text.DecimalFormat;
import java.util.List;

import lotto.dto.LottoDto;
import lotto.dto.LottoNumberListDto;
import lotto.dto.LottoResultDto;
import lotto.model.LottoGrade;

public class OutputView {

    private static final String LOTTO_FORMAT = "%d개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "당첨 통계\n---";
    private static final String BASE_GRADE_FORMAT = "%s개 일치 (%s원) - %d개";
    private static final String SECOND_GRADE_FORMAT = "5개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RETURN_ON_INVESTMENT_FORMAT = "총 수익률은 %.1f%%입니다.";
    private final DecimalFormat formatter = new DecimalFormat("###,###");

    public void printLottos(List<LottoNumberListDto> lottos) {
        System.out.println();
        System.out.printf(LOTTO_FORMAT, lottos.size());
        for (LottoNumberListDto lotto : lottos) {
            System.out.println(lotto.numbers());
        }
    }

    public void printResult(List<LottoResultDto> lottoResults) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        for (LottoResultDto lottoResult : lottoResults) {
            String formattedResult = generateResultFormat(lottoResult);
            System.out.println(formattedResult);
        }
    }

    private String generateResultFormat(LottoResultDto lottoResultDto) {
        String formattedAmount = formatter.format(lottoResultDto.amount());
        if (lottoResultDto.grade() == LottoGrade.SECOND) {
            return String.format(SECOND_GRADE_FORMAT, formattedAmount, lottoResultDto.winningCount());
        }
        return String.format(BASE_GRADE_FORMAT,
                lottoResultDto.correct(),
                formattedAmount,
                lottoResultDto.winningCount());
    }

    public void printReturnOnInvestment(double returnOnInvestment) {
        System.out.printf(RETURN_ON_INVESTMENT_FORMAT, returnOnInvestment);
    }
}