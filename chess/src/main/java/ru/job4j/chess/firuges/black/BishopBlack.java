package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        };
        int size = dest.x - this.position.x;
        Cell[] steps = new Cell[size];
        int indexX = position.x;
        int indexY = position.y;
        int deltaX = dest.x < indexX ? -1 : 1;
        int deltaY = dest.y < indexY ? -1 : 1;
        for (int index = 0; index < size; index++) {
            indexX = indexX + deltaX;
            indexY = indexY + deltaY;
            steps[index] = Cell.findBy(indexX, indexY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
