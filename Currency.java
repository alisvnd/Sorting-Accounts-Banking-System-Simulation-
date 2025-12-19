public class Currency {
    private double conversionRate;
    private char symbol ;
    
    Currency (double conversionRate, char symbol){
        this.conversionRate = conversionRate ;
        this.symbol = symbol;
    }
    public double getConversionRate() {
        return conversionRate;
    }
    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
