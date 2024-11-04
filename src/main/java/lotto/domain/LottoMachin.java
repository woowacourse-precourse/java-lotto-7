package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.domain.rank.MatchCount;
import lotto.io.Input;
import lotto.io.InputMessage;
import lotto.io.Output;
import lotto.io.OutputMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.strategy.LottoMatchCounter;
import lotto.strategy.LottoMatchCounterImpl;

public class LottoMachin {
    private static final int PERCENTAGE_MULTIPLIER = 100;
    private static final int ROUNDING_SCALE = 10;
    private static final Long INIT_TOTAL_MONEY = 0L;
    private static LottoMachin instance;
    private final LottoMatchCounter counter;

    private LottoMachin() {
        counter = new LottoMatchCounterImpl();
    }

    public static LottoMachin getMachine() {
        if (instance == null) {
            instance = new LottoMachin();
        }
        return instance;
    }

    public void sellTo(Consumer consumer) {
        int quantity = consumer.getQuantityPurchaseLottoBy(Input.getMoneyForPurchaseLotto());
        List<Lotto> generatedLotto = generateLottoBy(quantity);
        consumer.receiveLottoTicket(generatedLotto);
    }

    private List<Lotto> generateLottoBy(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    LottoCondition.START_INCLUSIVE.getConditionNumber(),
                    LottoCondition.END_INCLUSIVE.getConditionNumber(),
                    LottoCondition.MAX_COUNT.getConditionNumber()))
            );
        }
        return lottos;
    }

    public void printLottoInfo(Consumer consumer) {
        StringBuilder LottoInfo = new StringBuilder();
        LottoInfo.append(InputMessage.NEW_LINE.getInputMessage())
                .append(consumer.getPurchasedLottoCount())
                .append(InputMessage.PURCHASE_LOTTO_COUNT.getInputMessage());

        Output.println(LottoInfo.toString());
        consumer.printPurchasedLottos();
    }

    public void inputWinningNumbersTo(Consumer consumer) {
        Output.println(OutputMessage.ENTER_WINNER_NUMBERS.getOutputMessage());
        Lotto selectWinnerLotto = Input.inputWinningNumbers(Console.readLine());
        consumer.selectWinnerNumbers(selectWinnerLotto);
    }

    public void inputBonusNumbersTo(Consumer consumer) {
        Output.println(OutputMessage.ENTER_BONUS_NUMBER.getOutputMessage());
        int selectedBonusNumber = Input.inputBonusNumber(Console.readLine());
        consumer.selectBonusNumber(selectedBonusNumber);
    }

    public void printLottoWinningResult(Consumer consumer) {
        Output.println(OutputMessage.WINNING_STATISTICS.getOutputMessage());
        Map<MatchCount, Integer> checkedLottoResult = consumer.getCheckLottoResultBy(this);
        StringBuilder stringBuilder = generateLottoResultStringFrom(checkedLottoResult);
        stringBuilder.append(printCalculateRateAs(checkedLottoResult, consumer.getPurchasedLottoCount()));
        Output.println(stringBuilder.toString());
    }

    public int getMatchedLottoCount(Lotto purchasedLotto,
                                    Lotto winningNumbers,
                                    int bonusNumber) {

        return counter.count(purchasedLotto, winningNumbers, bonusNumber);
    }

    private StringBuilder generateLottoResultStringFrom(Map<MatchCount, Integer> checkedLottoResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<MatchCount, Integer> entrySet : checkedLottoResult.entrySet()) {
            stringBuilder.append(entrySet.getKey().getOutputMessage())
                    .append(OutputMessage.DASH_SEPERATOR.getOutputMessage())
                    .append(entrySet.getValue())
                    .append(OutputMessage.COUNT_UNIT.getOutputMessage())
                    .append(OutputMessage.NEW_LINE.getOutputMessage());
        }
        return stringBuilder;
    }

    private StringBuilder printCalculateRateAs(Map<MatchCount, Integer> matchCountResult, int purchasedLottoCount) {
        StringBuilder stringBuilder = new StringBuilder();
        Long priceTotal = calculatePriceTotalAs(matchCountResult);
        stringBuilder.append(OutputMessage.TOTAL_RATE_MESSAGE.getOutputMessage())
                .append(calculateRounded(priceTotal, purchasedLottoCount))
                .append(OutputMessage.PERCENTAGE_SYMBOL.getOutputMessage());
        return stringBuilder;
    }

    private Long calculatePriceTotalAs(Map<MatchCount, Integer> matchCountResult) {
        Long totalPrice = INIT_TOTAL_MONEY;
        totalPrice = matchCountResult.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .mapToLong(value -> value.getKey().getPriceMoney() * value.getValue())
                .sum();
        return totalPrice;
    }

    // ((총 수익률) / (로또 구매 금액)) * 100
    public static Double calculateRounded(Long priceTotal, int purchasedLottoCount) {
        double result = ((double) priceTotal / (purchasedLottoCount * LottoPrice.LOTTO_PRICE.getPrice()))
                * PERCENTAGE_MULTIPLIER;
        return Math.round(result * ROUNDING_SCALE) / (double) ROUNDING_SCALE;
    }
}
