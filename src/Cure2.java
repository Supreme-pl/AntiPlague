public class Cure2 extends Thread {

    int cureProgress = -1;

    @Override
    public void run() {
        while (this.isAlive()) {
            if (cureProgress<100)
            cureProgress++;
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
