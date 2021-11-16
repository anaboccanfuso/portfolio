// Copyright 2021 Ana Boccanfuso
#include "./SuperString.h"
#include <string>

// DO NOT MODIFY START
void SuperString::print() {
    if (size != 0) {
        for (int i = 0; i < size; i++) {
            std::cout << data[i];
        }
        std::cout << "\n";
    } else {
        std::cout << "<EMPTY>\n";
    }
}

char SuperString::get(int index) {
    if (index >= 0 && index < size) {
        return data[index];
    }
    return '\0';
}

int SuperString::length() {
    return size;
}
// DO NOT MODIFY END

// PUT YOUR CODE BELOW!

SuperString::SuperString() {
    size = 0;
    data = new char[size];
}

SuperString::SuperString(std::string str) {
    size = str.length();
    data = new char[size];
    for (int i = 0; i < size; i++) {
        data[i] = str[i];
    }
}

SuperString::SuperString(int size, char val) {
    this->size = size;
    data = new char[size];
    for (int i = 0; i < size; i++) {
      data[i] = val;
    }
}

SuperString::SuperString(const SuperString& copy) {
    size = copy.size;
    data = new char[size];
    for (int i = 0; i < size; i++) {
        data[i] = copy.data[i];
    }
}

int SuperString::find(char c, int start) {
    for (int i = start; i < size; i++) {
        if (c == data[i]) {
           return i;
        }
    }
    return -1;
}

int SuperString::find(std::string str, int start) {
    for (int i = start; i < size; i++) {
        if (str[0] == data[i] && str[1] == data[i+1]
        && str[2] == data[i+2]) {
            return i;
        }
    }
    return -1;
}

SuperString SuperString::substr(int start, int numChar) {
    if (start < 0 || numChar < 0) {
        return SuperString();
    }
    std::string sub = "";
    if (size - start >= numChar) {
        for (int i = start; i < numChar; i++) {
           sub += data[i];
        }
    }
    return SuperString(sub);
}

SuperString SuperString::reverse() {
    std::string newData = "";
    for (int i = 0; i < size; i++) {
        newData += data[size-1-i];
    }
    return SuperString(newData);
}

SuperString SuperString::replace(int index, int numChar, std::string sub) {
    std::string newData = "";
    if (index < 0 || size <= index + numChar) {
        return SuperString();
    }
    for (int i = 0; i < index; i++) {
        newData += data[i];
    }
    newData += sub;
    for (int i = index + numChar; i < size; i++) {
        newData += data[i];
    }
    return SuperString(newData);
}

void SuperString::push_back(char c) {
    data[size] = c;
    size++;
}

void SuperString::append(std::string str) {
    int newSize = size + str.length();
    std::string newData = "";
    for (int i = 0; i < size; i++) {
        newData[i] = data[i];
    }
    for (int j = 0; j < str.length(); j++) {
        newData[size+j] = str[j];
    }
    size = newSize;
    for (int k = 0; k < size; k++) {
        data[k] = newData[k];
    }
}

void SuperString::append(const SuperString& obj) {
    int newSize = size + obj.size;
    std::string newData = "";
    for (int i = 0; i < size; i++) {
        newData[i] = data[i];
    }
    for (int j = 0; j < obj.size; j++) {
        newData[j+size] = obj.data[j];
    }
    size = newSize;
    for (int k = 0; k < size; k++) {
        data[k] = newData[k];
    }
}

void SuperString::replace(char find, char rep) {
    for (int i = 0; i < size; i++) {
        if (data[i] == find) {
            data[i] = rep;
        }
    }
}

// Extra Credit Methods
void SuperString::removeAll(char c) {
    std::string word = "";
    for (int i = 0; i < size; i++) {
        if (data[i] != c) {
            word += data[i];
        }
    }
    int wordLength = word.length();
    std:: string newData = "";
    for (int j = 0; j < wordLength; j++) {
        newData[j] = word[j];
    }
    size = wordLength;
    for (int k = 0; k < size; k++) {
        data[k] = newData[k];
    }
}

void SuperString::replace(std::string find, std::string rep) {
    for (int i = 0; i < size; i++) {
        if (data[i] == find[0] && data[i+1] == find[1] &&
        data[i+2] == find[2]) {
            data[i] = rep[0];
            data[i+1] = rep[1];
            data[i+2] = rep[2];
        }
    }
}

bool SuperString::isUpper() {
    int count = 0;
    for (int i = 0; i < size; i++) {
        if (data[i] == 'A' || data[i] == 'B' || data[i] == 'C' ||
        data[i] == 'D' || data[i] == 'E' || data[i] == 'F' ||
        data[i] == 'G' || data[i] == 'H' || data[i] == 'I' ||
        data[i] == 'J' || data[i] == 'K' || data[i] == 'L' ||
        data[i] == 'M' || data[i] == 'N' || data[i] == 'O' ||
        data[i] == 'P' || data[i] == 'Q' || data[i] == 'R' ||
        data[i] == 'S' || data[i] == 'T' || data[i] == 'U' ||
        data[i] == 'V' || data[i] == 'W' || data[i] == 'X' ||
        data[i] == 'Y' || data[i] == 'Z') {
            count++;
        }
    }
    if (count == size) {
        return true;
    } else {
        return false;
    }
}

bool SuperString::isLower() {
    int count = 0;
    for (int i = 0; i < size; i++) {
        if (data[i] == 'a' || data[i] == 'b' || data[i] == 'c' ||
        data[i] == 'd' || data[i] == 'e' || data[i] == 'f' ||
        data[i] == 'g' || data[i] == 'h' || data[i] == 'i' ||
        data[i] == 'j' || data[i] == 'k' || data[i] == 'l' ||
        data[i] == 'm' || data[i] == 'n' || data[i] == 'o' ||
        data[i] == 'p' || data[i] == 'q' || data[i] == 'r' ||
        data[i] == 's' || data[i] == 't' || data[i] == 'u' ||
        data[i] == 'v' || data[i] == 'w' || data[i] == 'x' ||
        data[i] == 'y' || data[i] == 'z') {
            count++;
        }
    }
    if (count == size) {
        return true;
    } else {
        return false;
    }
}

bool SuperString::isTitleCase() {
    if (data[0 ] == 'a' || data[0] == 'b' || data[0] == 'c' ||
        data[0] == 'd' || data[0] == 'e' || data[0] == 'f' ||
        data[0] == 'g' || data[0] == 'h' || data[0] == 'i' ||
        data[0] == 'j' || data[0] == 'k' || data[0] == 'l' ||
        data[0] == 'm' || data[0] == 'n' || data[0] == 'o' ||
        data[0] == 'p' || data[0] == 'q' || data[0] == 'r' ||
        data[0] == 's' || data[0] == 't' || data[0] == 'u' ||
        data[0] == 'v' || data[0] == 'w' || data[0] == 'x' ||
        data[0] == 'y' || data[0] == 'z') {
        return false;
    }
    for (int i = 0; i < size; i++) {
        if (data[i] == ' ' && (data[i+1] == 'a' || data[i+1] == 'b' ||
        data[i+1] == 'c' || data[i+1] == 'd' || data[i+1] == 'e' ||
        data[i+1] == 'f' || data[i+1] == 'g' || data[i+1] == 'h' ||
        data[i+1] == 'i' || data[i+1] == 'j' || data[i+1] == 'k' ||
        data[i+1] == 'l' || data[i+1] == 'm' || data[i+1] == 'n' ||
        data[i+1] == 'o' || data[i+1] == 'p' || data[i+1] == 'q' ||
        data[i+1] == 'r' || data[i+1] == 's' || data[i+1] == 't' ||
        data[i+1] == 'u' || data[i+1] == 'v' || data[i+1] == 'w' ||
        data[i+1] == 'x' || data[i+1] == 'y' || data[i+1] == 'z')) {
            return false;
        }
    }
    return true;
}

SuperString::~SuperString() {
    delete [] data;
}
