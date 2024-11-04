package lotto.utils;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberListTest {




    @RepeatedTest(value = 10000)
    @DisplayName("Test generate random number list")
    void testGenerateRandomNumberList(){

        NumberList numberList = new NumberList();
        int testCnt = 10000;
        int min = 1;
        int max = 45;

        numberList.generateRandomNumberList();
        assertThat(numberList.size()).isEqualTo(6);

        for(int num : numberList){
            assertThat(num).isLessThanOrEqualTo(max).isGreaterThanOrEqualTo(min);
        }
    }

    @RepeatedTest(value = 10000)
    @DisplayName("Test generate random number list sorted in ascending")
    void testGenerateSortedNumberList(){

        NumberList numberList = new NumberList();

        numberList.generateRandomNumberList();
        assertThat(numberList.size()).isEqualTo(6);
        int prev = 0;

        for(int num : numberList){
            assertThat(num).as("Each element should be greater than the previous idx element").isGreaterThan(prev);
            prev = num;

        }
    }

    @Test
    void testPickUniqueNumber(){
        assertRandomUniqueNumbersInRangeTest(()->{
            NumberList numberList = new NumberList();

            assertThat(numberList.generateRandomNumberList()).isEqualTo(List.of(1,2,3,4,5,6));

        },List.of(1,2,3,4,5,6));

    }

}
