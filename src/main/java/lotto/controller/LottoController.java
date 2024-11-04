package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.model.*;
import lotto.model.enums.Prize;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Balance balance;
    private Profit profit;
    private Bonus bonus;
    private Lotto lotto;
    private final User user;

    public LottoController() {
        this.profit = new Profit();
        this.user = new User();
    }

    public void run() {
        insertMoney();
        calculateLotto();
        setLottoNumbers();
        setBonusNumber();
        calculateLottoResults();
        calculateProfit();
        calculateProfitRate();
        displayResult();
    }

    public void insertMoney() {
        boolean isValid = false;
        while (!isValid) {
            try {
                OutputView.printInsertMoney();
                balance = new Balance(InputView.inputMoney());
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public void calculateLotto() {
        OutputView.printLottoTicketMessage(balance.getTicket());
        for (int i = 0; i < balance.getTicket(); i++) {
            user.addLotto(LottoService.createLottoNumbers());
            List<Integer> sortedNumbers = new ArrayList<>(user.getLottos().get(i));
            Collections.sort(sortedNumbers);
            OutputView.printLottoNumbers(sortedNumbers);
        }
    }

    public void setLottoNumbers() {
        boolean isValid = false;
        while (!isValid) {
            try {
                OutputView.printLottoNumbersGuide();
                lotto = new Lotto(LottoService.splitLottoNumbers(InputView.inputLottoNumbers()));
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public void setBonusNumber() {
        boolean isValid = false;
        while (!isValid) {
            try {
                OutputView.printBonusNumber();
                bonus = new Bonus(InputView.inputBonusNumber(), lotto.getNumbers());
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public void calculateLottoResults() {
        for (List<Integer> userLotto : user.getLottos()) {
            int matchCount = LottoService.calculateMatchCount(lotto.getNumbers(), userLotto);
            boolean hasBonusMatch = LottoService.calculateBonusMatch(matchCount, bonus.getNumber(), userLotto);
            user.addResult(Prize.valueOf(matchCount, hasBonusMatch));
        }
    }

    public void calculateProfit() {
        for (Prize prize : user.getResults().keySet()) {
            profit.addProfit(LottoService.calculateProfit(prize.getPrize(), user.getResults().get(prize)));
        }
    }

    public void calculateProfitRate() {
        profit.setProfitRate(LottoService.calculateProfitRate(profit.getProfit(), balance.getMoney()));
    }

    public void displayResult() {
        OutputView.printResultMessage();
        for (Prize prize : Prize.values()) {
            OutputView.printResult(prize.getDescription(), prize.getPrize(), user.getResults().get(prize));
        }
        OutputView.printProfitRate(profit.getProfitRate());
    }
}
