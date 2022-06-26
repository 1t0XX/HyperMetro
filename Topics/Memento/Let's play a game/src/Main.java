import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Don't touch it, it's already in use!        
interface GameEngine {

    void place(char entity, int x, int y);

    void move(int fromX, int fromY, int toX, int toY);

    void undo();

    void save();

    void load();

    void reDraw();
}

// this class is finished for now, no changes to board logic please
class Board {
    private static final char EMPTY = ' ';
    private char[][] squares;

    Board(int width, int height) {
        squares = new char[height][width];
        Arrays.stream(squares).forEach(row -> Arrays.fill(row, EMPTY));
    }

    public void place(char gamePiece, int col, int row) {
        squares[row - 1][col - 1] = gamePiece;
    }

    public void move(int fromCol, int fromRow, int toCol, int toRow) {
        char gamePiece = squares[fromRow - 1][fromCol - 1];
        squares[fromRow - 1][fromCol - 1] = EMPTY;
        squares[toRow - 1][toCol - 1] = gamePiece;
    }

    @Override
    public String toString() {
        return IntStream
                .iterate(squares.length - 1, i -> i >= 0, i -> i - 1)
                .mapToObj(i -> squares[i])
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public Snapshot getSnapshot() {
        return new Snapshot(Arrays.stream(squares)
                .map(char[]::clone)
                .toArray(char[][]::new));
    }

    public void setStateFrom(Snapshot board) {
        this.squares = board.board;
    }

    // It's for saving board state. If you're going to change it, 
    // don't forget to update the methods above
    static class Snapshot {
        private final char[][] board;

        private Snapshot(char[][] board) {
            this.board = board.clone();
        }
    }
}

// Finish this class implementation. You can modify it 
// as you need but don't break anything!
class BoardGameEngine implements GameEngine {
    private final Board board;

    BoardGameEngine(int boardWidth, int boardHeight) {
        board = new Board(boardWidth, boardHeight);
    }

    @Override
    public void place(char gamePiece, int col, int row) {
        board.place(gamePiece, col, row);
    }

    @Override
    public void move(int fromCol, int fromRow, int toCol, int toRow) {
        board.move(fromCol, fromRow, toCol, toRow);
    }

    @Override
    public void undo() {
        // TODO
    }

    @Override
    public void save() {
        // TODO
    }

    @Override
    public void load() {
        // TODO
    }

    @Override
    public void reDraw() {
        System.out.println(board);
    }
}