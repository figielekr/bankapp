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
        boolean isFound = false;
        for (int i = 0; i< numOfAccounts; i++){
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
    static void moneyDeposit(String name, double amountToDeposit){
        boolean isFound = false;
        for (int i = 0; i< numOfAccounts; i++){
            if  (name.equals(resultName.get(i))){
                double x = resultBalance.get(i);
                resultBalance.set(i, x+amountToDeposit);
                isFound = true;
            }
        }
        if (!isFound){
            System.out.println("Nie ma takiego klienta.");
        }
        System.out.println();
        menu();
    }
    static void moneyWithdraw(String name, double amountToWithdraw){
        boolean isFound = false;
        for (int i = 0; i< numOfAccounts; i++){
            if  (name.equals(resultName.get(i))){
                double x = resultBalance.get(i);
                if (amountToWithdraw > x){
                    System.out.println("Na koncie nie ma wystarczającej ilości środków.");
                }
                else if (amountToWithdraw < 0){
                    System.out.println("Wprowadziłeś niepoprawne dane.");
                }
                else {
                    resultBalance.set(i, x-amountToWithdraw);
                    System.out.println("Wypłacono: " + amountToWithdraw + ", na koncie pozostało: " + resultBalance.get(i));
                }
                isFound = true;
            }
        }
        if (!isFound){
            System.out.println("Nie ma takiego klienta.");
        }
        System.out.println();
        menu();
    }
    static void moneyTransfer(String nameFrom,String nameTo, double amountToTransfer){
        boolean isFound = false;
        for (int i = 0; i< numOfAccounts; i++){
            if  (nameFrom.equals(resultName.get(i))){
                double xFrom = resultBalance.get(i);
                for (int j = 0; j< numOfAccounts; j++){
                    if (nameTo.equals(resultName.get(j))){
                        double xTo = resultBalance.get(j);
                        if (amountToTransfer > xFrom){
                            System.out.println("Na koncie nie ma wystarczającej ilości środków.");
                        }
                        else if (amountToTransfer < 0){
                            System.out.println("Wprowadziłeś niepoprawne dane.");
                        }
                        else {
                            resultBalance.set(i, xFrom-amountToTransfer);
                            resultBalance.set(j, xTo+amountToTransfer);
                        }
                        isFound = true;
                    }
                }

            }
        }
        if (!isFound){
            System.out.println("Wprowadzono niepoprawne nazwy klientów.");
        }
        System.out.println();
        menu();
    }

    static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Utworzenie nowego konta.");
        System.out.println("2. Wpłacanie pieniędzy.");
        System.out.println("3. Wypłacanie pieniędzy.");
        System.out.println("4. Wykonaj przelew.");
        System.out.println("5. Informacje o koncie.");
        System.out.println("6. Wyjście z menu.");
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
                System.out.println("Podaj imię: ");
                String name = scanner.next();
                System.out.print("Wplacam: ");
                double amountToDeposit = scanner.nextDouble();
                System.out.println();
                moneyDeposit(name,amountToDeposit);
            }
            else if (x==3){
                System.out.println("Podaj imię: ");
                String name = scanner.next();
                System.out.print("Wyplacam: ");
                double amountToWithdraw = scanner.nextDouble();
                System.out.println();
                moneyWithdraw(name,amountToWithdraw);
            }
            else if (x==4){
                System.out.println("Podaj imię z którego chcesz przelać pieniądze: ");
                String nameFrom = scanner.next();
                System.out.print("Przelewam pieniądze na konto: ");
                String nameTo = scanner.next();
                System.out.println("Kwota jaką chcę przelać: ");
                double amountToTransfer = scanner.nextDouble();
                System.out.println();
                moneyTransfer(nameFrom, nameTo,amountToTransfer);
            }
            else if (x==5){
                System.out.print("Podaj imię: ");
                String infoName = scanner.next();
                accountInformation(infoName);
            }

            else if (x==6) {
                System.out.println("System shutting down...");

            }
            else throw new IllegalStateException("Zły wybór, spróbuj ponownie.");
    }

}
