package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.WinningRank;
import lotto.dto.WinningNumbersDto;
import lotto.dto.WinningResultsDto;
import lotto.model.Bonus;
import lotto.model.Buy;
import lotto.model.Lotto;
import lotto.model.ProfitRate;
import lotto.model.Winning;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void startLotto(){
        Integer userPurchasePrice = getUserPurchasePrice();
        Integer userPurchseCount = getUserPurchaseCount(userPurchasePrice);
        Lotto lotto = getUserNumbers();
        Integer bonusNumber = getBonusNumber(lotto);
        Winning winning = new Winning(userPurchseCount);

        getWinningNumbers(winning);

        WinningResultsDto winningResultsDto = winning.compareNumbers(lotto.getNumbers(), bonusNumber);

        Map<WinningRank, Integer> result = winning.lottoResult(winningResultsDto);
        Integer totalPurchaseMoney = getTotalPurchaseMoney(result);
        float finalRate = ProfitRate.profitRate(userPurchasePrice, totalPurchaseMoney);
        getFinalResult(result, finalRate);
    }

    private Integer getUserPurchasePrice(){
        while (true) {
            lottoView.showMessage("구입금액을 입력해 주세요.");
            String userInputMoney = lottoView.getUserInput();
            try {
                return getUserPurcharsePrice(userInputMoney);
            } catch (IllegalArgumentException e) {
                lottoView.showMessage(e.getMessage());
            }
        }

    }

    private Integer getUserPurchaseCount(Integer userPurchasePrice){
        while (true) {
            try{
                Buy buy = new Buy(userPurchasePrice);
                Integer purchaseCount = buy.getPurchaseCount();
                lottoView.showMessage(purchaseCount + "개를 구매했습니다.");
                return purchaseCount;
            }catch (IllegalArgumentException e){
                lottoView.showMessage(e.getMessage());
                userPurchasePrice = getUserPurchasePrice();
            }
        }

    }

    private Lotto getUserNumbers(){
        while (true) {
            try {
                lottoView.showMessage("당첨 번호를 입력해 주세요.");
                String userInputNumbers = lottoView.getUserInput();
                List<Integer> userNumbers = setUserNumbers(userInputNumbers);
                return  new Lotto(userNumbers);
            }catch (IllegalArgumentException e){
                lottoView.showMessage(e.getMessage());
            }
        }
    }

    private Integer getBonusNumber(Lotto lotto){
        while (true) {
            try {
                lottoView.showMessage("보너스 번호를 입력해 주세요.");
                String userInputBonus = lottoView.getUserInput();
                int userBonusNumber = splitNumber(userInputBonus);
                Bonus bonus = new Bonus(lotto,userBonusNumber);
                return bonus.getBonusNumber();
            }catch (IllegalArgumentException e){
                lottoView.showMessage(e.getMessage());
            }
        }
    }

    private void getWinningNumbers(Winning winning){
        Map<Integer, WinningNumbersDto> winningTickets = winning.getWinningTickets();
        for(Map.Entry<Integer, WinningNumbersDto> entry : winningTickets.entrySet()) {
            WinningNumbersDto winningNumbersDto = entry.getValue();
            lottoView.showMessage(winningNumbersDto.getWinningNumber().toString());
        }
    }

    private void getFinalResult(Map<WinningRank, Integer> result, float finalRate){
        String string = setResult(result);
        lottoView.showMessage("당첨 통계");
        lottoView.showMessage("---");
        lottoView.showMessage(string);
        lottoView.showMessage("총 수익률은 " + finalRate + "%입니다.");
    }

    public List<Integer> setUserNumbers(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        String [] splitResult = userInput.split(",");
        for (String number : splitResult) {
            number = number.trim();
            userNumbers.add(splitNumber(number));
        }
        return userNumbers;
    }

    private Integer getUserPurcharsePrice(String userInput) {
        userInput = userInput.trim();
        return parseMoney(userInput);
    }

    private int splitNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private int parseMoney(String userInput) {
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액 입력은 숫자여야 합니다.");
        }
    }

    private String setResult(Map<WinningRank, Integer> rankCountMap) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<WinningRank, Integer> entry : rankCountMap.entrySet()) {
            WinningRank rank = entry.getKey();
            int count = entry.getValue();

            result.append(rank.getResultMessage(count)).append("\n");
        }
        return result.toString().trim();
    }

    public Integer getTotalPurchaseMoney(Map<WinningRank, Integer> result) {
        int totalPurchaseMoney = 0;
        for (Map.Entry<WinningRank, Integer> entry : result.entrySet()) {
            int winningPrice = Integer.parseInt(entry.getKey().getPrice().replace(",", ""));
            totalPurchaseMoney += winningPrice * entry.getValue();
        }
        return totalPurchaseMoney;
    }
}
