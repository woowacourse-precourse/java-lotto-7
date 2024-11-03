package factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.WinningLottoNum;
import validation.Validation;

import static error.ErrorMessage.INPUT_WINNING_LOTTO_NUM_ERROR;

public class WinningLottoNumFactory {

    private final String input;
    private List<Integer> nums;
    private static final int WINNING_LOTTO_NUM_LEN = 6;

    public WinningLottoNumFactory(String input) {
        Validation.blankInput(input);
        this.input = input;
    }

    public WinningLottoNum get() {
        splitString();
        validate();
        return new WinningLottoNum(nums);
    }

    private void splitString() {
        String[] splited = input.split("\\s*,\\s*");
        for (String str : splited) {
            Validation.numberInput(str);
        }
        nums = Arrays.stream(splited)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }

    private void validate() {
        Validation.duplicate(nums);
        if (nums.size() != WINNING_LOTTO_NUM_LEN) {
            throw new IllegalArgumentException(INPUT_WINNING_LOTTO_NUM_ERROR);
        }
        validRange();
    }

    private void validRange() {
        for (int num : nums) {
            Validation.range(num);
        }
    }
}

