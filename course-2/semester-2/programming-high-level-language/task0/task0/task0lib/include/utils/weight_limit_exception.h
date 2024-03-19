#ifndef TASK0_TASK0LIB_UTILS_WEIGHT_LIMIT_EXCEPTION_H_
#define TASK0_TASK0LIB_UTILS_WEIGHT_LIMIT_EXCEPTION_H_

#include <iostream>
#include <exception>

class WeightLimitException : public std::exception {
public:
    const char *what() const throw();
};

#endif // TASK0_TASK0LIB_UTILS_WEIGHT_LIMIT_EXCEPTION_H_