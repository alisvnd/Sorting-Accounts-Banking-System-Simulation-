import java.util.ArrayList;

public class User {

    public static String[] names = {"John", "Jane", "Bob", "Alice", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hank", "Isla", "Jack", "Leo", "Mia", "Tom"};
    public static String[] surnames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris"};

    private String name, surname ;
    private int id ;
    private ArrayList<BankAccount> accounts ;

    User (String name, String surname, int id, ArrayList<BankAccount> accounts){
        this.name = name ;
        this.surname = surname ;
        this.id = id ;
        this.accounts = accounts ;
    }

    public double getTotalAmountInCommonCurrency(){
        double total = 0 ;
        for (BankAccount account : this.accounts) {
            total += account.getBalance() * account.getCurrency().getConversionRate() ;
        }
        return total ;
    }

    public String toString(){
        String idText = String.valueOf(id) ;
        while (idText.length() < 9){
            idText = 0 + idText;
        }
        return idText + " " + name + " " + this.surname + " Total Amount: " + getTotalAmountInCommonCurrency() ;
    } 

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public void setAccounts(ArrayList<BankAccount> accounts) {
        this.accounts = accounts;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}