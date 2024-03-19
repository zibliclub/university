#include "../../include/utils/weight_limit_exception.h"

const char *WeightLimitException::what() const throw() {
    return "the weight of the box exceeds the permissible limit";
}