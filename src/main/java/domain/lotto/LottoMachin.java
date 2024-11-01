package domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.consumer.Consumer;
import io.Input;
import io.InputMessage;
import io.Output;
import java.util.ArrayList;
import java.util.List;

public class LottoMachin {

    public void sellTo(Consumer consumer) {
        int quantity = consumer.getQuantityPurchaseLottoBy(Input.getMoneyFoPurchaseLotto());
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
        lottos.forEach(Lotto::sortLottoNumbers);
        return lottos;
    }

    public void printLottoInfo(Consumer consumer) {
        StringBuilder LottoInfo = new StringBuilder();
        LottoInfo
                .append(InputMessage.NEW_LINE.getInputMessage())
                .append(consumer.getPurchasedLottos().size())
                .append(InputMessage.PURCHASE_LOTTO_COUNT.getInputMessage());
        Output.println(LottoInfo.toString());
        consumer.getPurchasedLottos().forEach(Output::println);
    }

    public void inputWinningNumbersTo(Consumer consumer) {
        Lotto selectWinnerLotto = Input.inputWinningNumbers(Console.readLine());
        selectWinnerLotto.sortLottoNumbers();
        consumer.selectWinnerNumbers(selectWinnerLotto);
    }

    public void inputBonusNumbersTo(Consumer consumer) {
        int selectedBonusNumber = Input.inputBonusNumber(Console.readLine());
        consumer.selectBonusNumber(selectedBonusNumber);
    }

    /**
     * 머신은 사용자에게 번호를 입력받는다.
     * 머신은 사용자에게 보너스 번호를 입력받는다.
     */

}
