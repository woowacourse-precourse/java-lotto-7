package lottoController;

import lotto.Lotto;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoResultController {

    private static Lotto winningNumber;
    private static int bonusNumber;

    public void showLottoResult() {
        saveWinningNumber(InputView.inputWinningNumber());
        saveBonusNumber();
        //checkLottoResult();
    }

    public void saveWinningNumber(String InputWinningNumber) {
        String[] stringWinningNumber = InputWinningNumber.split(",");
        List<Integer> validWinningNumber = new ArrayList<>();

        try {
            for(String number : stringWinningNumber){
                validWinningNumber.add(Integer.parseInt(number));
            }
            winningNumber = new Lotto(validWinningNumber);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERORR] 숫자만 입력 가능 합니다.");
        }
    }

    public void saveBonusNumber() {
        try {
            bonusNumber = Integer.parseInt(InputView.inputBonusNumber());

            if(bonusNumber > 45 || bonusNumber < 1){
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

            ArrayList<Integer> invalidNumbers = new ArrayList<>(winningNumber.getNumbers());
            if (invalidNumbers.contains(bonusNumber)){
                throw new IllegalArgumentException("[ERROR] 중복된 번호입니다.");
            }

        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERORR] 숫자만 입력 가능 합니다.");
        }
    }

//    public void checkLottoResult(){
//        GenerateLottoController generateLottoController = new GenerateLottoController();
//        List<Lotto> lottoList = new ArrayList<>();
//        lottoList = generateLottoController.getLottoList();
//
//        int[] countResult = new int[5];
//
//        for (Lotto lotto : lottoList){
//            winningNumber.getNumbers().stream().filter(number -> lotto.getNumbers().contains(number)).count();
//        }
//
//    }
}
