// Copyright 2021 Ana Boccanfuso
#include <iostream>
#include <vector>
#include <string>
#include <fstream>
#include <cstring>

using std::vector;
using std::cout;
using std::string;
using std::ifstream;

void readData(vector<string> &data, string filename);
void printData(const vector<string> &data);
vector<int> findMinHamming(const vector<string> & data, string test);
void printMinDistance(const vector<string> &data, string word,
                      const vector<int> min);

int main(int argc, char **argv) {
  string filename;
  vector<string> data;
  if (argc != 2) {
    cout << "Usage: ./sub1 data.txt\n";
    exit(0);
  }
  filename = argv[1];
  readData(data, filename);
  cout << "data:\n```\n";
  printData(data);
  cout << "```\noutput:\n```\n";
  for (auto line : data) {
    vector<int> ret;
    ret = findMinHamming(data, line);
    printMinDistance(data, line, ret);
  }
  return 0;
}

void readData(vector<string> &data, string filename) {
  ifstream in(filename);
  if (in.is_open()) {
    string line;
    while (!in.eof()) {
      in >> line;
      data.push_back(line);
    }
  }
  in.close();
}

void printData(const vector<string> &data) {
  for (string i : data) {
    cout << i << "\n";
  }
}

vector<int> findMinHamming(const vector<string> & data, string test) {
  vector<int> ret;
  int index = 0;
  int min = 10000;
  for (int i = 0; i < data.size(); i++) {
    int j = 0;
    int count = 0;
    if (data[i].length() < test.length()) {
      count += test.length() - data[i].length();
      while (j < data[i].length()) {
        if (data[i][j] != test[j]) {
          count++;
        }
        j++;
      }
    } else {
        while (j < data[i].length()) {
          if (data[i][j] != test[j]) {
            count++;
          }
          j++;
        }
    }
    if (count < min && count != 0) {
      min = count;
      index = i;
    }
  }
  ret.push_back(index);
  ret.push_back(min);
  return ret;
}

void printMinDistance(const vector<string> &data, string word,
                      const vector<int> min) {
  cout << "The minimum hamming distance for " << word << " is "
        << min[1] << " (matching word: " << data[min[0]] << ")\n";
}
