package org.strand.game.test;

import org.junit.Assert;
import org.junit.Test;
import org.strand.game.Cell;

public class CellTest {


    @Test
    public void createCellAndChangeState() {
        Cell cell = new Cell();
        Assert.assertFalse(cell.getState());
        cell.setNextState(true);
        Assert.assertFalse(cell.getState());
        cell.changeState();
        Assert.assertTrue(cell.getState());
    }
}
