package lotto.controller;

import java.util.HashMap;
import lotto.constant.ErrorName;
import lotto.item.AdditionalNumber;
import lotto.item.Lotto;
import lotto.item.Money;
import lotto.model.BuyLotto;
import lotto.model.CalculateResult;
import lotto.model.MatchLotto;
import lotto.view.OutputViewLotto;
import lotto.view.InputViewLotto;

public class LottoController {
    InputViewLotto Input = new InputViewLotto();
    Money money = Input.getMoney();
    Lotto lotto = Input.getLotto();
    AdditionalNumber additionalNumber = Input.getAdditionalNumber();
    BuyLotto BuyLotto = new BuyLotto(money);

    public void LottoNumberController() {
        while (lotto.getLottoValue().contains(additionalNumber.getNumber())){
            System.out.println(ErrorName.ErrorDuplicationforAdditionalNumber.getErrorMessage());
            additionalNumber = Input.getAdditionalNumber();
        }
    }

    public HashMap<Integer, Integer> CalculateHashmap(){
        MatchLotto matchLotto = new MatchLotto();
        HashMap<Integer, Integer> result = matchLotto.MatchLotto(BuyLotto, lotto, additionalNumber);
        return result;
    }

    public float CalculateReword(HashMap<Integer, Integer> result){
        CalculateResult calculateResult = new CalculateResult();
        float rewordRatio = calculateResult.Calculate(result, money);
        return rewordRatio;
    }

    public void Display(HashMap<Integer, Integer> result, float rewordRatio){
        OutputViewLotto Output = new OutputViewLotto();
        Output.viewLottoList(money, BuyLotto);
        Output.ViewResultDetail(result);
        Output.ViewResultPrice(rewordRatio);
        }

    public void run(){
        LottoNumberController();
        HashMap<Integer, Integer> result = CalculateHashmap();
        float rewordRatio = CalculateReword(result);
        Display(result, rewordRatio);
    }
    }