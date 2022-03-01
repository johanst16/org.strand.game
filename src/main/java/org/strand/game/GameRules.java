package org.strand.game;

import java.util.ArrayList;
import java.util.List;

public class GameRules {

    private final Playground playground;
    private final int playgroundWidth;
    private final int playgroundHeight;
    private Cell[][] content;

    public GameRules(Playground playground) {
        this.playground = playground;
        this.playgroundWidth = playground.getPlaygroundWidth()-1;
        this.playgroundHeight = playground.getPlaygroundHeight()-1;
    }

    public void applyRules() {
        List<Cell> changeList = new ArrayList<>();
        content = playground.getContent();

        for (int h = 0; h < content.length; h++){
            for (int w = 0; w < content[h].length; w++) {
                Cell cell = content[h][w];
                int sumOfNeighbours = countLiveNeighbours(h, w);

                if (sumOfNeighbours < 2) {
                    if(cell.getState()) {
                        cell.setNextState(false);
                        changeList.add(cell);
                    }
                } else if (sumOfNeighbours > 3) {
                    if(cell.getState()) {
                        cell.setNextState(false);
                        changeList.add(cell);
                    }
                } else if (sumOfNeighbours == 3) {
                    if(!cell.getState()) {
                        cell.setNextState(true);
                        changeList.add(cell);
                    }
                }
            }
        }

        if(changeList.size() > 0) {
            changeList.forEach(Cell::changeState);
        }
    }

    public int countLiveNeighbours(int row, int column) {
        int sum = 0;

        int rowStart = row == 0 ? 0 : row-1;
        int rowEnd = Math.min(row + 1, playgroundHeight);
        int columnStart = column == 0 ? 0 : column-1;
        int columnEnd = Math.min(column + 1, playgroundWidth);

        for(int i = rowStart; i <= rowEnd; i++) {
            for(int j = columnStart; j <= columnEnd; j++) {
                if(i != row || j != column) {
                    if(content[i][j].getState()) {
                        sum++;
                    }
                }
            }
        }

        return sum;
    }
}
