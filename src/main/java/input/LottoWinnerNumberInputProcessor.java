package input;

import constant.InputNotice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoWinnerNumberInputProcessor implements InputProcessor<List<Integer>> {

    @Override
    public List<Integer> putValue() {
        while (true) {
            String winnerLottoNumberInput = receiveInput(InputNotice.WINNER_NUMBER);
            List<Integer> winnerLottoNumber;
            List<String> splitWinnerLottoNumber;
            splitWinnerLottoNumber = Arrays.stream(winnerLottoNumberInput.split(",")).toList();
            try {
                winnerLottoNumber = changeLottoNumber(splitWinnerLottoNumber);
                return winnerLottoNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> changeLottoNumber(List<String> splitWinnerLottoNumber) throws NumberFormatException {
        List<Integer> lottoNumber = new ArrayList<>();
        for (String winnerLottoNumber : splitWinnerLottoNumber) {
            winnerLottoNumber = winnerLottoNumber.trim();
            Integer lottoNumberElement;
            lottoNumberElement = changeInteger(winnerLottoNumber);
            lottoNumber.add(lottoNumberElement);
        }
        return lottoNumber;
    }
}
