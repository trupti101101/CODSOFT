/*C++ Program to develop a code for Guessing the Number from 1 to 100*/
//Task 1
#include <iostream>
#include <cstdlib>
#include <ctime>
#include <climits>
using namespace std;

int main() {
    srand(static_cast<unsigned int>(time(0)));
    char play_again = 'y';

    while (play_again == 'y' || play_again == 'Y') {
        int number_to_guess = rand() % 100 + 1;
        int user_guess = 0;

        cout << "----| Welcome to Number Guessing Game |----" << endl;
        cout << "I have generated a random number between 1 and 100. Try to guess it!" << endl;

        while (true) {
            cout << "Enter your guess (between 1 and 100): ";
            cin >> user_guess;

            if (cin.fail()) {
                cin.clear();
                cin.ignore(INT_MAX, '\n');
                cout << "Please enter a valid integer." << endl;
                continue;
            }

            if (user_guess < number_to_guess) {
                cout << "Your guess is too low. Please Try again!" << endl;
            } else if (user_guess > number_to_guess) {
                cout << "Your guess is too high. Please Try again!" << endl;
            } else {
                cout << "Congratulations! You guessed the correct number: " << number_to_guess << endl;
                break;
            }
        }

        cout << "Interested to play again? (y/n): ";
        cin >> play_again;

        while (cin.fail() || (play_again != 'y' && play_again != 'Y' && play_again != 'n' && play_again != 'N')) {
            cin.clear();
            cin.ignore(INT_MAX, '\n');
            cout << "Please enter 'y' to play again or 'n' to exit: ";
            cin >> play_again;
        }
    }

    cout << "Thank you for playing!" << endl;
    return 0;
}
