package lotto.view;

import static lotto.view.Output.NEW_LINE;
import static lotto.view.Output.OUTPUT_COUNT_OF_PURCHASED_LOTTO;
import static lotto.view.Output.OUTPUT_PROFIT;
import static lotto.view.Output.OUTPUT_STATISTICS_RESULT;
import static lotto.view.Output.OUTPUT_STATISTICS_RESULT_WITH_BONUS;

import lotto.domain.lotto.dto.GetLottoDto;
import lotto.domain.lotto.dto.GetLottosDto;
import lotto.domain.lottoMachine.Rank;
import lotto.domain.lottoMachine.dto.GetResultDto;
import lotto.domain.money.dto.GetProfitRateDto;

public class OutputView {

    public void printMessage(final Output output) {
        System.out.println(output.message);
    }

    public void printLottos(GetLottosDto getLottosDto) {
        System.out.printf(NEW_LINE.message + OUTPUT_COUNT_OF_PURCHASED_LOTTO.message + NEW_LINE.message,
                getLottosDto.GetLottoDtos().size());

        getLottosDto.GetLottoDtos().forEach(this::printLotto);
        System.out.print(NEW_LINE.message);
    }

    private void printLotto(GetLottoDto getLottoDto) {
        System.out.println(getLottoDto.lotto());
    }

    public void printResult(GetResultDto getResultDto) {
        Rank.getRanks().forEach(rank -> {
            String rankMessage = rankMessageFormat(rank);

            System.out.printf(rankMessage, rank.getMatchCount(), rank.getReward(),
                    getResultDto.result().getOrDefault(rank, 0));

            System.out.print(NEW_LINE.message);
        });
    }

    private String rankMessageFormat(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return OUTPUT_STATISTICS_RESULT_WITH_BONUS.message;
        }
        return OUTPUT_STATISTICS_RESULT.message;
    }

    public void printProfitRate(GetProfitRateDto getProfitRateDto) {
        System.out.printf(OUTPUT_PROFIT.message, getProfitRateDto.profitRate());
    }
}
