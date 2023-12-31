import java.util.Scanner;

public class BankingAppAssignment {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "\u1F477 WELCOME TO SMART  BANKING";
        final String CREATE_ACCOUNT = "\u2795 Create New Account";
        final String DEPOSIT = "Deposit";
        final String WITHDRAW = "Withdraw";
        final String TRANSFER = "Transfer";
        final String CHECK_AC_BALANCE = "Check Account Balance";
        final String DELETE_ACCOUNT= "Delete Account";

        String[] acholnames = new String[0];
        String screen = DASHBOARD;
        int[] initialdepos=new int[0];
        String[] accids = new String[0];

        do {
            
            final String APP_TITLE = String.format("%s%s%s",COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

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
                        case 7: System.out.println(CLEAR);System.exit(0);break;
                        default:continue;
                    }
                    break;

                    case CREATE_ACCOUNT:
                    String accid = String.format("SDB-%06d", (accids.length+1));

                    System.out.println("New Account ID: "+accid);

                    boolean valid;
                    String acholname;
                    int initialdepo;
                    String [] newaccids = new String [accids.length + 1];
                    for (int i = 0; i < accids.length; i++) {
                        newaccids[i] = accids[i];
                    }
                    newaccids[newaccids.length - 1] = accid;
                    accids = newaccids;
                    
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

                    String[] newacholnames = new String[acholnames.length + 1];
                    for (int i = 0; i < acholnames.length; i++) {
                        newacholnames[i] = acholnames[i];
                    }
                    newacholnames[newacholnames.length - 1] = acholname;
                    acholnames = newacholnames;

                    do{
                        
                        valid = true;
                        System.out.print("Enter Initial Deposit Amount: ");
                        initialdepo = SCANNER.nextInt();
                        if (initialdepo<5000){
                            System.out.printf("%sInsufficient Initial Deposit Amount:You should deposit at least RS.5000 as initial amount%s\n", COLOR_RED_BOLD, RESET);
                            valid = false;
                            continue;
                        }
                        
                    }while(!valid);
                    int [] newinitialdepos = new int [initialdepos.length + 1];
                    for (int i = 0; i < initialdepos.length; i++) {
                        newinitialdepos[i] = initialdepos[i];
                    }
                    newinitialdepos[newinitialdepos.length - 1] = initialdepo;
                    initialdepos = newinitialdepos;
                    

                    System.out.println();
                    System.out.print(accid+":"+acholname + " created an account sucessfully. Do you want to add new student (Y/n)? ");
                    String response=SCANNER.nextLine().strip().toUpperCase();

                    if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    break;
                    
                default:
                    System.exit(0);


        }

    }while(true);
        

}
}