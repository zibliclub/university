#ifndef TASK0_TASK0LIB_UTILS_BOX_STRUCT_H_
#define TASK0_TASK0LIB_UTILS_BOX_STRUCT_H_

#include <cassert>

struct Box {
    unsigned length;
    unsigned width;
    unsigned height;
    double weight;
    unsigned value;

    Box(unsigned, unsigned, unsigned, double, unsigned);
};

#endif // TASK0_TASK0LIB_UTILS_BOX_STRUCT_H_