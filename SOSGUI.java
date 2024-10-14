import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SOSGUI {
    private SOSGame game;
    private JButton[][] buttons;
    private JComboBox<String> letterChoice;
    private JComboBox<String> gameMode;
    private JTextField boardSizeTextField;

    public SOSGUI(){
        setTitle("SOS Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 2));

        controlPanel.add(new JLabel("Board Size: "));
        boardSizeTextField = new JTextField();
        controlPanel.add(boardSizeTextField);

        controlPanel.add(new JLabel("Game Mode: "));
        gameMode = new JComboBox<>(new String[]{"Simple", "General"});
        controlPanel.add(gameMode);

        controlPanel.add(new JLabel("Choose S or O: "));
        letterChoice = new JComboBox<>(new String[]{"S", "O"});
        controlPanel.add(letterChoice);

        JButton startButton = new JButton("Start Game");
        controlPanel.add(startButton);
        add(controlPanel, BorderLayout.NORTH);

        startButton.addActionListener((ActionEvent e) -> {
            int boardSize = Integer.parseInt(boardSizeTextField.getText());
            SOSGame.GameMode mode = gameMode.getSelectedIndex() == 0 ? 
                SOSGame.GameMode.SIMPLE : SOSGame.GameMode.GENERAL;
            game = new SOSGame(boardSize, mode);
            initializeBoard(boardSize);
        });
    }

    private void initializeBoard(int boardSize) {
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(boardSize, boardSize));
        buttons = new JButton[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String letter = (String) letterChoice.getSelectedItem();
                }
               
