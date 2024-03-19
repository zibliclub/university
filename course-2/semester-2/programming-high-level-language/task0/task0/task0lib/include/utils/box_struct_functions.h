#ifndef TASK0_TASK0LIB_UTILS_BOX_STRUCT_FUNCTIONS_H_
#define TASK0_TASK0LIB_UTILS_BOX_STRUCT_FUNCTIONS_H_

#include <iostream>

#include <math.h>

#include "box_struct.h"

unsigned TotalValue(Box[], size_t);
bool SumOfParametersNotExceed(Box[], size_t, unsigned);
double MaxWeightForVolumeNotExceed(Box[], size_t, unsigned);
bool CanPutInEachOther(Box[], size_t);
bool BoxesCanBeNested(const Box &, const Box &);

bool operator==(const Box &, const Box &);
std::ostream &operator<<(std::ostream &, const Box &);
std::istream &operator>>(std::istream &, Box &);

#endif // TASK0_TASK0LIB_UTILS_BOX_STRUCT_FUNCTIONS_H_