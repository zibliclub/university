#ifndef TASK1_TASK1LIB_TASK1LIB_H_
#define TASK1_TASK1LIB_TASK1LIB_H_

#include <iostream>

class DynamicIntArray {
private:
    int *array_;
    size_t length_;

public:
    DynamicIntArray();
    DynamicIntArray(size_t);
    DynamicIntArray(size_t, int);
    DynamicIntArray(const DynamicIntArray &);
    DynamicIntArray(DynamicIntArray &&);

    ~DynamicIntArray();

    size_t ArrayLength() const;
    void Resize(size_t);
    void Reserve(size_t);
    size_t Capacity();
    void PushBack(int);
    int PopBack();

    int &operator[](size_t);
    const int &operator[](size_t) const;
    DynamicIntArray &operator=(const DynamicIntArray &);
    DynamicIntArray &operator=(DynamicIntArray &&); // нужен ли noexcept?
    bool operator==(const DynamicIntArray &) const;
    bool operator!=(const DynamicIntArray &) const;
    bool operator<(const DynamicIntArray &) const;
    bool operator<=(const DynamicIntArray &) const;
    bool operator>(const DynamicIntArray &) const;
    bool operator>=(const DynamicIntArray &) const;
    bool operator+(const DynamicIntArray &) const;
};

std::ostream &operator<<(std::ostream &, const DynamicIntArray &);
std::istream &operator>>(std::istream &, DynamicIntArray &);

#endif // TASK1_TASK1LIB_TASK1LIB_H_