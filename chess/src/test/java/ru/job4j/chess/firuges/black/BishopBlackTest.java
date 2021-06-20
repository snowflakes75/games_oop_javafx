package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void whenPositionStartThenSame() {
        Figure figure = new BishopBlack(Cell.A1);
        assertThat(figure.position(), is(Cell.A1));
    }

    @Test
    public void whenCopyThenSamePosition() {
        Figure figure = new BishopBlack(Cell.A1);
        assertThat(figure.copy(Cell.A2).position(), is(Cell.A2));
    }

    @Test
    public void whenWayC1G5Then4Point() throws ImpossibleMoveException {
        Figure figure = new BishopBlack(Cell.C1);
        Cell[] points = figure.way(Cell.G5);
        Cell[] excepted = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(points, is(excepted));
    }
}