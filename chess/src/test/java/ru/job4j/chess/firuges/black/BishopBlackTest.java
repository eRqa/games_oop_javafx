package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void way() throws ImpossibleMoveException {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] actWay = bishop.way(Cell.G5);
        Cell[] expectedWay = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(actWay, is(expectedWay));
    }
    @Test(expected = ImpossibleMoveException .class)
    public void whenNotDiagonalWay() throws ImpossibleMoveException {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] actWay = bishop.way(Cell.G7);
    }

    @Test
    public void position() {
        Cell expectedPosition = Cell.C1;
        BishopBlack bishop = new BishopBlack(expectedPosition);
        Cell actPosition = bishop.position();
        assertThat(actPosition, is(expectedPosition));

    }

    @Test
    public void copy() {
        Figure bishopB4 = new BishopBlack(Cell.B4);
        Figure bishopD6 = bishopB4.copy(Cell.D6);
        assertThat(bishopD6.position(), is(Cell.D6));
        assertThat(bishopB4.position(), is(Cell.B4));
    }
}