package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.model.*;
import lotto.model.enums.Prize;
import lotto.service.LottoMatchService;
import lotto.service.LottoNumberService;
import lotto.service.ProfitService;
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
        generateLotto();
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

    public void generateLotto() {
        OutputView.printLottoTicketMessage(balance.getTicket());
        for (int i = 0; i < balance.getTicket(); i++) {
            user.addLotto(LottoNumberService.createLottoNumbers());
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
                lotto = new Lotto(LottoNumberService.splitLottoNumbers(InputView.inputLottoNumbers()));
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
            int matchCount = LottoMatchService.calculateMatchCount(lotto.getNumbers(), userLotto);
            boolean hasBonusMatch = LottoMatchService.calculateBonusMatch(matchCount, bonus.getNumber(), userLotto);
            user.addResult(Prize.valueOf(matchCount, hasBonusMatch));
        }
    }

    public void calculateProfit() {
        for (Prize prize : user.getResults().keySet()) {
            profit.addProfit(ProfitService.calculateProfit(prize.getPrize(), user.getResults().get(prize)));
        }
    }

    public void calculateProfitRate() {
        profit.setProfitRate(ProfitService.calculateProfitRate(profit.getProfit(), balance.getMoney()));
    }

    public void displayResult() {
        OutputView.printResultMessage();
        for (Prize prize : Prize.values()) {
            OutputView.printResult(prize.getDescription(), prize.getPrize(), user.getResults().get(prize));
        }
        OutputView.printProfitRate(profit.getProfitRate());
    }
}
