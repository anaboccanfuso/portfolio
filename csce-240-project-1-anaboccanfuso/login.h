// Author: Ana Boccanfuso
// Email: boccanfa@email.sc.edu
// Section #: 002
// Copyright 2021 Ana Boccanfuso
// Modified from template code @coleca24 GitHub
#ifndef LOGIN_H_
#define LOGIN_H_

#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <cstring>

using std::string;
using std::cout;
using std::cin;
using std::to_string;

const int COLS = 4;
const int ROWS = 5;

// TODO(commit 1): Commit #1 functions
void printUsers(const string data[ROWS][COLS]);
bool readUsers(string fh, string data[ROWS][COLS]);
char displayOptions();
bool validateOption(char option);
void executeOption(char option, string data[ROWS][COLS], string);
int searchForUser(string name, const string data[ROWS][COLS]);

// TODO(commit 2): Commit #2 functions
int findAllUsers(string title, const string data[ROWS][COLS]);
bool deleteUser(string name, string data[ROWS][COLS], string);
string generatePassword();
string generateEmail(string name);
int checkEmpty(const string data[ROWS][COLS]);
void addUser(int index, string name, string title,
    string data[ROWS][COLS], string fh);

void printUsers(const string data[ROWS][COLS]) {
    cout << "\n";
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 4; j++) {
            cout << data[i][j] << "\t";
        }
        cout << "\n";
    }
}

bool readUsers(string fh, string data[ROWS][COLS]) {
    std::ifstream in(fh);
    int i = 0;
    string line;
    string elem;
    if (in.is_open()) {
        while (getline(in, line)) {
            std::stringstream s(line);
            int j = 0;
            while (getline(s, elem, ',')) {
                data[i][j] = elem;
                j++;
            }
            i++;
        }
        return true;
        in.close();
    } else {
        cout << "No file\n";
        return false;
    }
    return false;
}

char displayOptions() {
    cout << "\nPlease choose one of the following options:\n"
        << "P(or p): Print data\n" << "S(or s): Search data by name\n"
        << "F(or f): Find all in data with a certain job title\n"
        << "A(or a): Add a new user\n"
        << "D(or d): Delete an existing user\n"
        << "E(or e): End session\n";
    char option;
    cin >> option;
    if (validateOption(option)) {
        return option;
    } else {
        return 'n';
    }
}

bool validateOption(char option) {
    if (option == 'e' || option == 'E' || option == 'p' || option == 'P'
    || option == 's' || option == 'S' || option =='f' || option == 'F'
    || option == 'a' || option == 'A' || option == 'd' || option == 'D') {
        return true;
    } else {
        return false;
    }
}

void executeOption(char option, string data[ROWS][COLS], string fh) {
    if (option == 'p' || option == 'P') {
        printUsers(data);
    } else if (option == 's' || option == 'S') {
        string firstName;
        cout << "Please enter a first name: ";
        cin >> firstName;
        string lastName;
        cout << "Please enter a last name: ";
        cin >> lastName;
        string name = firstName + " " + lastName;
        if (searchForUser(name, data) == -1) {
            cout << "User was not found.\n";
        } else {
            int index = searchForUser(name, data);
            cout << "User found at index " << index << "\n";
            for (int i = 0; i < 3; i++) {
                cout << data[index][i] << ", ";
            }
            cout << data[index][3];
            cout << "\n";
        }
    } else if (option == 'f' || option == 'F') {
        string title;
        cout << "Please enter a job title to search for: ";
        cin >> title;
        findAllUsers(title, data);
        int jobs = findAllUsers(title, data);
        if (jobs == 0) {
            cout << "No users w/ job title: " << title << "\n";
        } else {
            cout << "There were " << jobs << " users with job title " << title
                << "\n";
        }
    } else if (option == 'a' || option == 'A') {
        int index = checkEmpty(data);
        if (index == -1) {
            cout << "Database full (max 5 users)\n";
        } else {
            string fName;
            cout << "Please enter a first name: ";
            cin >> fName;
            string lName;
            cout << "Please enter a last name: ";
            cin >> lName;
            string fullname = fName + " " + lName;
            string jTitle;
            cout << "Enter Job Title: ";
            cin >> jTitle;
            addUser(index, fullname, jTitle, data, fh);
        }
    } else if (option == 'd' || option == 'D') {
        string fName;
        cout << "Please enter a first name: ";
        cin >> fName;
        string lName;
        cout << "Please enter a last name: ";
        cin >> lName;
        string fullname = fName + " " + lName;
        bool userDel = deleteUser(fullname, data, fh);
        deleteUser(fullname, data, fh);
        if (userDel) {
            cout << "User " << fullname << " deleted.\n";
        } else {
            cout << "User not found\n";
        }
    }
}

int searchForUser(string name, const string data[ROWS][COLS]) {
    for (int i = 0; i < 5; i++) {
        if (data[i][0] == name) {
            return i;
        }
    }
    return -1;
}

int findAllUsers(string title, const string data[ROWS][COLS]) {
    int allUsers = 0;
    for (int i = 0; i < 5; i++) {
        if (data[i][3] == title) {
            allUsers++;
        }
    }
    return allUsers;
}

bool deleteUser(string name, string data[ROWS][COLS], string fh) {
    for (int i = 0; i < 5; i++) {
        if (data[i][0].compare(name) == 0) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = "NULL";
            }
            std::ofstream out(fh);
            for (int a = 0; a < 5; a++) {
                for (int b = 0; b < 3; b++) {
                    out << data[a][b] << ",";
                }
                out << data[a][3] << "\n";
            }
            out.close();
            return true;
        }
    }
    return false;
}

string generatePassword() {
    string password;
    int randNum = 0;
    randNum = rand() % 10;
    password += to_string(randNum);
    char c = (60 + (rand() % 26));
    password += c;
    for (int i = 0; i < 6; i++) {
        char l = (97 + rand() % 26);
        password += l;
    }
    return password;
}
string generateEmail(string name) {
    int index = name.find(" ");
    string fName;
    string lName;
    for (int i = 0; i < index; i++) {
        fName += name[i];
    }
    for (int i = index + 1; i < name.length(); i++) {
        lName += name[i];
    }
    string fullName = fName + lName;
    string email = fullName + "@email.com";
    return email;
}
int checkEmpty(const string data[ROWS][COLS]) {
    for (int i = 0; i < 5; i++) {
        if (data[i][0] == "NULL" && data[i][1] == "NULL" && data[i][2] == "NULL"
        && data[i][3] == "NULL") {
            return i;
        }
    }
    return -1;
}
void addUser(int index, string name, string title,
    string data[ROWS][COLS], string fh) {
    data[index][0] = name;
    string email = generateEmail(name);
    cout << "Generating email...\n" << "Email: " << email << "\n";
    data[index][1] = email;
    string pass = generatePassword();
    cout << "Generating password...\n" << "Password: " << pass << "\n";
    data[index][2] = pass;
    data[index][3] = title;

    std::ofstream out(fh);
    for (int a = 0; a < 5; a++) {
        for (int b = 0; b < 3; b++) {
            out << data[a][b] << ",";
        }
            out << data[a][3] << "\n";
    }
    out.close();
}

#endif  // LOGIN_H_
