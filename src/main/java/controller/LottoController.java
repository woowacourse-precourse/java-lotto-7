package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.LottoResult;
import util.LottoParsing;
import validate.LottoValidate;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class LottoController {
    private static final String ILLEGAL_PURCHASE_ERR = "ILLEGAL_PURCHASE_ERR";

    private static final String REGEX_ONLY_NUMBER = "[0-9]";
    private static final String REGEX_COMMA = "[,]";

    private static final String TOTAL_PROFIT ="수익률은 : ";

    private InputView inputView;
    private OutputView outputView;
    private LottoParsing lottoParsing;

    public LottoController(){
        inputView = new InputView();
        outputView = new OutputView();
        lottoParsing = new LottoParsing();
    }

    public int getLottoCount(String inputPurchaseStr){
        LottoValidate.validateOnlyNumberWithSpecialChar(inputPurchaseStr,REGEX_ONLY_NUMBER,REGEX_COMMA);
        int lottoPurchase = Integer.parseInt(inputPurchaseStr);
        if(lottoPurchase % 1000 != 0){
            throw new IllegalArgumentException(ILLEGAL_PURCHASE_ERR);
        }
        return lottoPurchase/1000;
    }

    public ArrayList<Lotto> createLottos(int lottoCount){
        ArrayList<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i< lottoCount; i++){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
        return lottos;
    }

    public ArrayList<Integer> getWinningNumber(String inputLottoNumberStr){
        LottoValidate.validateOnlyNumberWithSpecialChar(inputLottoNumberStr, REGEX_ONLY_NUMBER, REGEX_COMMA);
        String[] winningNumberStrs = inputLottoNumberStr.split(REGEX_COMMA);

        ArrayList<Integer> winningNumbers = new ArrayList<>();
        for(String str : winningNumberStrs){
            int number = Integer.parseInt(str);
            LottoValidate.validateLottoIntRange(number);
        }

        return winningNumbers;
    }

    public int getBonnusNumber(String inputBonnusNumberStr){
        LottoValidate.validateOnlyNumberWithSpecialChar(inputBonnusNumberStr, REGEX_ONLY_NUMBER, "[]");
        return Integer.parseInt(inputBonnusNumberStr);
    }

    public LottoResult getResultLotto(ArrayList<Lotto> lottos, ArrayList<Integer> lottoWinningsNumber, int bonusNumber){
        LottoResult lottoResult = new LottoResult();
        for(Lotto lotto : lottos){
            lottoResult.addResult(lotto.checkWinCountWithWinNumbers(lottoWinningsNumber), lotto.checkBonnusNumber(bonusNumber));
        }
        return lottoResult;
    }

    public String getTotalWinnings(int lottoCount, LottoResult lottoResult){
        Float winnginsFloat = lottoCount*1000 / (float)lottoResult.getTotalWinnings() * 100;
        String winnings = winnginsFloat.toString();

        return TOTAL_PROFIT+winnings+lottoResult.toString();
    }
}
