package lotto.service;

import lotto.dto.InputDTO;
import lotto.handler.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class InputDTOSaveService {
    private InputDTO inputDTO;

    public InputDTOSaveService() {
        this.inputDTO = new InputDTO();
    }
    private void setWinningNumbers(String inputNumbers) {
        InputHandler inputHandler = new InputHandler();
        List<Integer> numbers = inputHandler.inputWinningNumbers(inputNumbers);
        inputDTO.setWinningNumbers(numbers);
    }
    private void setBonusNumber(String bonusNumber) {
        InputHandler inputHandler = new InputHandler();
        int bonusNumberToInt = inputHandler.inputBonusNumber(bonusNumber);
        inputDTO.setBonusNumber(bonusNumberToInt);
    }
    public InputDTO mergeAllNumbers(String inputNumbers, String bonusNumber) {
        setWinningNumbers(inputNumbers);
        setBonusNumber(bonusNumber);
        List<Integer> allNumbers = new ArrayList<>(inputDTO.getWinningNumbers());
        allNumbers.add(inputDTO.getBonusNumber());
        inputDTO.setAllNumbers(allNumbers);
        return inputDTO;
    }
    public int setMoney(String money) {
        InputHandler inputHandler = new InputHandler();
        return inputDTO.setMoney(inputHandler.inputMoney(money));

    }
    public InputDTO getInputDTO() {
        return inputDTO;
    }
}
