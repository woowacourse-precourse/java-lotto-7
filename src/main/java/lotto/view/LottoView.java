package lotto.view;

import java.util.List;
import lotto.domain.dto.LottoDetail;
import lotto.io.Input;
import lotto.io.Output;
import lotto.view.dto.BonusNumberDTO;
import lotto.view.dto.LottoBuyDTO;
import lotto.view.dto.WinningNumberDTO;

public class LottoView {

    public LottoBuyDTO lottoBuyView() {
        int money;
        while (true) {
            try {
                Output.priceInputMessage();
                money = Input.readMoney();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return new LottoBuyDTO(money);
    }

    public WinningNumberDTO winningNumberView() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                Output.winningNumberInputMessage();
                winningNumbers = Input.readWinningNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return new WinningNumberDTO(winningNumbers);
    }

    public BonusNumberDTO bonusNumberView() {
        int bonusNumber;
        while (true) {
            try {
                Output.bonusNumberInputMessage();
                bonusNumber = Input.readBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return new BonusNumberDTO(bonusNumber);
    }


    public void printSellLottos(List<LottoDetail> lottoDetails) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoDetails.size()));
        lottoDetails.forEach(
                lottoDetail -> {
                    System.out.println(lottoDetail.lottoNumbers().toString());
                }
        );
    }

    public void printLottoResults(List<String> lottoResults, double returnRate) {
        System.out.println("당첨통계");
        System.out.println("---");
        lottoResults.forEach(System.out::println);
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", returnRate));
    }
}
