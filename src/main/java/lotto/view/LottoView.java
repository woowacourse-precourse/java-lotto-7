package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.dto.LottoDetail;
import lotto.io.Input;
import lotto.io.Output;
import lotto.view.dto.BonusNumberDTO;
import lotto.view.dto.LottoBuyDTO;
import lotto.view.dto.WinningNumberDTO;

public class LottoView {

    public LottoBuyDTO lottoBuyView(){
        Output.priceInputMessage();
        int money = Input.readMoney();

        return new LottoBuyDTO(money);
    }

    public WinningNumberDTO winningNumberView(){
        Output.winningNumberInputMessage();
        List<Integer> winningNumbers = Input.readWinningNumber();

        return new WinningNumberDTO(winningNumbers);
    }

    public BonusNumberDTO bonusNumberView(){
        Output.bonusNumberInputMessage();
        int bonusNumber = Input.readBonusNumber();

        return new BonusNumberDTO(bonusNumber);
    }


    public void printSellLottos(List<LottoDetail> lottoDetails) {
        lottoDetails.forEach(
            lottoDetail -> {
                System.out.println(lottoDetail.lottoNumbers().toString());
            }
        );
    }
}
