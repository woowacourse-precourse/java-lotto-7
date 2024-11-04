package lotto.manager;

import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.utils.LottoUtil;
import lotto.views.LottoView;

import java.util.List;

public class LottoManager {

    static User user;
    static WinningLotto winningLotto = new WinningLotto();
    static int[] prize;
    LottoService lottoService = LottoService.getInstance();

    public void runLottoSystem() {
        inputMoneyValue();
        outputUserLottos();
        inputWinningLottos();
        inputBonusNumber();
        calculateLottoPrice();
        calculateProfit();
    }

    public void inputMoneyValue() {
        while (true) {
            try {
                String money = LottoView.inputMoney();
                user = new User(money);
                break;
            } catch (IllegalArgumentException exepction) {
                System.out.println(exepction.getMessage());
            }
        }
    }

    public void outputUserLottos() {
        LottoView.outputBuyLottoNumber(user.getLottos());
    }

    public void inputWinningLottos() {
        while (true) {
            try {
                String inputWiningLottos = LottoView.inputWinningLottoNumber();
                List<Integer> convertLottos = LottoUtil.splitAndParseValue(inputWiningLottos);
                winningLotto.setWinningLotto(convertLottos);
                break;
            } catch (IllegalArgumentException exepction) {
                System.out.println(exepction.getMessage());
            }
        }
    }

    public void inputBonusNumber() {
        while (true) {
            try {
                String inputBonusNumber = LottoView.inputBonusNumber();
                winningLotto.setBonusNumber(inputBonusNumber);
                break;
            } catch (IllegalArgumentException exepction) {
                System.out.println(exepction.getMessage());
            }
        }
    }

    public void calculateLottoPrice() {

        prize = lottoService.calculateLottoResult(user, winningLotto);
        for (int price = 5; price >= 1; price--) {
            LottoView.outputLottoResult(price, prize[price]);
        }
    }

    public void calculateProfit() {
        double totalProfit = (double) lottoService.getTotalProfit(prize);
        double profit = (totalProfit / user.getMoney()) * 100;
        LottoView.outputProfit(profit);
    }

}
