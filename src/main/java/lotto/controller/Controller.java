package lotto.controller;

import lotto.Service.ParsingService;
import lotto.Service.PublishLottoService;
import lotto.Service.ValidService;
import lotto.Service.WinningPrizeService;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

public class Controller {
    private final ValidService validService = new ValidService();
    private final ParsingService parsingService = new ParsingService();
    private final User user1 = new User();
    private WinningLotto winningLotto;
    private final WinningPrizeService winningPrizeService = new WinningPrizeService();


    public void start() {
        setMoney();
        buyLotto(parsingService.getMoney(), user1); //현재 문제상황
        displayLottos(user1);
        setWinningLotto();
        winningPrizeService.matchAllLotos(user1.getLottos(),winningLotto.getWinningLotto(),winningLotto.getBonusNumber());
        System.out.println(winningPrizeService.getWinningPrizes().toString());

    }

    private void setMoney() {
        while (true) {
            String money = promptMoney();
            try {
                validMoney(money);
                parsingService.setMoney(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String promptMoney() {
        Output.requestPurchaseAmount();
        return Input.getInput();
    }

    private void validMoney(String money) {
        validService.checkNull(money);
        validService.checkBig(money);
        validService.checkNum(money);
        validService.check1000s(money);
    }

    private void buyLotto(int money, User user) {
        int published_lotto_count = money / 1000;
        for (int count = 1; count <= published_lotto_count; count++) {
            Lotto lotto = PublishLottoService.publishLotto();
            user.addLotto(lotto);
        }
    }

    private void displayLottos(User user) {
        Output.requestHowManyLottos(parsingService.getMoney());
        for (Lotto lotto : user.getLottos()) {
            Output.requestLottoNumbers(lotto.getNumbers());
        }
    }

    private void getWinningLottoNumbers() {
        while (true) {
            String winningNumbers = promptWinningNumber();
            try {
                validService.checkLottoNumbers(winningNumbers);
                parsingService.parseNumbers(winningNumbers);
                validService.checkDuplicatedLottoNumbers(parsingService.getWinningNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String promptWinningNumber() {
        Output.requestWinningNumbers();
        return Input.getInput();
    }

    private void setBonusNumber() {
        while (true) {
            String stringBonusNumber = promptBonusNumber();
            try {
                validService.checkBonusNumber(stringBonusNumber);
                parsingService.parseBonusNumbers(stringBonusNumber);
                validService.checkDuplicatedBonusNumber(parsingService.getBonusNumber(), parsingService.getWinningNumbers());
                winningLotto = new WinningLotto(parsingService.getBonusNumber(), parsingService.getWinningNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String promptBonusNumber() {
        Output.requestBonusNumber();
        return Input.getInput();
    }

    private void setWinningLotto() {
        getWinningLottoNumbers();
        setBonusNumber();
    }


}
