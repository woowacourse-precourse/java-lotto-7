package lotto.controller;

import static lotto.common.Consts.INPUT_MESSAGE_BONUS_NUMBER;
import static lotto.common.Consts.INPUT_MESSAGE_PURCHASE_AMOUNT;
import static lotto.common.Consts.INPUT_MESSAGE_WINNING_NUMBER;
import static lotto.common.Consts.OUTPUT_MESSAGE_PURCHASE_COMPLETE;

import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import lotto.application.model.Lotto;
import lotto.application.model.WinningRanking;
import lotto.application.support.LottoInputParser;
import lotto.application.model.Model;
import lotto.application.service.LottoService;
import lotto.application.support.Retryer;
import lotto.common.Consts;
import lotto.view.InputView;
import lotto.view.OutputView;


//TODO: 구매 로직 작성 완료, 로또 당첨 판별 로직 구현 해야 함 (Enum 활용해야 함)
public class LottoController extends AbstractController<String, Model>{

    private final LottoService lottoService;
    private final LottoInputParser parser;

    public LottoController(InputView<String> inputView,
                           OutputView<Model> outputView,
                           LottoService lottoService,
                           LottoInputParser parser) {
        super(inputView, outputView);
        this.lottoService = lottoService;
        this.parser = parser;
    }

    public void run() {
        Set<Lotto> buiedLotto = buyLotto();
        output(buiedLotto, Consts.getPurchaseMessage(buiedLotto.size()));
        setLottoWinningNumber();
        setLottoBonusNumber();
        EnumMap<WinningRanking, Integer> result= getResult(buiedLotto);
        output(result);
        output(lottoService.getProfitRaio(result));
    }

    private Set<Lotto> buyLotto(){
        int amount = retryUntilNoError(this::inputAndParseAmount);

        return lottoService.buyLotto(amount);
    }

    private void setLottoWinningNumber(){
        List<Integer> winningNumber = retryUntilNoError(this::inputAndParseWinningNumber);

        lottoService.setWinningNumbers(winningNumber);
    }

    private void setLottoBonusNumber(){
        int bonusNumber = retryUntilNoError(this::inputAndParseBonusNumber);

        lottoService.setBonusNumber(bonusNumber);
    }

    private EnumMap<WinningRanking, Integer> getResult(Collection<Lotto> lottos){ return lottoService.getResult(lottos); }

    private int inputAndParseAmount(){
        return parser.parseAmount(input(INPUT_MESSAGE_PURCHASE_AMOUNT));
    }

    private List<Integer> inputAndParseWinningNumber(){
        return parser.parseWinningNumber(input(INPUT_MESSAGE_WINNING_NUMBER));
    }

    private int inputAndParseBonusNumber(){
        return parser.parseBonusNumber(input(INPUT_MESSAGE_BONUS_NUMBER));
    }


}
