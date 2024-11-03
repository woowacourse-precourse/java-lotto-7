package lotto.controller;

import lotto.model.*;
import lotto.model.winlotto.BasicWinLottoNumbers;
import lotto.model.winlotto.BonusWinLottoNumber;
import lotto.model.outcome.LottoResult;
import lotto.model.condition.SpendingMoney;
import lotto.model.winlotto.WinLotto;
import lotto.servcie.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

/**
 * view로부터 입력값을 받아서 주요 모델을 생성하고, 입력값이 잘못되어서 예외가
 * 호출되면 예외메시지를 출력한 후 다시 입력받는다. 만든 주요 모델을 service에
 * 전달한다. 저장된 결과 값을 요청하여 view에 전달한다.
 */
public class LottoController {
    
    private final InputView inputView;
    
    private final OutputView outputView;
    
    private final LottoService service;
    
    
    public LottoController(InputView inputView, OutputView outputView, LottoService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }
    
    public void run() {
        SpendingMoney money = getSpendMoney();
        
        service.buyLotto(money);
        BoughtLottos boughtLottos = service.getLottos();
        outputView.printLottos(boughtLottos);
        
        BasicWinLottoNumbers winLottoNumbers = getWinLottoNumbers();
        BonusWinLottoNumber bonusNumber = getBonusWinLottoNumber(winLottoNumbers);
        WinLotto winLotto = new WinLotto(winLottoNumbers, bonusNumber);
        
        service.createWinStatistics(boughtLottos, winLotto);
        LottoResult result = service.getResult();
        
        outputView.printResult(result);
    }
    
    private SpendingMoney getSpendMoney() {
        while (true) {
            try {
                return new SpendingMoney(inputView.getBuyingMoney());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private BonusWinLottoNumber getBonusWinLottoNumber(BasicWinLottoNumbers winLottoNumbers) {
        while (true) {
            try {
                return new BonusWinLottoNumber(inputView.getBonusNumber(), winLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private BasicWinLottoNumbers getWinLottoNumbers() {
        while (true) {
            try {
                return new BasicWinLottoNumbers(inputView.getWinNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
    }
    
}
