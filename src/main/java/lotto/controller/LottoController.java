package lotto.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Prize;
import lotto.domain.WinningNumber;
import lotto.ui.InputView;

public class LottoController {
    private InputConverter convertValidValue;
    private LottoGenerator lottoGenerator;
    private List<Lotto> lottos;
    private int ticketCount;
    private WinningNumber winningNumber;
    private Map<Prize, Integer> prizes;

    public LottoController(){
        convertValidValue = new InputConverter();
        lottoGenerator = new LottoGenerator();
        lottos = new ArrayList<Lotto>();
        ticketCount = 0;
        initPrize();
    }

    public void run(){
        lottoAmount();
        purchaseLotto();
        getWinningNumber();
        compareLotto();
    }

    private void initPrize(){
        prizes = new LinkedHashMap<Prize, Integer>();

        for(Prize p : Prize.values()){
            prizes.put(p, 0);
        }
    }

    private void lottoAmount() {
        String purchaseAmount = InputView.purchase();
        int ticket = 0;

        try {
            ticket = convertValidValue.purchaseAmount(purchaseAmount);
            ticketCount = ticket;
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
            lottoAmount();
        }
    }

    private void purchaseLotto() {
        for(int i = 0; i< ticketCount; i++){
            lottos.add(lottoGenerator.generate());
        }
    }

    private Lotto getWinningLotto(){
        String userInput = InputView.winningNumber();
        Lotto lotto = null;

        try{
            List<Integer> li = convertValidValue.winningNumbers(userInput);
            lotto = new Lotto(li);
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
            return getWinningLotto();
        }

        return lotto;
    }

    private int getBonusNumber(){
        String UserInput = InputView.bonusNumber();
        int bonusNumber = 0;

        try {
            bonusNumber = convertValidValue.bonusNumber(UserInput);
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
            return getBonusNumber();
        }

        return bonusNumber;
    }

    private void getWinningNumber(){
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber();

        try{
            winningNumber = new WinningNumber(winningLotto, bonusNumber);
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
            getWinningNumber();
        }
    }

    private void compareLotto(){
        for(Lotto lotto : lottos){
            Prize prize = winningNumber.matchCount(lotto);

            prizes.put(prize, prizes.get(prize) + 1);
        }
    }
}
