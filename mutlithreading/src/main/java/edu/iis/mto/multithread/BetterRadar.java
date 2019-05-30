package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private int numberOfRocketsToLaunch;

    public BetterRadar(PatriotBattery battery, int numberOfRocketsToLaunch) {
        this.battery = battery;
        this.numberOfRocketsToLaunch = numberOfRocketsToLaunch;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < numberOfRocketsToLaunch; i++) {
                    battery.launchPatriot();
                }
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}
