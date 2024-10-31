package factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.WinningLottoNum;
import validation.Validation;

public class WinningLottoNumFactory {

    private final String input;
    private List<Integer> nums;
    private static final String INPUT_WINNING_LOTTO_NUM_ERROR = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String WINNING_LOTTO_NUM_RANGE_ERROR = "[ERROR] 당첨 번호의 범위는 1 ~ 45여야 합니다.";
    private static final int WINNING_LOTTO_NUM_LEN = 6;
    private static final int WINNING_LOTTO_NUM_START = 1;
    private static final int WINNING_LOTTO_NUM_END = 45;
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

    private void validate(){
        Validation.duplicate(nums);
        if(nums.size() != WINNING_LOTTO_NUM_LEN)
            throw new IllegalArgumentException(INPUT_WINNING_LOTTO_NUM_ERROR);
        if(!isValidRange())
            throw new IllegalArgumentException(WINNING_LOTTO_NUM_RANGE_ERROR);
    }

    private boolean isValidRange(){
        return nums.stream().allMatch(num ->
            num >= WINNING_LOTTO_NUM_START && num <= WINNING_LOTTO_NUM_END);
    }
}

