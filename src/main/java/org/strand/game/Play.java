package org.strand.game;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Play {

    private final GameRules gameRules;
    private final Controller controller;
    private final int period;
    private final ScheduledExecutorService scheduledExecutorService;

    public Play(Controller controller, Playground playground, GameRules gameRules, int period) {
        this.gameRules = gameRules;
        this.controller = controller;
        this.period = period;
        controller.setPlayground(playground);
        controller.setGameRules(gameRules);
        scheduledExecutorService = Executors.newScheduledThreadPool(1);
    }

    public void start() {
        Runnable play = () -> {
            display();
            if(controller instanceof SimpleController) {
                applyRules();
            }
        };

        scheduledExecutorService.scheduleAtFixedRate(play, 50, period, TimeUnit.MILLISECONDS);
    }

    public void display() {
        controller.displayPlayground();
    }

    public void applyRules() {
        gameRules.applyRules();
    }
}
