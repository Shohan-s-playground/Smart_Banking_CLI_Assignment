import java.util.Scanner;

public class BankingAppAssignment {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "Welcome to SMART  BANKING";
        final String CREATE_ACCOUNT = "Create New Account";
        final String DEPOSIT = "Deposit";
        final String WITHDRAW = "Withdraw";
        final String TRANSFER = "Transfer";
        final String CHECK_AC_BALANCE = "Check Account Balance";
        final String DELETE_ACCOUNT= "Delete Account";

        String[] acholnames = new String[0];
        String screen = DASHBOARD;
        String[] accid = new String[0];

        do {
            final String APP_TITLE = String.format("%s%s%s",
                                COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("-".repeat(30));
            System.out.println(" ".repeat((30 - APP_TITLE.length() + 7)/2).concat(APP_TITLE));
            System.out.println("-".repeat(30));

            switch(screen){
                case DASHBOARD: 
                    System.out.println("\n[1]. Create New Account");
                    System.out.println("[2]. Deposit");
                    System.out.println("[3]. Withdraw");
                    System.out.println("[4]. Transfer");
                    System.out.println("[5]. Check Account balance");
                    System.out.println("[6]. Delete Account");
                    System.out.println("[7]. Exit\n");
                    System.out.print("Enter an option to continue > ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();

                    switch (option){
                        case 1: screen = CREATE_ACCOUNT; break;
                        case 2: screen = DEPOSIT; break;
                        case 3: screen = WITHDRAW; break;
                        case 4: screen = TRANSFER; break;
                        case 5: screen = CHECK_AC_BALANCE; break;
                        case 6: screen = DELETE_ACCOUNT; break;
                        case 7: System.exit(0); break;
                        default: continue;
                    }
                    break;

                    case CREATE_ACCOUNT:
                    System.out.printf("New Account ID: SDB-%06d \n", (accid.length + 1));

                    boolean valid;
                    String acholname;
                    int initialdepo;
                    do{
                        valid = true;
                        System.out.print("Enter Account Holder's Name: ");
                        acholname = SCANNER.nextLine().strip();
                        if (acholname.isBlank()){
                            System.out.printf("%sName can't be empty%s\n", COLOR_RED_BOLD, RESET);
                            valid = false;
                            continue;
                        }
                        for (int i = 0; i < acholname.length(); i++) {
                            if (!(Character.isLetter(acholname.charAt(i)) || 
                                Character.isSpaceChar(acholname.charAt(i))) ) {
                                System.out.printf("%sInvalid Name Type%s\n", COLOR_RED_BOLD, RESET);
                                valid = false;
                                break;
                            }
                        }
                    }while(!valid);

                    do{
                        
                        valid = true;
                        System.out.print("Enter Initial DEposit Amount: ");
                        initialdepo = SCANNER.nextInt();
                        if (initialdepo<5000){
                            System.out.printf("%sInsufficient Initial Deposit Amount:You should deposit at least RS.5000 as initial amount%s\n", COLOR_RED_BOLD, RESET);
                            valid = false;
                            continue;
                        }
                        
                    }while(!valid);
                            


        }

    }while(true);
        

}
}