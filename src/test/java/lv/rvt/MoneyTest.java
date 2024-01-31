package lv.rvt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import rvt.Money;

public class MoneyTest {

    @Test
    public void testPlusMoneyMethod(){

        Money mon1 = new Money(1, (byte) 85);
        Money mon2 = new Money(2, (byte) 90);

        Money result1 = mon1.plus(mon2);

        assertEquals(4, result1.euros());
        assertEquals(75, result1.cents());
    }

    @Test
    public void testPlusEurosMethod(){

        Money mon1 = new Money(0, (byte) 85);

        Money result1 = mon1.plus(5);

        assertEquals(5, result1.euros());
        assertEquals(85, result1.cents());
    }

    @Test
    public void testPlusCentsMethod(){

        Money mon1 = new Money(0, (byte) 85);

        Money result1 = mon1.plus((byte)20);

        assertEquals(1, result1.euros());
        assertEquals(5, result1.cents());
    }

    @Test
    public void testMinusMoneyMethod(){

        Money mon1 = new Money(1, (byte) 85);
        Money mon2 = new Money(2, (byte) 90);

        Money result1 = mon1.minus(mon2);

        assertEquals(0, result1.euros());
        assertEquals(0, result1.cents());
    }

    @Test
    public void testMinusEurosMethod(){

        Money mon1 = new Money(1, (byte) 85);

        Money result1 = mon1.minus(1);

        assertEquals(0, result1.euros());
        assertEquals(85, result1.cents());
    }

    @Test
    public void testMinusCentsMethod(){

        Money mon1 = new Money(1, (byte) 85);

        Money result1 = mon1.minus((byte) 32);

        assertEquals(1, result1.euros());
        assertEquals(53, result1.cents());
    }

    @Test
    public void testLessThanMethod(){

        Money mon1 = new Money(1, (byte) 85);
        Money mon2 = new Money(2, (byte) 90);

        Boolean result1 = mon1.lessThan(mon2);

        assertEquals(true, result1);
    }

    @Test
    public void testEqualsMethod(){

        Money mon1 = new Money(1, (byte) 1);
        Money mon2 = new Money(1, (byte) 1);
        Money mon3 = new Money(1, (byte) 2);

        assertEquals(mon1, mon2);
        assertNotEquals(mon1, mon3);
    }

}
