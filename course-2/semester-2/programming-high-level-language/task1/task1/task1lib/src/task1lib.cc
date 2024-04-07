#include "../include/task1lib.h"

DynamicIntArray::DynamicIntArray() : array_(nullptr) {}

DynamicIntArray::DynamicIntArray(int size) {
    assert(size >= 0);

    array_ = new int[size];
    length_ = size;
}

DynamicIntArray::DynamicIntArray(int size, int value) {
    assert(size >= 0);

    array_ = new int[size];
    length_ = size;
    for (size_t i = 0; i < size; ++i) {
        array_[i] = value;
    }
}

DynamicIntArray::DynamicIntArray(const DynamicIntArray &other) : array_(new int[other.ArrayLength()]), length_(other.ArrayLength()) {
    for (size_t i = 0; i < other.ArrayLength(); ++i) {
        array_[i] = other[i];
    }
}

DynamicIntArray::DynamicIntArray(DynamicIntArray &&other) : array_(other.array_), length_(other.ArrayLength()) {
    other.array_ = nullptr;
    other.length_ = 0;
}

DynamicIntArray::~DynamicIntArray() {
    delete[] array_;
    length_ = 0;
}

size_t DynamicIntArray::ArrayLength() const {
    return length_;
}

void DynamicIntArray::Resize(size_t new_size) {
    assert(new_size >= 0);

    int* new_array = new int(new_size);
    if (new_size < ArrayLength()) {
        for (size_t i = 0; i < new_size; ++i) {
            new_array[i] = array_[i];
        }

        array_ = new_array;
        length_ = new_size;
    } else if (new_size > ArrayLength()) {
        for (size_t i = 0; i < ArrayLength(); ++i) {
            new_array[i] = array_[i];
        }
        for (size_t i = ArrayLength(); i < new_size; ++i) {
            new_array[i] = 0;
        }

        array_ = new_array;
        length_ = new_size;
    }
}

void DynamicIntArray::Reserve(size_t new_capacity) {
    // Implement Reserve method
}

size_t DynamicIntArray::Capacity() {
    // Implement Capacity method
}

void DynamicIntArray::PushBack(int value) {
    // Implement PushBack method
}

int DynamicIntArray::PopBack() {
    // Implement PopBack method
}

int &DynamicIntArray::operator[](int index) {
    assert(index >= 0);
    assert(index < ArrayLength());

    return array_[index];
}

const int &DynamicIntArray::operator[](int index) const {
    assert(index >= 0);
    assert(index < ArrayLength());

    return array_[index];
}

DynamicIntArray &DynamicIntArray::operator=(const DynamicIntArray &other) {
    if (this != &other) {
        array_ = other.array_;
        length_ = other.length_;
   }

   return *this; 
}

DynamicIntArray &DynamicIntArray::operator=(DynamicIntArray &&other) {
    if (this != &other) {
      array_ = other.array_;
      length_ = other.length_;

      other.array_ = nullptr;
      other.length_ = 0;
   }

   return *this;
}

bool DynamicIntArray::operator==(const DynamicIntArray &other) const {
    assert(ArrayLength() == other.ArrayLength());

    for (size_t i = 0; i < ArrayLength(); ++i) {
        if (array_[i] != other.array_[i]) {
            return false;
        }
    }

    return true;
}

bool DynamicIntArray::operator!=(const DynamicIntArray &other) const {
    assert(ArrayLength() == other.ArrayLength());

    for (size_t i = 0; i < ArrayLength(); ++i) {
        if (array_[i] != other.array_[i]) {
            return true;
        }
    }

    return false;
}

bool DynamicIntArray::operator<(const DynamicIntArray &other) const {
    for (size_t i = 0; i < fmin(ArrayLength(),other.ArrayLength()); ++i) {
        if (array_[i] < other.array_[i]) {
            return true;
        }
    }

    return false;
}

bool DynamicIntArray::operator<=(const DynamicIntArray &other) const {
    for (size_t i = 0; i < fmin(ArrayLength(),other.ArrayLength()); ++i) {
        if (array_[i] <= other.array_[i]) {
            return true;
        }
    }

    return false;
}

bool DynamicIntArray::operator>(const DynamicIntArray &other) const {
    for (size_t i = 0; i < fmin(ArrayLength(),other.ArrayLength()); ++i) {
        if (array_[i] > other.array_[i]) {
            return true;
        }
    }

    return false;
}

bool DynamicIntArray::operator>=(const DynamicIntArray &other) const {
    for (size_t i = 0; i >= fmin(ArrayLength(),other.ArrayLength()); ++i) {
        if (array_[i] < other.array_[i]) {
            return true;
        }
    }

    return false;
}

int * DynamicIntArray::operator+(const DynamicIntArray &other) const {
    int *array = new int[ArrayLength() + other.ArrayLength()];

    for (size_t i = 0; i < ArrayLength(); ++i) {
        array[i] = array_[i];
    }

    for (size_t i = ArrayLength(); i < ArrayLength() + other.ArrayLength(); ++i) {
        array[i] = other.array_[i - ArrayLength()];
    }

    return array;   
}

std::ostream &operator<<(std::ostream &os, const DynamicIntArray &array) {
    os << "length: " << array.ArrayLength() << ", elements:";

        if (array.ArrayLength()) {
            for (size_t i = 0; i < array.ArrayLength(); ++i) {
                os << std::endl
                   << "  array[" << i << "]: " << array[i];
            }
        } else {
            os << " none";
        }

        return os;
}

std::istream &operator>>(std::istream &in, DynamicIntArray &array) {
    unsigned length;

    std::cout << "enter length for the array: ";
    in >> length;
    assert(length >= 0);
    array.Resize(length);

    std::cout << "enter array elements: ";
    for (size_t i = 0; i < array.ArrayLength(); ++i) {
        std::cin >> array[i];
    }
    
    return in;
}