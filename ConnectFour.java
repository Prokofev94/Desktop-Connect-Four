package four;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ConnectFour extends JFrame {
    String turn = "X";
    JPanel playingField = new JPanel(new GridLayout(6, 7, 0, 0));
    JButton[][] cells;
    int[] columns = new int[7];

    public ConnectFour() {
        super("Connect 4");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel resetPanel = new JPanel();
        resetPanel.setLayout(new BoxLayout(resetPanel, BoxLayout.LINE_AXIS));
        resetPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(resetPanel, BorderLayout.SOUTH);
        JButton reset = new JButton("Reset");
        reset.addActionListener((e) -> {
            for (JButton[] line : cells) {
                for (JButton cell : line) {
                    cell.setText(" ");
                    cell.setBackground(Color.LIGHT_GRAY);
                    cell.setEnabled(true);
                }
            }
            turn = "X";
            Arrays.fill(columns, 6);
            setVisible(true);
        });
        reset.setName("ButtonReset");
        reset.setEnabled(true);
        resetPanel.add(reset);

        add(playingField);
        initGameBoard(playingField);

        setVisible(true);
    }

    void initGameBoard(JPanel playingField) {
        Arrays.fill(columns, 6);
        cells = new JButton[6][7];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                String name = "Button" + (char) ('A' + j) + (6 - i);
                JButton button = new JButton(" ");
                button.setBackground(Color.LIGHT_GRAY);
                cells[i][j] = button;
                int col = j;
                button.addActionListener((e) -> {
                    if (columns[col] > 0) {
                        columns[col]--;
                        cells[columns[col]][col].setText(turn);
                        if (isWin()) {
                            for (JButton[] line : cells) {
                                for (JButton cell : line) {
                                    cell.setEnabled(false);
                                }
                            }
                        }
                        turn = turn.equals("X") ? "O" : "X";
                    }
                });
                button.setName(name);
                playingField.add(button);
            }
        }
    }

    public boolean isWin() {
        return inRow(cells[0][0], cells[0][1], cells[0][2], cells[0][3]) ||
                inRow(cells[0][1], cells[0][2], cells[0][3], cells[0][4]) ||
                inRow(cells[0][2], cells[0][3], cells[0][4], cells[0][5]) ||
                inRow(cells[0][3], cells[0][4], cells[0][5], cells[0][6]) ||
                inRow(cells[1][0], cells[1][1], cells[1][2], cells[1][3]) ||
                inRow(cells[1][1], cells[1][2], cells[1][3], cells[1][4]) ||
                inRow(cells[1][2], cells[1][3], cells[1][4], cells[1][5]) ||
                inRow(cells[1][3], cells[1][4], cells[1][5], cells[1][6]) ||
                inRow(cells[2][0], cells[2][1], cells[2][2], cells[2][3]) ||
                inRow(cells[2][1], cells[2][2], cells[2][3], cells[2][4]) ||
                inRow(cells[2][2], cells[2][3], cells[2][4], cells[2][5]) ||
                inRow(cells[2][3], cells[2][4], cells[2][5], cells[2][6]) ||
                inRow(cells[3][0], cells[3][1], cells[3][2], cells[3][3]) ||
                inRow(cells[3][1], cells[3][2], cells[3][3], cells[3][4]) ||
                inRow(cells[3][2], cells[3][3], cells[3][4], cells[3][5]) ||
                inRow(cells[3][3], cells[3][4], cells[3][5], cells[3][6]) ||
                inRow(cells[4][0], cells[4][1], cells[4][2], cells[4][3]) ||
                inRow(cells[4][1], cells[4][2], cells[4][3], cells[4][4]) ||
                inRow(cells[4][2], cells[4][3], cells[4][4], cells[4][5]) ||
                inRow(cells[4][3], cells[4][4], cells[4][5], cells[4][6]) ||
                inRow(cells[5][0], cells[5][1], cells[5][2], cells[5][3]) ||
                inRow(cells[5][1], cells[5][2], cells[5][3], cells[5][4]) ||
                inRow(cells[5][2], cells[5][3], cells[5][4], cells[5][5]) ||
                inRow(cells[5][3], cells[5][4], cells[5][5], cells[5][6]) ||
                inRow(cells[0][0], cells[1][0], cells[2][0], cells[3][0]) ||
                inRow(cells[1][0], cells[2][0], cells[3][0], cells[4][0]) ||
                inRow(cells[2][0], cells[3][0], cells[4][0], cells[5][0]) ||
                inRow(cells[0][1], cells[1][1], cells[2][1], cells[3][1]) ||
                inRow(cells[1][1], cells[2][1], cells[3][1], cells[4][1]) ||
                inRow(cells[2][1], cells[3][1], cells[4][1], cells[5][1]) ||
                inRow(cells[0][2], cells[1][2], cells[2][2], cells[3][2]) ||
                inRow(cells[1][2], cells[2][2], cells[3][2], cells[4][2]) ||
                inRow(cells[2][2], cells[3][2], cells[4][2], cells[5][2]) ||
                inRow(cells[0][3], cells[1][3], cells[2][3], cells[3][3]) ||
                inRow(cells[1][3], cells[2][3], cells[3][3], cells[4][3]) ||
                inRow(cells[2][3], cells[3][3], cells[4][3], cells[5][3]) ||
                inRow(cells[0][4], cells[1][4], cells[2][4], cells[3][4]) ||
                inRow(cells[1][4], cells[2][4], cells[3][4], cells[4][4]) ||
                inRow(cells[2][4], cells[3][4], cells[4][4], cells[5][4]) ||
                inRow(cells[0][5], cells[1][5], cells[2][5], cells[3][5]) ||
                inRow(cells[1][5], cells[2][5], cells[3][5], cells[4][5]) ||
                inRow(cells[2][5], cells[3][5], cells[4][5], cells[5][5]) ||
                inRow(cells[0][6], cells[1][6], cells[2][6], cells[3][6]) ||
                inRow(cells[1][6], cells[2][6], cells[3][6], cells[4][6]) ||
                inRow(cells[2][6], cells[3][6], cells[4][6], cells[5][6]) ||
                inRow(cells[2][0], cells[3][1], cells[4][2], cells[5][3]) ||
                inRow(cells[1][0], cells[2][1], cells[3][2], cells[4][3]) ||
                inRow(cells[2][1], cells[3][2], cells[4][3], cells[5][4]) ||
                inRow(cells[0][0], cells[1][1], cells[2][2], cells[3][3]) ||
                inRow(cells[1][1], cells[2][2], cells[3][3], cells[4][4]) ||
                inRow(cells[2][2], cells[3][3], cells[4][4], cells[5][5]) ||
                inRow(cells[0][1], cells[1][2], cells[2][3], cells[3][4]) ||
                inRow(cells[1][2], cells[2][3], cells[3][4], cells[4][5]) ||
                inRow(cells[2][3], cells[3][4], cells[4][5], cells[5][6]) ||
                inRow(cells[0][2], cells[1][3], cells[2][4], cells[3][5]) ||
                inRow(cells[1][3], cells[2][4], cells[3][5], cells[4][6]) ||
                inRow(cells[0][3], cells[1][4], cells[2][5], cells[3][6]) ||
                inRow(cells[3][0], cells[2][1], cells[1][2], cells[0][3]) ||
                inRow(cells[4][0], cells[3][1], cells[2][2], cells[1][3]) ||
                inRow(cells[3][1], cells[2][2], cells[1][1], cells[0][4]) ||
                inRow(cells[5][0], cells[4][1], cells[3][2], cells[2][3]) ||
                inRow(cells[4][1], cells[3][2], cells[2][3], cells[1][4]) ||
                inRow(cells[3][2], cells[2][3], cells[1][4], cells[0][5]) ||
                inRow(cells[5][1], cells[4][2], cells[3][3], cells[2][4]) ||
                inRow(cells[4][2], cells[3][3], cells[2][4], cells[1][5]) ||
                inRow(cells[3][3], cells[2][4], cells[1][5], cells[0][6]) ||
                inRow(cells[5][2], cells[4][3], cells[3][4], cells[2][5]) ||
                inRow(cells[4][3], cells[3][4], cells[2][5], cells[1][6]) ||
                inRow(cells[5][3], cells[4][4], cells[3][5], cells[2][6]);
    }

    public boolean inRow(JButton b1, JButton b2, JButton b3, JButton b4) {
        boolean win = turn.equals(b1.getText()) &&
                turn.equals(b2.getText()) &&
                turn.equals(b3.getText()) &&
                turn.equals(b4.getText());
        if (win) {
            b1.setBackground(Color.CYAN);
            b2.setBackground(Color.CYAN);
            b3.setBackground(Color.CYAN);
            b4.setBackground(Color.CYAN);
            setVisible(true);
        }
        return win;
    }

    public static void main(String[] args) {
        new ConnectFour();
    }
}