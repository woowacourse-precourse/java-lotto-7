package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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

}
