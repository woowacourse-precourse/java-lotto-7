package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.GameService;
import lotto.view.InputView;

public class GameController {
    private final GameService gameService = new GameService();


    public Money getPurchaseMoney(){
        InputView.requestPurchaseMoney();
        return new Money(Integer.parseInt(Console.readLine()));
    }

    public Lotto getWinningLotto(){
        InputView.requestWinningNumber();
        String winningNumber = Console.readLine();
        List<Integer> lottoNumbers = Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .toList();
        return new Lotto(lottoNumbers);
    }

    public int getBonusBall(){
        InputView.requestBonusNumber();
        String bonusBall = Console.readLine();
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusBall);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ ERROR ] 숫자를 입력해주세요");
        }
        return bonusNumber;
    }

}
