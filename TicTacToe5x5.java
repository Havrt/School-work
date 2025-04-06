import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToe5x5 extends Application {
    private static final int SIZE = 5;
    private static final int WIN_LENGTH = 5;
    
    private Button[][] buttons = new Button[SIZE][SIZE];
    private char currentPlayer = 'X';
    private Label statusLabel = new Label("Player X's turn");
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        
        // Status label at the top
        statusLabel.setFont(new Font(20));
        BorderPane.setAlignment(statusLabel, Pos.CENTER);
        root.setTop(statusLabel);
        
        // Game board in the center
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Button button = new Button();
                button.setFont(new Font(24));
                button.setMinSize(60, 60);
                button.setOnAction(e -> handleButtonClick(button, row, col));
                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }
        
        root.setCenter(gridPane);
        
        // Reset button at the bottom
        Button resetButton = new Button("Reset Game");
        resetButton.setOnAction(e -> resetGame());
        BorderPane.setAlignment(resetButton, Pos.CENTER);
        root.setBottom(resetButton);
        
        Scene scene = new Scene(root, 400, 450);
        primaryStage.setTitle("5x5 Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void handleButtonClick(Button button, int row, int col) {
        if (button.getText().isEmpty()) {
            button.setText(String.valueOf(currentPlayer));
            
            if (checkWin(row, col)) {
                showWinner(currentPlayer);
                return;
            }
            
            if (isBoardFull()) {
                showDraw();
                return;
            }
            
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            statusLabel.setText("Player " + currentPlayer + "'s turn");
        }
    }
    
    private boolean checkWin(int row, int col) {
        return checkDirection(row, col, 1, 0) ||  // Horizontal
               checkDirection(row, col, 0, 1) ||  // Vertical
               checkDirection(row, col, 1, 1) ||  // Diagonal \
               checkDirection(row, col, 1, -1);   // Diagonal /
    }
    
    private boolean checkDirection(int row, int col, int dRow, int dCol) {
        int count = 1;  // Count the current cell
        
        // Check in the positive direction
        count += countConsecutive(row, col, dRow, dCol);
        
        // Check in the negative direction
        count += countConsecutive(row, col, -dRow, -dCol);
        
        return count >= WIN_LENGTH;
    }
    
    private int countConsecutive(int row, int col, int dRow, int dCol) {
        int count = 0;
        char player = currentPlayer;
        int r = row + dRow;
        int c = col + dCol;
        
        while (r >= 0 && r < SIZE && c >= 0 && c < SIZE && 
               buttons[r][c].getText().equals(String.valueOf(player))) {
            count++;
            r += dRow;
            c += dCol;
        }
        
        return count;
    }
    
    private boolean isBoardFull() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (buttons[row][col].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void showWinner(char player) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("Player " + player + " wins!");
        alert.showAndWait();
        statusLabel.setText("Player " + player + " wins!");
        disableAllButtons();
    }
    
    private void showDraw() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("It's a draw!");
        alert.showAndWait();
        statusLabel.setText("Game ended in a draw!");
    }
    
    private void disableAllButtons() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                buttons[row][col].setDisable(true);
            }
        }
    }
    
    private void resetGame() {
        currentPlayer = 'X';
        statusLabel.setText("Player X's turn");
        
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setDisable(false);
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}