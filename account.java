import java.util.ArrayList;
import java.util.Scanner;


public class account {
    private static int numOfAccounts;
    static ArrayList<String> resultName = new ArrayList<>();
    static ArrayList<Double> resultBalance = new ArrayList<>();
    
    static void newAccount(String name, double startingMoney){
        numOfAccounts++;
        //System.out.println("liczba kont"+numOfAccounts);
        for (int i = numOfAccounts-1; i< numOfAccounts; i++){
            resultName.add(name);
            resultBalance.add(startingMoney);
            System.out.println("Pomyślnie zarejestrowano nowe konto. Imię: "+resultName.get(i));
            System.out.println("Stan konta: "+resultBalance.get(i));
            System.out.println();
        }
        menu();
    }
    static void accountInformation(String name){
        //System.out.println(numOfAccounts+ " <<- liczba kont");
        boolean isFound = false;
        for (int i = 0; i< numOfAccounts; i++){
            //System.out.println("szuikany uzytkownik"+x);
            if  (name.equals(resultName.get(i))){
                System.out.println("Imie uzytkownika: "+resultName.get(i));
                System.out.println("Stan konta: "+resultBalance.get(i));
                System.out.println();
                isFound = true;
            }
        }
        if (!isFound){
            System.out.println("Nie ma takiego klienta.");
        }
        System.out.println();
        menu();
    }

    static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Utworzenie nowego konta.");
        System.out.println("2. Informacje o koncie.");
        System.out.println("3. Wyjście z menu.");
        int x = scanner.nextInt();

            if (x==1) {
                System.out.print("Podaj imie: ");
                String newName = scanner.next();
                System.out.print("Depozyt początkowy: ");
                double newStartingMoney = scanner.nextDouble();
                System.out.println();
                newAccount(newName, newStartingMoney);
            }
            else if (x==2){
                System.out.print("Podaj imię: ");
                String infoName = scanner.next();
                accountInformation(infoName);
            }

            else if (x==3) {
                System.out.println("System shutting down...");

            }
            else throw new IllegalStateException("Zły wybór, spróbuj ponownie.");
    }

}
