import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankManagement {
    public static User[] users = new User[100000] ;
    public static User[] originalUsers = new User[100000] ;
    public static Scanner sc = new Scanner(System.in) ;
    public static int userNumber ;
    public static Random rand = new Random() ;
    public static Currency[] currencies = new Currency[4] ;
    public static int limit ;
    public static boolean sortById ;

    public static void main(String[] args) {
        generateCurrencies();
        int choice;
        System.out.println("Welcome to the bank!\nCurrent conversion rates:");
        for (int i = 0; i < currencies.length; i++){
            System.out.print("\n" + currencies[i].getSymbol() + ": " + currencies[i].getConversionRate());
        }
        do  {
            System.out.print("\n\nWhat do you want to do?\n1. Generate random users\n2. List users\n3. Show user with ID\n4. Set conversion rates\n5. Sort users\n6. Reset to the original unsorted array\n0. Exit\n\nYour Choice: ");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                generateUsers();
                break;
            case 2:
                for (int i = 0; i < userNumber; i++){
                    System.out.println(users[i].toString());
                }
                break;
            case 3:
                User user = findUserById();
                try {
                    System.out.println(user.toString() + "\nAccounts:");
                    for (int i = 0; i < user.getAccounts().size(); i++){
                        System.out.println(i+1 + ". " + user.getAccounts().get(i).toString());
                    }
                } catch (Exception e) {
                    System.out.println("Cannot find the user!");
                }
                break;
            case 4:
                for (int i = 0; i < currencies.length; i++){
                    System.out.print("Set " + currencies[i].getSymbol() + ": ");
                    currencies[i].setConversionRate(sc.nextDouble());
                }
                break;
            case 5:
                System.out.print("Choose sort type:\n1. By ID\n2. By Total Amount\nChoice:");
                sortById = sc.nextInt() == 1;
                System.out.print("Enter sort limit: ");
                limit = sc.nextInt();
                long start = System.currentTimeMillis();
                sort(0, userNumber-1);
                long finish = System.currentTimeMillis();
                long timeElapsed = finish - start;
                System.out.println("Sort duration: " + timeElapsed);
                break;
            case 6:
                users = originalUsers ;
                break;
            case 0:
                System.out.println("\n    Bye!\n");
            }
        }   while (choice != 0);
    }

    public static void generateCurrencies(){
        currencies[0] = new Currency(1.3473896, 'A') ;
        currencies[1] = new Currency(1.245906, 'B') ;
        currencies[2] = new Currency(2.0495324, 'C') ;
        currencies[3] = new Currency(2.8282416, 'D') ;
    }

    public static void generateUsers(){
        System.out.print("Generate how many?: ");
        userNumber = sc.nextInt() ;
        for (int i = 0; i < userNumber; i++){
            String tempId = "" ;
            for (int j = 1; j <= 9; j++){
                tempId += rand.nextInt(10);
            }
            int id = Integer.valueOf(tempId) ;
            ArrayList<BankAccount> accounts = new ArrayList<>() ;
            for (int j = 1; j <= rand.nextInt(2,11); j++){
                accounts.add(new BankAccount(currencies[rand.nextInt(4)], rand.nextInt(10000)));
            }
            users[i] = new User(User.names[rand.nextInt(15)], User.surnames[rand.nextInt(15)], id, accounts) ;
        }
        for (int i = 0; i < userNumber; i++){
            originalUsers[i] = users[i] ;
        }
    }

    public static void sort (int from, int to){
        if ((to - from) <= limit){
            insertionSort(users, from, to) ;
        }
        else {
            quickSort(users, from, to) ;
        }
    }

    public static void insertionSort(User[] arr, int from, int to){
        for (int i = from; i <= to; i++){
            insert(arr, i, from) ;
        }
    }

    public static void insert(User[] arr, int i, int from){
        if (i == from){
            return;
        }
        if ((sortById && arr[i].getId() >= arr [i-1].getId()) || (!sortById && arr[i].getTotalAmountInCommonCurrency() >= arr [i-1].getTotalAmountInCommonCurrency())){
            return;
        }
        User temp = arr[i-1];
        arr[i-1] = arr[i];
        arr[i] = temp;
        insert(arr, i-1, from) ;
    }

    public static void quickSort(User[] arr, int from, int to){
        int i = partition(arr, from, to) ;
        sort(from, i -1);
        sort(i+1, to);
    }

    public static int partition(User[] arr, int from, int to){
        User pivot = arr[to];
        int i = from ;
        for (int j = from; j < to; j++){
            if ((sortById && arr[j].getId() <= pivot.getId()) || (!sortById && arr[j].getTotalAmountInCommonCurrency() <= pivot.getTotalAmountInCommonCurrency())){
                User temp = arr[i] ;
                arr[i] = arr[j] ;
                arr[j] = temp ;
                i++ ;
            }
        }
        User temp = arr[i] ;
        arr[i] = pivot ;
        arr[to] = temp ;
        return i ;
    }

    public static User findUserById(){
        System.out.print("Enter user ID: ");
        int id = sc.nextInt();
        User user = null;
        for (int i = 0; i < userNumber; i++){
            if(users[i].getId() == id){
                user = users[i];
            }
        }
        return user;
    }
}