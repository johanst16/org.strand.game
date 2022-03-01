package org.strand.game;

public class SimpleController implements Controller {

    private Playground playground;

    @Override
    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    @Override
    public void setGameRules(GameRules gameRules) {
    }

    @Override
    public void displayPlayground() {
        Cell[][] content = playground.getContent();
        for (Cell[] row : content) {
            StringBuilder sb = new StringBuilder();
            for (Cell cell : row) {
                sb.append(cell.getState() ? "#" : " ");
            }
            System.out.println(sb);
        }
    }

}