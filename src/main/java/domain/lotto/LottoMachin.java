package domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.consumer.Consumer;
import domain.rank.MatchCount;
import io.Input;
import io.InputMessage;
import io.Output;
import io.OutputMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import strategy.LottoMatchCounter;
import strategy.LottoMatchCounterImpl;

public class LottoMachin {

    private final LottoMatchCounter counter = new LottoMatchCounterImpl();

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
                    LottoCondition.COUNT.getConditionNumber()))
            );
        }
        return lottos;
    }

    public void printLottoInfo(Consumer consumer) {
        StringBuilder LottoInfo = new StringBuilder();
        LottoInfo
                .append(InputMessage.NEW_LINE.getInputMessage())
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
        System.out.println(stringBuilder.toString());
    }

    public int getMatchedLottoCount(Lotto purchasedLotto,
                                    Lotto winningNumbers,
                                    int bonusNumber) {

        return counter.count(purchasedLotto, winningNumbers, bonusNumber);
    }

    private StringBuilder generateLottoResultStringFrom(Map<MatchCount, Integer> checkedLottoResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<MatchCount, Integer> entrySet : checkedLottoResult.entrySet()) {
            stringBuilder.append(entrySet.getKey().getOutputMessage());
            stringBuilder.append(OutputMessage.DASH_SEPERATOR.getOutputMessage());
            stringBuilder.append(entrySet.getValue());
            stringBuilder.append(OutputMessage.COUNT_UNIT.getOutputMessage());
            stringBuilder.append(OutputMessage.NEW_LINE.getOutputMessage());
        }
        return stringBuilder;
    }
    // TODO : 수익률을 계산한다.

    // TODO : 수익률을 출력한다.
}
