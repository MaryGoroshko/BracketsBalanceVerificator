package app;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BalanceVerificatorTest {

    private BalanceVerificator balanceVerificator;

    @BeforeEach
    void setUp() {
        balanceVerificator = new BalanceVerificator();
    }

    @Test
    void givenBalancedString_whenChecking_shouldReturnMinusOne() {
        int result = balanceVerificator.checkBrackets("{[()]}");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void givenEvenLengthString_whenChecking_shouldReturnThree() {
        int result = balanceVerificator.checkBrackets("{[(]}");
        Assertions.assertEquals(3, result);
    }

    @Test
    void givenBothMatchingCriteriaString_shouldReturnMinusOne() {
        int result = balanceVerificator.checkBrackets("{{[[(())]]}}");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void givenStringLength_whenChecking_shouldBeNotEquals() {
        String str = "({[(]})";
        int result = balanceVerificator.checkBrackets(str);
        Assertions.assertNotEquals(str.length(), result);
    }

    @Test
    void givenEvenStringWithDifferentBrackets_sholdReturnTwo() {
        int result = balanceVerificator.checkBrackets("{[}}");
        Assertions.assertEquals(2, result);
    }

    @Test
    void givenNotMatchingCriteriaString_shouldReturnIllegalArgumentException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> balanceVerificator.checkBrackets("s[]"));
    }

    @Test
    void givenNumberOfOpenBracketsNotEqualToTheNumberOfClosingOnes(){
        String str = "((())";
        int result = balanceVerificator.checkBrackets(str);
        Assertions.assertNotEquals(str.length(), result);
    }

    @Test
    void givenNotMatchingCriteriaString_shouldReturnIllegalException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> balanceVerificator.checkBrackets("***"));
    }
}