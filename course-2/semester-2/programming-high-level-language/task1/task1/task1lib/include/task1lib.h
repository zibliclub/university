#ifndef TASK1_TASK1LIB_TASK1LIB_H_
#define TASK1_TASK1LIB_TASK1LIB_H_

#include <iostream>

#include <cassert>
#include <algorithm>

class DynamicIntArray {
private:
    int *array_;
    size_t length_;

public:
    DynamicIntArray();
    DynamicIntArray(int);
    DynamicIntArray(int, int);
    DynamicIntArray(const DynamicIntArray &);
    DynamicIntArray(DynamicIntArray &&);

    ~DynamicIntArray();

    size_t ArrayLength() const;
    void Resize(size_t);
    void Reserve(size_t);
    size_t Capacity();
    void PushBack(int);
    int PopBack();

    int &operator[](int);
    const int &operator[](int) const;
    DynamicIntArray &operator=(const DynamicIntArray &);
    DynamicIntArray &operator=(DynamicIntArray &&); 
    bool operator==(const DynamicIntArray &) const;
    bool operator!=(const DynamicIntArray &) const;
    bool operator<(const DynamicIntArray &) const;
    bool operator<=(const DynamicIntArray &) const;
    bool operator>(const DynamicIntArray &) const;
    bool operator>=(const DynamicIntArray &) const;
    int * operator+(const DynamicIntArray &) const;
};

std::ostream &operator<<(std::ostream &, const DynamicIntArray &);
std::istream &operator>>(std::istream &, DynamicIntArray &);

#endif // TASK1_TASK1LIB_TASK1LIB_H_