package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.dto.LottoBundleDTO;
import lotto.dto.LottoResultDTO;
import lotto.enums.LottoRank;
import lotto.domain.LottoResult;

public class LottoOutputView {
    private static final String LOTTO_PURCHASE_PRICE_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GENERATED_LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String GENERATED_LOTTO_NUMBERS_MESSAGE = "[%s]";
    private static final String GENERATED_LOTTO_NUMBERS_DELIMITER = ", ";
    private static final String LOTTO_WINNING_NUMBERS_REQUEST_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_REQUEST_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String LOTTO_RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String LOTTO_PROFIT_RATE_MESSAGE = "총 수익률은 %s입니다.";
    private static final DecimalFormat PROFIT_RATE_FORMAT = new DecimalFormat("0.0'%'");

    public void printLottoPurchasePrice() {
        System.out.println(LOTTO_PURCHASE_PRICE_REQUEST_MESSAGE);
    }

    public void printLottoWinningNumbers() {
        System.out.println(LOTTO_WINNING_NUMBERS_REQUEST_MESSAGE);
    }

    public void printLottoBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_REQUEST_MESSAGE);
    }

    public void printLottoBundle(LottoBundleDTO lottoBundleDTO) {
        List<Lotto> lottos = lottoBundleDTO.getLottos();
        printLottosCount(lottos.size());
        printLottos(lottos);
    }

    public void printLottoResult(LottoResultDTO lottoResultDTO) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        printLottoRankCount(lottoResultDTO.getLottoRankCount());
        printLottoProfitRate(lottoResultDTO.getLottoProfitRate());
    }

    private void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(this::getLottoNumbersMessage)
                .forEach(System.out::println);
    }

    private void printLottosCount(int lottoCount) {
        System.out.println(String.format(GENERATED_LOTTO_COUNT_MESSAGE, lottoCount));
    }

    private String getLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(GENERATED_LOTTO_NUMBERS_DELIMITER));
    }

    private String getLottoNumbersMessage(Lotto lotto) {
        return String.format(GENERATED_LOTTO_NUMBERS_MESSAGE, getLottoNumbers(lotto));
    }

    private void printLottoRankCount(Map<LottoRank, Integer> lottoRankCount) {
        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.FAIL)
                .map(lottoRank -> String.format(lottoRank.getMessage(), lottoRankCount.get(lottoRank)))
                .forEach(System.out::println);
    }

    private void printLottoProfitRate(double lottoProfitRate) {
        System.out.println(String.format(LOTTO_PROFIT_RATE_MESSAGE, PROFIT_RATE_FORMAT.format(lottoProfitRate)));
    }
}
