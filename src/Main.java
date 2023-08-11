import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static double takeBalanceInput(){
        System.out.print("Balance (minimum balance limit is INR 5000): "); double balance = sc.nextDouble();
        if(balance >= 5000) return balance;
        System.out.println("Please enter a valid amount");
        takeBalanceInput();
        return 0.0;

    }
    public static void main(String[] args) {

        System.out.println("Welcome to Bank of India!");
        System.out.println();
        System.out.println("Are you a new customer or existing? Type 'New' or 'Existing'");
        String cus = sc.next();
        String name = "";
        String password = "";
        double balance = 0.0;
        // old customer
        BOI oldCustomer = new BOI("Anwar", "anwar123", 12000);
        if(cus.equals("new") || cus.equals("New")){
            // register a new customer
            System.out.println("Please enter the following details:");
            System.out.print("Name: "); name = sc.next();
            System.out.print("Password: "); password = sc.next();
            balance = takeBalanceInput();
            System.out.println("Your account was created successfully.");
        }
        BOI newCustomer = new BOI(name, password, balance);
        if(cus.equals("new") || cus.equals("New")) System.out.println(newCustomer);
        String opt = "";
        if(cus.equals("new") || cus.equals("New")){
            System.out.print("Do some transaction. Type 'Yes' or 'No': "); opt = sc.next();
        }
        if(opt.equals("Yes") || opt.equals("yes")){
            System.out.println("Choose your transaction: ");
            System.out.println();
            transaction(newCustomer);
            /*while(true){
                System.out.println("Press 1 for balance enquiry");
                System.out.println("Press 2 to credit amount");
                System.out.println("Press 3 to withdraw amount");
                System.out.println("Press 4 to change password");
                System.out.println("Press 5 to calculate interest");
                int option = sc.nextInt();
                String anotherTransaction = "";
                if(option == 1){
                    System.out.print("Please enter your password: "); String passwordForBalanceEnquiry = sc.next();
                    String outcome = newCustomer.fetchBalance(passwordForBalanceEnquiry);
                    System.out.println(outcome);
                    System.out.println();
                    System.out.print("Do another transaction. Type 'Yes' or 'No': "); anotherTransaction = sc.next();
                    if(anotherTransaction.equals("Yes") || anotherTransaction.equals("yes")){
                        continue;
                    }
                    break;
                } else if(option == 2){
                    System.out.print("Please enter amount: "); double amountToCredit = sc.nextDouble();
                    String outcome = newCustomer.addMoney(amountToCredit);
                    System.out.println(outcome);
                    System.out.print("Do another transaction. Type 'Yes' or 'No': "); anotherTransaction = sc.next();
                    if(anotherTransaction.equals("Yes") || anotherTransaction.equals("yes")){
                        continue;
                    }
                    break;
                } else if(option == 3){
                    System.out.println("Please enter your password and amount:");
                    System.out.print("Password: "); String passwordToWithdraw = sc.next();
                    System.out.print("amount: "); double amountToWithdraw = sc.nextDouble();
                    String outcome = newCustomer.withdrawMoney(passwordToWithdraw, amountToWithdraw);
                    System.out.println(outcome);
                    System.out.print("Do another transaction. Type 'Yes' or 'No': "); anotherTransaction = sc.next();
                    if(anotherTransaction.equals("Yes") || anotherTransaction.equals("yes")){
                        continue;
                    }
                    break;
                } else if (option == 4) {
                    System.out.print("Enter your current password: "); String currentPassword = sc.next();
                    System.out.print("Enter new password: "); String newPassword = sc.next();
                    String outcome = newCustomer.changePassword(currentPassword, newPassword);
                    System.out.println(outcome);
                    System.out.print("Do another transaction. Type 'Yes' or 'No': "); anotherTransaction = sc.next();
                    if(anotherTransaction.equals("Yes") || anotherTransaction.equals("yes")){
                        continue;
                    }
                    break;
                } else if(option == 5) {
                    System.out.print("Enter number of years: "); int year = sc.nextInt();
                    double outcome = newCustomer.calculateInterest(year);
                    System.out.println("Total interest on current balance ("+newCustomer.getBalance()+") for "+year+" years is: "+outcome);
                    System.out.print("Do another transaction. Type 'Yes' or 'No': "); anotherTransaction = sc.next();
                    if(anotherTransaction.equals("Yes") || anotherTransaction.equals("yes")){
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Please choose a valid transaction!");
                }
            } */
        }

        if(cus.equals("existing") || cus.equals("Existing")){
            System.out.println("Your account details: ");
            System.out.println("Name: "+oldCustomer.getName()+", Password: "+oldCustomer.getPassword()+", Balance: "+oldCustomer.getBalance());
            System.out.println("Choose your transaction: ");
            System.out.println();
            transaction(oldCustomer);
        }
        System.out.println("Thank you for banking with us!");
    }
    private static void transaction(BOI customer){
        while(true){
            System.out.println("Press 1 for balance enquiry");
            System.out.println("Press 2 to credit amount");
            System.out.println("Press 3 to withdraw amount");
            System.out.println("Press 4 to change password");
            System.out.println("Press 5 to calculate interest");
            int option = sc.nextInt();
            String anotherTransaction = "";
            if(option == 1){
                System.out.print("Please enter your password: "); String passwordForBalanceEnquiry = sc.next();
                String outcome = customer.fetchBalance(passwordForBalanceEnquiry);
                System.out.println(outcome);
                System.out.print("Do another transaction. Type 'Yes' or 'No': "); anotherTransaction = sc.next();
                if(anotherTransaction.equals("Yes") || anotherTransaction.equals("yes")){
                    continue;
                }
                break;
            } else if(option == 2){
                System.out.print("Please enter amount: "); double amountToCredit = sc.nextDouble();
                String outcome = customer.addMoney(amountToCredit);
                System.out.println(outcome);
                System.out.print("Do another transaction. Type 'Yes' or 'No': "); anotherTransaction = sc.next();
                if(anotherTransaction.equals("Yes") || anotherTransaction.equals("yes")){
                    continue;
                }
                break;
            } else if(option == 3){
                System.out.println("Please enter your password and amount:");
                System.out.print("Password: "); String passwordToWithdraw = sc.next();
                System.out.print("amount: "); double amountToWithdraw = sc.nextDouble();
                String outcome = customer.withdrawMoney(passwordToWithdraw, amountToWithdraw);
                System.out.println(outcome);
                System.out.print("Do another transaction. Type 'Yes' or 'No': "); anotherTransaction = sc.next();
                if(anotherTransaction.equals("Yes") || anotherTransaction.equals("yes")){
                    continue;
                }
                break;
            } else if (option == 4) {
                System.out.print("Enter your current password: "); String currentPassword = sc.next();
                System.out.print("Enter new password: "); String newPassword = sc.next();
                String outcome = customer.changePassword(currentPassword, newPassword);
                System.out.println(outcome);
                System.out.print("Do another transaction. Type 'Yes' or 'No': "); anotherTransaction = sc.next();
                if(anotherTransaction.equals("Yes") || anotherTransaction.equals("yes")){
                    continue;
                }
                break;
            } else if(option == 5) {
                System.out.print("Enter number of years: "); int year = sc.nextInt();
                double outcome = customer.calculateInterest(year);
                System.out.println("Total interest on current balance ("+customer.getBalance()+") for "+year+" years is: "+outcome);
                System.out.print("Do another transaction. Type 'Yes' or 'No': "); anotherTransaction = sc.next();
                if(anotherTransaction.equals("Yes") || anotherTransaction.equals("yes")){
                    continue;
                }
                break;
            } else {
                System.out.println("Please choose a valid transaction!");
            }
        }
    }
}