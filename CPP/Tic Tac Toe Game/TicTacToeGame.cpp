/*C++ Program to Develop a Tic-Tac-Toe game that
allows two players to play against each other.*/
//Task 3

#include <iostream>
#include <vector>
using namespace std;

const int SIZE = 3;

void displayBoard(const vector<vector<char>>& board) {
    cout<<"----| Welcome to TIC-TAC-TOE Game |----" << endl;
    cout << "Current board:\n";
    for (int i = 0; i < SIZE; ++i) {
        for (int j = 0; j < SIZE; ++j) {
            cout << board[i][j];
            if (j < SIZE - 1) cout << " | ";
        }
        cout << "\n";
        if (i < SIZE - 1) cout << "--|---|--\n";
    }
}

bool checkWin(const vector<vector<char>>& board, char player) {
    // Check rows and columns
    for (int i = 0; i < SIZE; ++i) {
        if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
            (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
            return true;
        }
    }

    // Check diagonals
    if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
        (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
        return true;
    }

    return false;
}

bool checkDraw(const vector<vector<char>>& board) {
    for (int i = 0; i < SIZE; ++i) {
        for (int j = 0; j < SIZE; ++j) {
            if (board[i][j] == ' ') {
                return false;
            }
        }
    }
    return true;
}

void switchPlayer(char& currentPlayer) {
    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
}

void getPlayerMove(vector<vector<char>>& board, char currentPlayer) {
    int row, col;
    while (true) {
        cout << "Player " << currentPlayer << ", enter your move Row & Column(1-3) respectively: ";
        cin >> row >> col;

        if (row >= 1 && row <= 3 && col >= 1 && col <= 3 && board[row - 1][col - 1] == ' ') {
            board[row - 1][col - 1] = currentPlayer;
            break;
        } else {
            cout << "Invalid move. Please try again.\n";
        }
    }
}

void playGame() {
    vector<vector<char>> board(SIZE, vector<char>(SIZE, ' '));
    char currentPlayer = 'X';
    bool gameWon = false, gameDraw = false;

    while (!gameWon && !gameDraw) {
        displayBoard(board);
        getPlayerMove(board, currentPlayer);
        gameWon = checkWin(board, currentPlayer);
        if (!gameWon) {
            gameDraw = checkDraw(board);
            if (!gameDraw) {
                switchPlayer(currentPlayer);
            }
        }
    }

    displayBoard(board);
    if (gameWon) {
        cout << "Player " << currentPlayer << " wins!\n";
    } else {
        cout << "The game is a draw!\n";
    }
}

int main() {
    char playAgain;
    do {
        playGame();
        cout << "Do you want to play again? (y/n): ";
        cin >> playAgain;
    } while (playAgain == 'y' || playAgain == 'Y');
    return 0;
}
