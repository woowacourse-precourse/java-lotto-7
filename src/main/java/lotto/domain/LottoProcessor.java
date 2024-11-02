package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.calculator.Calculator;
import lotto.domain.lottoGeneratir.LottoGenerator;
import lotto.dto.Lotto;
import lotto.dto.Receipt;
import lotto.utils.LottoMessages;
import lotto.utils.NumberConstants;

public class LottoProcessor {
    private Calculator calculator;
    private LottoDrawer lottoDrawer;
    private LottoGenerator lottoGenerator;
    private LottoBuyer lottoBuyer;
    private int numberOfLotto;
    private List<Lotto> lottos;
    public LottoProcessor(Calculator calculator, LottoDrawer lottoDrawer, LottoGenerator lottoGenerator, LottoBuyer lottoBuyer){
        this.calculator = calculator;
        this.lottoDrawer = lottoDrawer;
        this.lottoGenerator = lottoGenerator;
        this.lottoBuyer = lottoBuyer;
    }

    public void purchaseProcess(int money) {
        printLottoCount(money);
    }

    private void printLottoCount(int money) {
        numberOfLotto = calculator.calculate(money);
        String message = Stream.of(numberOfLotto, LottoMessages.PURCHASED_LOTTO_COUNT.getMessage())
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        System.out.println(message);
    }

    public void createLotto(){
        lottos = new ArrayList<>();

        for(int i = 0; i < numberOfLotto; i++){
            lottos.add(createLottoFromRandom());
        }
    }

    private Lotto createLottoFromRandom(){
        return lottoGenerator.generateLotto(lottoDrawer.drawRandomNumbers());
    }

    public void providePurchaseResult() {
        lottoBuyer.receiveReceipt(new Receipt(numberOfLotto * NumberConstants.LOTTO_PRICE.getNumber()));
        lottoBuyer.receiveLottos(lottos);
    }
}
