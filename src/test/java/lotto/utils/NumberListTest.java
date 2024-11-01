package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberListTest {

    @Test
    @DisplayName("Test Add Number to NumberList")
    void testAddNumberToList(){


        NumberList numberList = new NumberList();
        int newNumber = 4;
        numberList.addNewNumber(newNumber);
        assertThat(numberList.size()).isEqualTo(1);
        assertThat(numberList.getFirst()).isEqualTo(newNumber);

    }

    @Test
    @DisplayName("Test Exception for adding duplicated Number to NumberList")
    void testAddDuplicatedNumberToList(){


        NumberList numberList = new NumberList();
        int newNumber = 4;

        numberList.addNewNumber(newNumber);
        numberList.addNewNumber(newNumber);

        assertThat(numberList.size()).isEqualTo(1);
        assertThat(numberList.getFirst()).isEqualTo(newNumber);

    }

    @RepeatedTest(value = 10000)
    @DisplayName("Test generate random number from 1 to 45")
    void testRandomNumber(){

        NumberList numberList = new NumberList();

        int min = 1;
        int max = 45;

        assertThat(numberList.generateRandomNumber()).isLessThanOrEqualTo(max).isGreaterThanOrEqualTo(min);

    }

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
