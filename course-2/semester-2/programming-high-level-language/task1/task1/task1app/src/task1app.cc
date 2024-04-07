#include <iostream>

#include "../../task1lib/include/task1lib.h"

int main() {
    // Checking class constructors

    DynamicIntArray array_1;
    DynamicIntArray array_2(10);
    DynamicIntArray array_3(5, 1);
    DynamicIntArray array_4(array_3);
    DynamicIntArray array_5(std::move(array_2));

    std::cout << "length: none (nullptr)" << std::endl
              << std::endl;
    
    std::cout << array_2 << std::endl
              << std::endl << array_3 << std::endl
              << std::endl << array_4 << std::endl
              << std::endl << array_5 << std::endl
              << std::endl;

    array_4.Resize(7);
    std::cout << array_4 << std::endl
              << std::endl;

    array_5 = array_4;
    std::cout << array_5 << std::endl
              << std::endl;

    array_4 = std::move(array_5);
    std::cout << array_4 << std::endl
              << std::endl << array_5 << std::endl
              << std::endl;

    DynamicIntArray array_6(array_3);
    if (array_3 == array_6) {
        std::cout << "array_3 == array_6" << std::endl;
    } else {
        std::cout << "array_3 != array_6" << std::endl;
    }

    array_6[0] = 1234;
    std::cout << array_3 << std::endl
              << std::endl << array_6 << std::endl
              << std::endl;
    if (array_3 == array_6) {
        std::cout << "array_3 == array_6" << std::endl;
    } else {
        std::cout << "array_3 != array_6" << std::endl;
    }

    array_6[0] = 1;
    if (array_3 < array_6) {
        std::cout << "array_3 < array_6" << std::endl;
    } else {
        std::cout << "array_3 >= array_6" << std::endl;
    }

    int *array_sum = array_3 + array_4;
    for (size_t i = 0; i < array_3.ArrayLength() + array_4.ArrayLength(); ++i) {
        std::cout << "  array_sum[" << i << "]: " << array_sum[i] << std::endl;
    }

    std::cin >> array_6;

    std::cout << array_6 << std::endl;

    return 0;
}