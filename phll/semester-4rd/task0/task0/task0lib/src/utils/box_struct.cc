#include "../../include/utils/box_struct.h"

Box::Box(
    unsigned length, unsigned width, unsigned height, double weight,
    unsigned value) {
    assert(length > 0);
    assert(width > 0);
    assert(height > 0);
    assert(weight > 0);
    assert(value > 0);

    this->length = length;
    this->width = width;
    this->height = height;
    this->weight = weight;
    this->value = value;
}