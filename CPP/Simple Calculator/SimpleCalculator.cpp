/*C++ Program to Develop a calculator program that performs basic arithmetic operations 
such as addition, subtraction, multiplication, and division.*/
//Task 2

#include <iostream>
#include <climits>
using namespace std;

void showMenu() 
{
    cout << "== Welcome to Simple Calculator ==\n";
    cout << "Select an operation to perform:\n";
    cout << "(1) --- Addition\n";
    cout << "(2) --- Subtraction\n";
    cout << "(3) --- Multiplication\n";
    cout << "(4) --- Division\n";
    cout << "Enter your choice (1-4): ";
}

int main() {
    double num1, num2;
    int choice;
    char continueChoice;

    do {
        showMenu();
        cin >> choice;

        if (cin.fail() || choice < 1 || choice > 4) {
            cin.clear(); 
            cin.ignore(INT_MAX, '\n'); 
            cout << "Invalid input. Please enter a number between 1 and 4." << endl;
            continue;
        }

        cout << "Enter the first number: ";
        while (!(cin >> num1)) {
            cin.clear();
            cin.ignore(INT_MAX, '\n');
            cout << "Invalid input. Please enter a valid number: ";
        }

        cout << "Enter the second number: ";
        while (!(cin >> num2)) {
            cin.clear();
            cin.ignore(INT_MAX, '\n');
            cout << "Invalid input. Please enter a valid number: ";
        }

        switch (choice) {
            case 1:
                cout << "Result: " << num1 + num2 << endl;
                break;
            case 2:
                cout << "Result: " << num1 - num2 << endl;
                break;
            case 3:
                cout << "Result: " << num1 * num2 << endl;
                break;
            case 4:
                if (num2 != 0)
                    cout << "Result: " << num1 / num2 << endl;
                else
                    cout << "Error: Division by zero is not allowed." << endl;
                break;
            default:
                cout << "Invalid choice. Please enter a number between 1 and 4." << endl;
        }

        cout << "Do you want to perform another calculation? (y/n): ";
        cin >> continueChoice;
    } while (continueChoice == 'y' || continueChoice == 'Y');

    cout << "Thank you for using Simple Calculator!" << endl;

    return 0;
}
