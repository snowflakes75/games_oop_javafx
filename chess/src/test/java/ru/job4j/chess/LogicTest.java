package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenStrangeMove() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        logic.add(bishopBlack);
        logic.move(bishopBlack.position(), Cell.findBy(0, 6));
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenOutCell() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        logic.add(bishopBlack);
        logic.move(Cell.findBy(-100, -2), Cell.findBy(0, 6));
    }

    @Test(expected = OccupiedCellException.class)
    public void whenGoToNotEmptyCell() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        BishopBlack bishopBlackSec = new BishopBlack(Cell.B2);
        logic.add(bishopBlack);
        logic.add(bishopBlackSec);
        logic.move(bishopBlack.position(), Cell.C3);
    }
}