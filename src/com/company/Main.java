package com.company;
import java.util.Scanner;
public class Main {
    private static Scanner in;
    private static float balance=0;
    // initial balance to 0 for everyone
    private static int anotherTransaction;
    static String userName="MacTronics";


    public static void main(String[] args) {

        String password="002211";
        String bankName="Macaulay's Finance Bank";

        in=new Scanner(System.in);
        System.out.println("Welcome To " + bankName);

        System.out.println("Please Enter Your Pin Number ");
        String enteredPassword=in.nextLine();
        if (enteredPassword.equalsIgnoreCase(password)) {
            transaction();
    }else {
            System.out.println("Incorrect password ");
            anotherTransaction();
        }
    }
    private static void transaction(){
        int choice;
        System.out.println("Account Name Holder:" + userName);
        System.out.println("Please select an option");
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.Balance");

        choice=in.nextInt();

        switch (choice){
            case 1:
                float amount;
                System.out.println("Please enter amount to withdraw: ");
                amount=in.nextFloat();
                if (amount>balance|| amount==0){
                System.out.println("You have insufficient funds\n\n");
                // ask if they want another transaction
                anotherTransaction();
            } else{
                balance=balance-amount;
                System.out.println("You have withdrawn: " +amount+"and your new balance is: "+balance+"\n");
                anotherTransaction();
            }
            break;
            case 2:
                float deposit;
                System.out.println("Please enter amount you would wish to deposit: ");
                deposit=in.nextFloat();
                balance=deposit+balance;
                System.out.println("You have deposited: "+deposit+"new balance is: "+balance+"\n");
                anotherTransaction();
                break;
            case 3:
                System.out.println("Your balance is: "+balance+"\n");
                anotherTransaction();
                break;
            default:
                System.out.println("invalid option:\n\n");
                anotherTransaction();
                break;


        }
    }
    private static void anotherTransaction(){
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        anotherTransaction=in.nextInt();
        if (anotherTransaction==1){
            transaction();

        }else if (anotherTransaction==2){
            System.out.println("Thanks for choosing us. Good Bye!");
        }else {
            System.out.println("Invalid Choice\n\n");
            anotherTransaction();
        }
    }
}
