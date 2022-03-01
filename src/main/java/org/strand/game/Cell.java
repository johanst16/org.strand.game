package org.strand.game;

public class Cell {

    private boolean state;
    private boolean nextState;

    public Cell() {
        state = false;
    }

    public Cell(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setNextState(boolean nextState) {
        this.nextState = nextState;
    }

    public void changeState() {
        state = nextState;
    }

}