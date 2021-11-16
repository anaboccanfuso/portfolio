// Copyright 2021 Ana Boccanfuso
#include "ArrayList.h"

template <class U>
ostream& operator<<(ostream & os, ArrayList<U> a) {
    os << "[";
    for (int i = 0; i < a.getSize(); i++) {
        os << a.getData(i) << " ";
    }
    os << "]";
    return os;
}

template <class T>
ArrayList<T>::ArrayList() {
    size = 0;
    data = new T[size];
}

template <class T>
ArrayList<T>::ArrayList(int size, T val) {
    this->size = size;
    data = new T[size];
    for (int i = 0; i <size; i++) {
        data[i] = val;
    }
}

template <class T>
ArrayList<T>::ArrayList(const ArrayList<T> & copy) {
    setSize(copy.getSize());
    data = new T[size];
    for (int i = 0; i < size; i++) {
        data[i] = copy[i];
    }
}

template <class T>
ArrayList<T>::~ArrayList() {
    delete [] data;
}

template <class T>
void ArrayList<T>::setSize(int size) {
    if (size >= 0) {
        this->size = size;
    } else {
        std::cout << "Incorrect size\n";
        exit(1);
    }
}

template <class T>
int ArrayList<T>::getSize() const {
    return size;
}

template <class T>
T ArrayList<T>::getData(int index) const {
    if (index >= 0 && index < size) {
        return data[index];
    } else {
        std::cout << "Invalid Index\n";
        exit(0);
    }
}

template <class T>
T ArrayList<T>::operator[](int index) const {
    if (index >= 0 && index < size) {
        return data[index];
    } else {
        std::cout << "Invalid Index\n";
        exit(0);
    }
}

template <class T>
T& ArrayList<T>::operator[](int index) {
    return data[index];
}

template <class T>
const ArrayList<T> & ArrayList<T>::operator=(const ArrayList<T> rhs) {
    size = rhs.getSize();
    delete [] data;
    data = new T[size];
    for (int i = 0; i < size; i++) {
        data[i] = rhs[i];
    }
    return *this;
}

template <class T>
void ArrayList<T>::print() const {
    for (int i = 0; i < size; i++) {
        std::cout << data[i] << " ";
    }
    std::cout << "\n";
}

// Start of new functions

template <class T>
bool ArrayList<T>::operator!=(const ArrayList<T> & rhs) const {
    if (rhs.getSize() != size) {
        return true;
    }
    for (int i = 0; i < size; i++) {
        if (rhs[i] != data[i]) {
            return true;
        }
    }
    return false;
}

template <class T>
ArrayList<T> ArrayList<T>::operator+(T val) const {
    for (int i = 0; i < size; i++) {
        data[i] += val;
    }
    return *this;
}

template <class T>
ArrayList<T> ArrayList<T>::operator+(const ArrayList<T> & rhs) const {
    for (int i = 0; i < size; i++) {
        data[i] += rhs[i];
    }
    return *this;
}

template <class T>
ArrayList<T> & ArrayList<T>::operator--() {
    if (size == 0) {
        return *this;
    }
    ArrayList<T> temp;
    temp.size = size - 1;
    for (int i = 0; i < temp.size; i++) {
        temp.data[i] = data[i];
    }
    size = size - 1;
    data = new T[size];
    for (int i = 0; i < size; i++) {
        data[i] = temp.data[i];
    }
    return *this;
}

template <class T>
ArrayList<T> ArrayList<T>::operator--(int) {
    ArrayList<T> temp = *this;
    --*this;
    return temp;
}

template <class T>
void ArrayList<T>::operator+=(T val) {
    ArrayList<T> temp;
    for (int i = 0; i < size; i++) {
        temp.data[i] = data[i];
    }
    temp.data[size] = val;
    size = size + 1;
    data = new T[size];
    for (int i = 0; i < size; i++) {
        data[i] = temp.data[i];
    }
}

template <class T>
void ArrayList<T>::operator+=(const ArrayList<T> & rhs) {
    ArrayList<T> temp;
    temp.size = size + rhs.size;
    for (int i = 0; i < size; i++) {
        temp.data[i] = data[i];
    }
    for (int j = size; j < temp.size; j++) {
        temp.data[j] = rhs[j-size];
    }
    size = temp.size;
    data = new T[size];
    for (int k = 0; k < size; k++) {
        data[k] = temp.data[k];
    }
}

template <class T>
ArrayList<T> ArrayList<T>::operator*(int val) const {
    if (val < 1) {
        ArrayList<T> empty;
        return empty;
    }
    ArrayList<T> temp;
    for (int i = 0; i < size; i++) {
        temp.data[i] = data[i];
    }
    temp.size = val * size;
    int counter = 2;
    int index = size;
    int copy = size;
    while (counter <= val) {
        for (int i = copy; i < 2*size; i++) {
            temp.data[i] = data[i-((counter-1)*size)];
        }
        copy += size;
        counter++;
    }
    return temp;
}

template <class T>
ArrayList<T> ArrayList<T>::operator/(int val) const {
    int fraction = size/val;
    ArrayList<T> temp;
    temp.size = fraction;
    for (int i = 0; i < temp.size; i++) {
        temp.data[i] = data[i];
    }
    return temp;
}
