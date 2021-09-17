public class Cure extends Thread {

    int cureProgress = -1;

    @Override
    public void run() {
        while (this.isAlive()) {
            if (cureProgress<100)
            cureProgress++;
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
