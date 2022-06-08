package synch2;


public class SynchBankTest {
    public static final int NACCOUNTS = 10;
    public static double INITIAL_BALANCE = 1000;
    public static final int DELAY = 10;
    public static final double MAX_AMOUNT = 2000;

    public static void main(String[] args) {
        var bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        //bank.transfer(fromAccount, toAccount, amount);
                        bank.transfer(toAccount, fromAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            var t = new Thread(r);
            t.start();
        }
    }
}
