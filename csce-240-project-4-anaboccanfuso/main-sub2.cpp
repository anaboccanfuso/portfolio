// Copyright 2021 <Your name here>
#include <iostream>
#include <vector>
#include <string>
#include <fstream>
#include <cstring>

using std::vector;
using std::cout;
using std::string;
using std::ifstream;

void readPuzzle(vector<vector<char>> &puzzle, string filename);
void readWords(vector<string> &words, string filename);
void printPuzzle(const vector<vector<char>> &puzzle);
void printWords(const vector<string> &words);
void printLocation(string word, const vector<int> &start,
                   const vector<int> &end, bool found);
bool findWord(const vector<vector<char>> & puzzle, string word,
              vector<int> &start, vector<int> &end);
bool checkUp(const vector<vector<char>> & puzzle, string word,
              vector<int> &start, vector<int> &end);
bool checkDown(const vector<vector<char>> & puzzle, string word,
                vector<int> &start, vector<int> &end);
bool checkRight(const vector<vector<char>> & puzzle, string word,
                vector<int> &start, vector<int> &end);
bool checkLeft(const vector<vector<char>> & puzzle, string word,
                vector<int> &start, vector<int> &end);
bool checkUpRight(const vector<vector<char>> & puzzle, string word,
                  vector<int> &start, vector<int> &end);
bool checkUpLeft(const vector<vector<char>> & puzzle, string word,
                  vector<int> &start, vector<int> &end);
bool checkDownRight(const vector<vector<char>> & puzzle, string word,
                    vector<int> &start, vector<int> &end);
bool checkDownLeft(const vector<vector<char>> & puzzle, string word,
                    vector<int> &start, vector<int> &end);

int main(int argc, char **argv) {
  string puzzleFileName;
  string wordsFileName;
  vector<vector<char>> puzzle;
  vector<string> words;
  if (argc != 3) {
    cout << "Usage: ./sub2 puzzle.txt words.txt\n";
    exit(0);
  }
  puzzleFileName = argv[1];
  wordsFileName = argv[2];
  readPuzzle(puzzle, puzzleFileName);
  readWords(words, wordsFileName);
  printPuzzle(puzzle);
  printWords(words);
  cout << "output:\n```\n";
  for (auto word : words) {
    vector<int> start;
    vector<int> end;
    bool found;
    found = findWord(puzzle, word, start, end);
    printLocation(word, start, end, found);
    end.clear();
    start.clear();
  }
  cout << "```\n";
  return 0;
}

void readPuzzle(vector<vector<char>> &puzzle, string filename) {
  ifstream in(filename);
  if (in.is_open()) {
    while (!in.eof()) {
      for (int i = 0; i < 3; i++) {
        string line;
        vector<char> temp;
        char char_array[1];
        for (int j = 0; j < 4; j++) {
          in >> line;
          strcpy(char_array, line.c_str());
          temp.push_back(char_array[0]);
        }
        puzzle.push_back(temp);
      }
  }
  }
  in.close();
}

void readWords(vector<string> &words, string filename) {
  ifstream in(filename);
  if (in.is_open()) {
    string line;
    while (!in.eof()) {
      in >> line;
      words.push_back(line);
    }
  }
  in.close();
}

void printPuzzle(const vector<vector<char>> &puzzle) {
    cout << "puzzle\n```\n";
    for (int i = 0; i < puzzle.size(); i++) {
      for (int j = 0; j < puzzle[i].size(); j++) {
        cout << puzzle[i][j] << "  ";
      }
      cout << "\n";
    }
    cout << "```\n";
}

void printWords(const vector<string> &words) {
    cout << "word list\n```\n";
    for (string word : words) {
      cout << word << "\n";
    }
    cout << "```\n";
}

void printLocation(string word, const vector<int> &start,
                   const vector<int> &end, bool found) {
    if (found) {
      cout << "Word " << word << " found at (" << start[0] << ", ";
      cout << start[1] << ") -> (" << end[0] << ", " << end[1] << ")\n";
    } else {
      cout << "Word " << word << " not found\n";
    }
}

bool findWord(const vector<vector<char>> & puzzle, string word,
              vector<int> &start, vector<int> &end) {
    for (int i = 0; i < puzzle.size(); i++) {
       for (int j = 0; j < puzzle[i].size(); j++) {
        if (word[0] == puzzle[i][j]) {
          start.push_back(i);
          start.push_back(j);
          if (checkUp(puzzle, word, start, end) ||
          checkDown(puzzle, word, start, end) ||
          checkRight(puzzle, word, start, end) ||
          checkLeft(puzzle, word, start, end) ||
          checkUpRight(puzzle, word, start, end) ||
          checkUpLeft(puzzle, word, start, end) ||
          checkDownRight(puzzle, word, start, end) ||
          checkDownLeft(puzzle, word, start, end)) {
            return true;
          }
        }
       }
    }
    return false;
}

bool checkUp(const vector<vector<char>> & puzzle, string word,
              vector<int> &start, vector<int> &end) {
  int y = start[0];
  int x = start[1];
  int count = 0;
  for (int i = 0; i < word.length(); i++) {
    if ((y-i) >= 0 && puzzle[y-i][x] == word[i]) {
      count++;
    }
  }
  if (count == word.length()) {
    end.push_back(start[0] - (word.length()-1));
    end.push_back(start[1]);
    return true;
  }
  return false;
}

bool checkDown(const vector<vector<char>> & puzzle, string word,
                vector<int> &start, vector<int> &end) {
  int y = start[0];
  int x = start[1];
  int count = 0;
  for (int i = 0; i < word.length(); i++) {
    if ((y+i) < puzzle.size() && puzzle[y+i][x] == word[i]) {
      count++;
    }
  }
  if (count == word.length()) {
    end.push_back(start[0] + (word.length()-1));
    end.push_back(start[1]);
    return true;
  }
  return false;
}

bool checkRight(const vector<vector<char>> & puzzle, string word,
                  vector<int> &start, vector<int> &end) {
  int y = start[0];
  int x = start[1];
  int count = 0;
  for (int i = 0; i < word.length(); i++) {
    if ((x+i) < puzzle[i].size() && puzzle[y][x+i] == word[i]) {
      count++;
    }
  }
  if (count == word.length()) {
    end.push_back(start[0]);
    end.push_back(start[1] + (word.length()-1));
    return true;
  }
  return false;
}

bool checkLeft(const vector<vector<char>> & puzzle, string word,
                vector<int> &start, vector<int> &end) {
  int y = start[0];
  int x = start[1];
  int count = 0;
  for (int i = 0; i < word.length(); i++) {
    if ((x-i) >= 0 && puzzle[y][x-i] == word[i]) {
      count++;
    }
  }
  if (count == word.length()) {
    end.push_back(start[0]);
    end.push_back(start[1] - (word.length()-1));
    return true;
  }
  return false;
}

bool checkUpRight(const vector<vector<char>> & puzzle, string word,
                  vector<int> &start, vector<int> &end) {
  int y = start[0];
  int x = start[1];
  int count = 0;
  for (int i = 0; i < word.length(); i++) {
    if ((x+i) < puzzle[i].size() && (y-1) >= 0 && puzzle[y-1][x+i] == word[i]) {
      count++;
    }
  }
  if (count == word.length()) {
    end.push_back(start[0] - (word.length() - 1));
    end.push_back(start[1] + (word.length() - 1));
    return true;
  }
  return false;
}

bool checkUpLeft(const vector<vector<char>> & puzzle, string word,
                  vector<int> &start, vector<int> &end) {
  int y = start[0];
  int x = start[1];
  int count = 0;
  for (int i = 0; i < word.length(); i++) {
    if ((x-i) >= 0 && (y-1) >= 0 && puzzle[y-1][x-i] == word[i]) {
      count++;
    }
  }
  if (count == word.length()) {
    end.push_back(start[0] - (word.length() - 1));
    end.push_back(start[1] - (word.length() - 1));
    return true;
  }
  return false;
}

bool checkDownRight(const vector<vector<char>> & puzzle, string word,
                    vector<int> &start, vector<int> &end) {
  int y = start[0];
  int x = start[1];
  int count = 0;
  for (int i = 0; i < word.length(); i++) {
    if ((x+i) < puzzle[i].size() && (y+1) < puzzle.size() &&
        puzzle[y+1][x+i] == word[i]) {
      count++;
    }
  }
  if (count == word.length()) {
    end.push_back(start[0] + (word.length() - 1));
    end.push_back(start[1] + (word.length() - 1));
    return true;
  }
  return false;
}

bool checkDownLeft(const vector<vector<char>> & puzzle, string word,
                    vector<int> &start, vector<int> &end) {
  int y = start[0];
  int x = start[1];
  int count = 0;
  for (int i = 0; i < word.length(); i++) {
    if ((x-i) >= 0 && (y+1) < puzzle.size() && puzzle[y+1][x-i] == word[i]) {
      count++;
    }
  }
  if (count == word.length()) {
    end.push_back(start[0] + (word.length() - 1));
    end.push_back(start[1] - (word.length() - 1));
    return true;
  }
  return false;
}
