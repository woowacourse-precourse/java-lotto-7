package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import lotto.Constants.Message;
import lotto.Domain.GameInfo;
import lotto.Domain.LottoResult;
import lotto.Lotto;
import lotto.Service.LottoResultService;
import lotto.Service.LottoService;
import lotto.Utils.NumberUtils;
import lotto.View.InputView;
import lotto.View.OutputView;

/**
 * 로또 게임을 진행과 유저 입력을 담당하는 컨트롤러 클래스
 */
public class LottoController {
    private static final int PERCENT_MULTIPLIER = 100;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final LottoResultService lottoResultService;
    private GameInfo gameInfo;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
        this.lottoResultService = new LottoResultService();
    }

    public void run() {
        promptPurchaseAmount();
        generateLottoNumbers();
        Lotto winningLotto = getWinningLotto();
        gameInfo.setWinningLotto(winningLotto);
        gameInfo.setBonusNumber(getBonusNumber(winningLotto));
        lottoResultService.checkAllResult(gameInfo);
        printResult();
    }

    /**
     * 사용자로부터 계산금액을 받아 gameInfo 에 저장하는 프로시져
     */
    public void promptPurchaseAmount() {
        getLottoPurchaseAmount();
        int purchasedAmount = gameInfo.getPurchaseAmount();
        int purchasedNumLotto = purchasedAmount / GameInfo.LOTTO_PRICE;
        outputView.print(purchasedNumLotto + Message.PURCHASED_LOTTO.getText());
    }

    /**
     * 로또를 구매하고 게임 정보에 저장하는 프로시져
     */
    private void generateLottoNumbers() {
        while (gameInfo.getRemainingLottoAmount() > 0) {
            Lotto lotto = lottoService.generateLotto(gameInfo);
            outputView.printLotto(lotto);
            gameInfo.addPurchasedLotto(lotto);
        }
    }

    /**
     * 사용자로부터 입력받은 당첨 번호를 반환하는 메서드
     *
     * @return 당첨번호를 담은 리스트
     */
    private List<Integer> getLottoNumbers() {
        String s = promptForInput(Message.LOTTO_NUMBERS.getText());
        return parseLottoNumbers(s);
    }

    private List<Integer> parseLottoNumbers(String s) {
        String[] numbers = s.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : numbers) {
            lottoNumbers.add(NumberUtils.parseStringToInt(number));
        }
        return lottoNumbers;
    }

    /**
     * 사용자로부터 입력받은 당첨 번호를 Lotto 객체로 변환하는 함수
     *
     * @return
     */
    private Lotto getWinningLotto() {
        while (true) {
            try {
                List<Integer> lottoNumbers = getLottoNumbers();
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                handleException(e.getMessage());
            }
        }
    }

    private int getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String s = promptForInput(Message.BONUS_NUMBER.getText());
                int bonusNumber = NumberUtils.parseStringToInt(s);
                winningLotto.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                handleException(e.getMessage());
            }
        }
    }

    private void getLottoPurchaseAmount() {
        while (true) {
            try {
                String s = promptForInput(Message.PURCHASE_AMOUNT.getText());
                int amount = NumberUtils.parseStringToInt(s);
                gameInfo = new GameInfo(amount);
                return ;
            } catch (IllegalArgumentException e) {
                handleException(e.getMessage());
            }
        }
    }

    private String promptForInput(String message) {
        outputView.print(message);
        String s = Console.readLine();
        outputView.print("");
        return s;
    }

    private void printResult() {
        LottoResult lottoResult = lottoResultService.getLottoResult();
        double profitRate = lottoResultService.calculateProfitRate(gameInfo.getPurchaseAmount());
        outputView.printResult( lottoResult, profitRate * PERCENT_MULTIPLIER );
    }

    private void handleException(String message) {
        outputView.print(message);
        inputView.addNumConsecutiveError();
    }
}
