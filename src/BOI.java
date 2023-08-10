import java.util.UUID;

public class BOI implements BankAccount{
    private String name;
    private String accountNumber;
    private String password;
    private double balance;
    final double interestRate = 6.5;
    final String IFSCCode = "BOI007";

    public BOI() {

    }

    public BOI(String name, String password, double balance) {
        if (balance >= 5000) {
            this.name = name;
            this.password = password;
            this.balance = balance;
            String pas = String.valueOf(UUID.randomUUID());
            String finalPas = "";
            for(char c : pas.toCharArray()){
                if(Character.isDigit(c)) finalPas += c;
            }
            this.accountNumber = finalPas.substring(0, 6);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password)){
            return "Your current balance is: "+ this.balance;
        }
        return "Incorrect password";
    }

    @Override
    public String addMoney(double amount) {
        if(amount > 0){
            this.balance += amount;
            return "Amount added successfully. Your current balance is: " + this.balance;
        }
        return "Please enter a valid amount";
    }

    @Override
    public String withdrawMoney(String password, double amount) {
        if(this.password.equals(password)){
            if(this.balance < amount + 5000){
                return "Please enter a valid amount";
            }
            this.balance -= amount;
            return "Balance deducted successfully. Your remaining balance is: "+ this.balance;
        }
        return "Invalid password!";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(oldPassword.equals(this.password)){
            this.password = newPassword;
            return "Password changed successfully.";
        }
        return "Invalid current password!";
    }

    @Override
    public double calculateInterest(int year) {
        double interest = (this.balance * year * interestRate) / 100;
        return interest;
    }

    @Override
    public String toString() {
        return "BOI{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }
}

