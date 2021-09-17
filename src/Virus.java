public class Virus extends Thread {
    int virusProgress;
    boolean isCancelled = false;
    @Override
    public void run() {
        while (!isCancelled) {
            while (this.isAlive()) {
                while (this.virusProgress < 520600000) {
                    if (this.virusProgress < 10000)
                        this.virusProgress = (int) (virusProgress + (Math.random()) * 1000);
                    else if (this.virusProgress < 200000)
                        this.virusProgress = (int) (virusProgress + (Math.random()) * 10000);
                    else if (this.virusProgress < 1000000)
                        this.virusProgress = (int) (virusProgress + (Math.random()) * 50000);
                    else if (this.virusProgress < 10000000)
                        this.virusProgress = (int) (virusProgress + (Math.random()) * 100000);
                    else if (this.virusProgress < 100000000)
                        this.virusProgress = (int) (virusProgress + (Math.random()) * 1000000);
                    else
                        this.virusProgress = (int) (virusProgress + (Math.random()) * 10000000);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public int getVirusProgress() {
        return virusProgress;
    }

    public void setVirusProgress(int virusProgress) {
        this.virusProgress = virusProgress;
    }

    public void cancel() {
        isCancelled = true;
    }

    //upgrades

    public int upgrade5() {
        return (int) ((virusProgress*0.05)/10);
    }

    public void upgrade10() {
        virusProgress = (int) (virusProgress - virusProgress*0.1);
    }

    public void upgrade20() {
        virusProgress = (int) (virusProgress - virusProgress*0.2);
    }

    public void upgrade30() {
        virusProgress = (int) (virusProgress - virusProgress*0.3);
    }

    public void upgrade50() {
        virusProgress = (int) (virusProgress - virusProgress*0.5);
    }

    public Virus() {
    }
}
