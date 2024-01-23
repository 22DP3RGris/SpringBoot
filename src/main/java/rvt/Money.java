package rvt;

public class Money {

    private final int euros;
    private final byte cents;

    public Money(int euros, byte cents) {
        this.euros = euros;
        this.cents = cents;
    }

    public Money() {
        this(0, (byte) 0);
    }

    public Money(int euros) {
        this(euros, (byte) 0);
    }

    public Money(byte cents) {
        this(0, cents);
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    @Override 
    public boolean equals(Object obj)
    {
        Money mon = (Money) obj;
        return this.euros == mon.euros && this.cents == mon.cents;
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

        Money newMoney = new Money(newEuro, (byte) newCents);

        return newMoney;
    }

    public Money plus(int euros){
        Money mon = new Money(euros);
        return this.plus(mon);
    }

    public Money plus(byte cents){
        Money mon = new Money(cents);
        return this.plus(mon);
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
        Money newMoney = new Money(newEuro, (byte) newCents);

        return newMoney;
    }

    public Money minus(int euros){
        Money mon = new Money(euros);
        return this.minus(mon);
    }

    public Money minus(byte cents){
        Money mon = new Money(cents);
        return this.minus(mon);
    }
}