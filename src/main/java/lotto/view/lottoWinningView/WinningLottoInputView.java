package lotto.view.lottoWinningView;

import lotto.util.DefaultNumberConverter;
import lotto.view.InputProvider;

public class WinningLottoInputView {

    private final InputProvider inputProvider;
    private final DefaultNumberConverter numberConverter;

    public WinningLottoInputView(InputProvider inputProvider, DefaultNumberConverter numberConverter){
        this.inputProvider = inputProvider;
        this.numberConverter = numberConverter;
    }

    public String inputWinningLottoNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return inputProvider.getInput();
    }

    public int inputBonusNumbers(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return numberConverter.convertNumber(inputProvider.getInput());
    }


}
