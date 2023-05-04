/*ATM class has 7 methods namely checkpin(),dashboard(),transactionHistory(),moneyTransfer(),WithDrawal(),BalanceInquiry(),Deposit().
checkpin()-->Checks if the entered pin is valid or not. If it is valid then it calls dashboard().

dashboard()-->Takes the user choice and respective function is called.

BalanceInquiry()--->Prints the balance amount in the account.

WithDrawal()-->User enters the amount he wants to withdraw. If there is no valid denomination,then withdrawal or if the 
amount exceeds the balance in the account ,withdrawal is not possible.Otherwise amount will be deducted from account balance and 
withdrawal is succesful.

Deposit()-->User enters the amount he wants to deposit.If there is no valid denomination,then money deposit is
not possible.Otherwise amount gets added to bank account and deposit is succesful.

moneyTransfer()-->WOrks similar to WithDrawal but money gets transferred to other bank account.

transactionHistory()->Map datastructure keeps track of transactionnumber(Key) and balance in account(Value).All the 
withdrawals and deposit history are updated in map datastructure everytime.
*/
import java.util.*;
class ATM{
    float balance;
    int PIN=8692;
    int count=0;
    HashMap<Integer,Float>map=new HashMap<>();
    public void checkpin(){
        System.out.print("Please enter your pin:");
        Scanner obj=new Scanner(System.in);
        int pin=obj.nextInt();
        if(pin==PIN){
            dashboard();
        }
        else{
            System.out.println("Please enter a valid pin");
            checkpin();
        }
    }
    public void dashboard(){
        System.out.println("Enter your choice");
        System.out.println("1.Check a/c balance");
        System.out.println("2.Withdrawal");
        System.out.println("3.Deposit money");
        System.out.println("4.Transfer money");
        System.out.println("5.Transaction history");
        System.out.println("6.Exit");
        Scanner obj=new Scanner(System.in);
        int opt=obj.nextInt();
        if(opt==1){
            BalanceInquiry();
        }
        else if(opt==2){
           WithDrawal();
        }
        else if(opt==3){
           Deposit();
        }
        else if(opt==4){
           MoneyTransfer();
        }
        else if(opt==5)
            transactionHistory();
        else if(opt==6)
            return;
        else{
           dashboard();
        }
    }
    public void transactionHistory(){
        for(Map.Entry<Integer,Float>entry:map.entrySet()){
            int num=entry.getKey();
            float transaction_amount=entry.getValue();
            if(transaction_amount>0){
                System.out.println("Transaction "+num+":Deposit of "+transaction_amount);
            }
            else{
                System.out.println("Transaction "+num+":Withdrawal of "+(-transaction_amount));
            }
        }
        dashboard();
    }
    public void MoneyTransfer(){
        System.out.println("Please enter account Number");
        try (Scanner obj = new Scanner(System.in)) {
            int accnum=obj.nextInt();
            System.out.println("Please enter the amount you want to transfer");
            float amount=obj.nextFloat();
            if(amount%10!=0){
                System.out.println("Please enter valid amount");
            }
            else if(amount>balance){
                System.out.println("Insufficient Funds");
            }
            else{
                balance=balance-amount;
                count++;
                map.put(count,-amount);
                System.out.println("Transfer Succesful");
            }
        }
        dashboard();

    }

    public void BalanceInquiry(){
        System.out.println("Balance Amount:"+balance);
        dashboard();
    }
    public void WithDrawal(){
        System.out.println("enter amount to withdraw:");
        Scanner obj=new Scanner(System.in);
        float amount=obj.nextFloat();
        if(amount%10!=0){
            System.out.println("Please enter valid amount");
        }
        else if(amount>balance){
            System.out.println("Insufficient Funds");
        }
        else{
            balance=balance-amount;
            count++;
            map.put(count,-amount);
            System.out.println("Withdrawal Succesful");
        }
        dashboard();
    }
    public void Deposit(){
        System.out.println("Please enter the amount:");
        Scanner obj=new Scanner(System.in);
        float amount=obj.nextInt();
        if(amount%10!=0){
            System.out.println("Please enter a valid amount");
        }
        else{
        balance+=amount;
        count++;
        map.put(count,amount);
        System.out.println("Deposited succesfully");
        }
        dashboard();
    }
}
public class ATMinterface {
    public static void main(String args[]){
        ATM Obj=new ATM();
        Obj.checkpin();
    }
}
