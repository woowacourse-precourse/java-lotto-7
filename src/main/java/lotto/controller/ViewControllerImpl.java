package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Winning;
import lotto.repository.LottoRepository;
import lotto.util.ExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ViewControllerImpl implements ViewController {
    private static ViewControllerImpl viewController;
    private static OutputView outputView = OutputView.getInstance();
    private static InputView inputView = InputView.getInstance();

    public static ViewControllerImpl getInstance() {
        if (viewController == null) {
            viewController = new ViewControllerImpl();
        }
        return viewController;
    }


    @Override
    public Integer validateMoney(int money) {
        int lottoCount = money % 1000;
        if (lottoCount != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_NUMBER_ERROR);
        }
        return money / 1000;
    }

    @Override
    public void validateNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_SIZE_ERROR);
        }
    }

    public List<Integer> parsingWinningNumbers(String number) {
        String[] split = number.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s : split) {
            winningNumbers.add(Integer.parseInt(s.trim()));
        }
        return winningNumbers;
    }

    public Integer getMoney() {
        outputView.printGuide();
        String money = inputView.readLine();
        return this.validateMoney(Integer.parseInt(money));
    }

    public void showNumber(Integer lottoCount) {
        outputView.printCount(lottoCount);
        outputView.printLottoNumber();
    }

    public List<Integer> getWinningNumber() {
        outputView.printWinningNumber();
        List<Integer> winningNumbers = this.parsingWinningNumbers(inputView.readLine());
        validateNumberSize(winningNumbers);
        return winningNumbers;
    }

    public void getBonus() {
        outputView.printBonus();
        int bonus = Integer.parseInt(inputView.readLine());
        LottoRepository.bonus = bonus;
    }

    public void printWinning(List<Winning> winnings) {
        outputView.printWinning(winnings);
    }

    public void printRevenue(Double revenue) {
        outputView.printRevenue(revenue);
    }
}
