package lotto.view;

public class InputView extends InputReader {
    public int inputLottoMoney() {
        String inputLottoMoney = inputMessage();
        validateInputLottoMoney(inputLottoMoney);

        return Integer.parseInt(inputLottoMoney);
    }

    private void validateInputLottoMoney(String inputLottoMoney) {
        if (!inputLottoMoney.matches("^[0-9]+$")) {
            throw new NumberFormatException();
        }
    }
}
