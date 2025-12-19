public class BankAccount {
    private Currency currency ;
    private double balance ;
    
    BankAccount(Currency currency, double balance){
        this.currency = currency ;
        this.balance = balance ;
    }
    public String toString(){
        return "Type: " + currency.getSymbol() + " Amount: " + balance + " Common: " + currency.getConversionRate()*balance ;
    }
    public double getBalance() {
        return balance;
    }
    public Currency getCurrency() {
        return currency;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
