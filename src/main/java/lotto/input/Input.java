package lotto.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import lotto.config.Error;

public class Input {
    static public Integer inputAmount(Supplier<String> reader) {
        String input = reader.get();
        DataInfo<Integer> data = validateInteger(input);

        List<DataInfo<Predicate<Integer>>> policies = List.of(
                new DataInfo<Predicate<Integer>>((num) -> num % 1000 == 0, Error.INPUT_CANT_DIVIDED_BY_1000)
        );

        while(data.status != Error.SUCCEED) {
            try {
                throw new IllegalArgumentException(data.status.getMsg());
            } catch (IllegalArgumentException ignored) {}

            input = reader.get();
        }

        return data.value/1000;
    }

    static public List<Integer> inputLottoNumbers(Supplier<String> reader) {
        String input = reader.get();

        return List.of(0);
    }


    static private DataInfo<Integer> validateInteger(String input) {
        try {
            int num = Integer.parseInt(input);
            return new DataInfo<>(num, Error.SUCCEED);
        } catch (NumberFormatException ignored) {}

        return new DataInfo<>(-1, Error.INPUT_INVALID);
    }
    static private DataInfo<List<Integer>> validate(List<String> in, List<DataInfo<Predicate<Integer>>> policies) {
        for(DataInfo<Predicate<Integer>> policy : policies) {
            for(String num : in) {
                try {
                    int n = Integer.parseInt(num);
                    if(! policy.value.test(n)) {
                        return new DataInfo<>(List.of(0), policy.status);
                    }
                } catch(NumberFormatException e) {
                    return new DataInfo<>(List.of(0), Error.INPUT_INVALID);
                }
            }
        }
        return new DataInfo<>(List.of(0), Error.SUCCEED);
    }
}
