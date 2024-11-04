package model;

import enums.LottoRank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.InputService;
import service.OutputService;

public class LottoManager {

    private static final int LOTTO_PRICE = 1000;
    private static final List<LottoRank> LOTTO_RANKS = Arrays.asList(LottoRank.FIVE, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);
    private InputService inputService;
    private OutputService outputService;
    private LottoGenerator lottoGenerator;
    private LottoWinningNumbers lottoWinningNumbers;
    private LottoWinningChecker lottoWinningChecker;
    private Map<LottoRank, Integer> winningCounter;
    private Integer purchaseCost;
    private Integer purchaseCount;
    private Long totalPrizes;
    private List<Lotto> purchasedLotto;

    public LottoManager(){
        inputService = new InputService();
        outputService = new OutputService();
        lottoGenerator = new LottoGenerator();
        purchasedLotto = new ArrayList<>();
        winningCounter = new HashMap<>();
    }

    private void initializeAnalysisFunction(){
        lottoWinningChecker = new LottoWinningChecker(lottoWinningNumbers);
        for(var lottoRank : LOTTO_RANKS){
            winningCounter.put(lottoRank, 0);
        }
    }

    private void displayPurchasedLotto(){
        outputService.printPurchaseCountMessage(purchaseCount);
        outputService.printLottoNumbers(purchasedLotto);
    }

    private void calculateTotalPrizes(){
        for(var lottoRank : LOTTO_RANKS){
            totalPrizes += lottoRank.getPrize() * winningCounter.get(lottoRank)
        }
    }

    public void purchaseLotto(){
        purchaseCost = inputService.inputLottoPurchaseCost();
        purchaseCount = purchaseCost / LOTTO_PRICE;
        for(int i = 0; i < purchaseCount; i++){
            purchasedLotto.add(lottoGenerator.lottoGenrate());
        }
        displayPurchasedLotto();
    }

    public void drawWinningNumbers(){
        Lotto winningNumbers = new Lotto(inputService.inputWinningNumbers());
        Integer bonusNumber = inputService.inputBonusNumber();
        lottoWinningNumbers = new LottoWinningNumbers(winningNumbers, bonusNumber);
    }

    public void checkWinningResult(){
       initializeAnalysisFunction();
       for(var lotto : purchasedLotto){
           LottoRank lottoRank = lottoWinningChecker.getCheckResult(lotto);
           if(winningCounter.containsKey(lottoRank)){
               winningCounter.put(lottoRank, winningCounter.get(lottoRank) + 1);
           }
       }
       calculateTotalPrizes();
    }

    public void displayWinningResult(){
        outputService.printWinningStatisticsMessage();
        for(var lottoRank : LOTTO_RANKS){
            outputService.printWinningStatics(lottoRank.getMessage(), winningCounter.get(lottoRank));
        }
    }

    public void displayReturnRate(){

    }


}
