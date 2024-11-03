package lottoController;

import view.InputView;

public class GenerateLottoController {
    private final int LOTTO_PRICE = 1000;

    private boolean validateMoney(String inputMoney) {
        try{
            int validMoney = Integer.parseInt(inputMoney);

            if(validMoney % LOTTO_PRICE != 0){
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력 가능합니다.");
            }

        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        return true;
    }
}
