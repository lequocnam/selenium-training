package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelWithDPTest {
    @DataProvider(parallel=true)
    public Object[][] testData() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        return new Object[][] {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {10}
        };
    }

    @Test(dataProvider = "testData")
    public void test1(int number) {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        System.out.println(number);
    }
}
