package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.Constants.Error;
import lotto.Constants.Message;
import lotto.Domain.GameInfo;
import lotto.Domain.LottoResult;
import lotto.Lotto;
import lotto.Service.LottoResultService;
import lotto.Service.LottoService;
import lotto.Utils.NumberUtils;
import lotto.View.OutputView;

/**
 * 로또 게임을 진행과 유저 입력을 담당하는 컨트롤러 클래스
 */
public class LottoController {
    private final OutputView outputView;
    private final LottoService lottoService;
    private final LottoResultService lottoResultService;
    private GameInfo gameInfo;

    public LottoController() {
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
     * 사용자로부터 입력을 받아 초기설정을 하는 프로시져
     */
    public void promptPurchaseAmount() {
        int purchaseAmount = getLottoPurchaseAmount();
        outputView.print(purchaseAmount + Message.PURCHASED_LOTTO.getText());
        gameInfo = new GameInfo(purchaseAmount);
    }

    /**
     * 로또를 구매하고 결과를 반환하는 메서드. 구입금액에 따라 로또를 생성하고, 당첨번호와 비교하여 결과를 반환한다.
     *
     * @return 로또 결과
     */
    private void generateLottoNumbers() {
        LottoResultService lottoResultService = new LottoResultService();
        while (gameInfo.getPurchaseAmount() > 0) {
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
        while (true) {
            try {
                String s = promptForInput(Message.LOTTO_NUMBERS.getText());
                return parseLottoNumbers(s);
            } catch (NoSuchElementException e) {
                outputView.print(Error.NO_SUCH_ELEMENT_EXCEPTION.getText());
            }
        }
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
        List<Integer> lottoNumbers = getLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    private int getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String s = promptForInput(Message.BONUS_NUMBER.getText());
                int bonusNumber = NumberUtils.parseStringToInt(s);
                winningLotto.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            } catch (NoSuchElementException e) {
                outputView.print(Error.NO_SUCH_ELEMENT_EXCEPTION.getText());
            }
        }
    }

    private int getLottoPurchaseAmount() {
        while (true) {
            try {
                String s = promptForInput(Message.PURCHASE_AMOUNT.getText());
                int amount = NumberUtils.parseStringToInt(s);
                GameInfo.validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            } catch (NoSuchElementException e) {
                outputView.print(Error.NO_SUCH_ELEMENT_EXCEPTION.getText());
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
        outputView.printResult(lottoResult, profitRate);
    }

}
