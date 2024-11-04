package lotto.service;

import static lotto.constant.Number.FIFTH_BONUS_PRIZE_MONEY;
import static lotto.constant.Number.FIFTH_PRIZE_MONEY;
import static lotto.constant.Number.FOURTH_PRIZE_MONEY;
import static lotto.constant.Number.SIXTH_PRIZE_MONEY;
import static lotto.constant.Number.THIRD_PRIZE_MONEY;
import static lotto.domain.PrizeCount.getPrizeCount;
import static lotto.domain.UserLotto.getLottoMoneyCount;
import static lotto.view.InputView.getPrintInputPurchaseMessage;
import static lotto.view.OutputView.getPrintTotalInvestment;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.PrizeNumbers;
import lotto.exception.ExceptionCode;

public class LottoCalculateService {

    public void inputMoney(){
        getPrintInputPurchaseMessage();
        LottoCreateService.createUserLotto(moneyCalculate(Console.readLine()));
    }

    private Integer moneyCalculate(String money){
        System.out.println(" ");
        try {
            Integer parsedMoney = Integer.valueOf(money);

            if (parsedMoney % 1000 != 0) {
                throw new IllegalArgumentException(ExceptionCode.INVALID_MONEY_PRICE.getMessage());
            }

            return parsedMoney / 1000;
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException(ExceptionCode.INVALID_MONEY_TYPE.getMessage());
        }
    }

    public static HashMap<Boolean, Integer> calculateLottoPrize(List<Integer> userLotto, PrizeNumbers prizeNumbers) {
        HashMap<Boolean, Integer> validateBonus = new HashMap<>();

        validateBonus.put(userLotto.contains(prizeNumbers.getBonus()), calculateMatchedSet(userLotto,prizeNumbers).size());

        return validateBonus;
    }

    private static Set<Integer> calculateMatchedSet(List<Integer> userLotto, PrizeNumbers prizeNumbers){
        Set<Integer> userLottos = new HashSet<>(userLotto);
        Set<Integer> prizeLottos = new HashSet<>(prizeNumbers.getPrizeLotto().getNumbers());

        userLottos.retainAll(prizeLottos);

        return userLottos;
    }




}
