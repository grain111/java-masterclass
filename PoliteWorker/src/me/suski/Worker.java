package me.suski;

public class Worker {

    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(SharedResource sharedResource,
                                  Worker otherWorker) {
        while (active) {
            if (sharedResource.getOwner() != this) {
                try {
                    wait(10);
                } catch (InterruptedException e) {

                }
                continue;
            }

            if (otherWorker.isActive()) {
                System.out.format("%s : give the resource to the worker %s\n",
                        getName(), otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }
            System.out.printf("%s : working on the common resource\n", getName());
            active = false;
            sharedResource.setOwner(otherWorker);
        }
    }
}
