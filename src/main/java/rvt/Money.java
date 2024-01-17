package rvt;

public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    public String toString() {
        String zero = "";
        if (cents < 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "€";
    }

    public Money plus(Money addition) {
        int onlyCents = (this.euros * 100 + this.cents) + (addition.euros * 100 + addition.cents);
        int newEuro = onlyCents / 100;
        int newCents = onlyCents % 100;

        Money newMoney = new Money(newEuro, newCents);

        return newMoney;
    }

    public Boolean lessThan(Money compared) {
        Boolean isLess = (this.euros * 100 + this.cents) < (compared.euros * 100 + compared.cents);
    
        return isLess;
    }

    public Money minus(Money ammount) {
        int onlyCents = (this.euros * 100 + this.cents) - (ammount.euros * 100 + ammount.cents);
        int newEuro = onlyCents / 100;
        int newCents = onlyCents % 100;
        if (newEuro < 0 || newCents < 0) {
            newEuro = 0;
            newCents = 0;
        }
        Money newMoney = new Money(newEuro, newCents);

        return newMoney;
    }
}