#include "../../include/utils/box_struct_functions.h"

unsigned TotalValue(Box boxes[], size_t size) {
    assert(boxes != nullptr);
    assert(size >= 0);
    unsigned total_amount = 0;
    for (int i = 0; i < size; i++) {
        total_amount += boxes[i].value;
    }

    return total_amount;
}

bool SumOfParametersNotExceed(Box boxes[], size_t size, unsigned max_sum) {
    assert(boxes != nullptr);
    assert(size >= 0);
    assert(max_sum > 0);
    unsigned sum = 0;
    for (int i = 0; i < size; i++) {
        sum += boxes[i].length + boxes[i].width + boxes[i].height;
    }

    return sum <= max_sum;
}

double MaxWeightForVolumeNotExceed(Box boxes[], size_t size, unsigned max_volume) {
    assert(boxes != nullptr);
    assert(size >= 0);
    assert(max_volume > 0);
    unsigned volume;
    double max_weight = 0;
    for (int i = 0; i < size; i++) {
        volume = boxes[i].length * boxes[i].width * boxes[i].height;
        if (volume <= max_volume) {
            max_weight = fmax(max_weight, boxes[i].weight);
        }
    }

    return max_weight;
}

bool CanPutInEachOther(Box boxes[], size_t size) {
    assert(boxes != nullptr);
    assert(size >= 0);
    for (int i = 0; i < size - 1; i++) {
        for (int j = i + 1; j < size; j++) {
            if (!(BoxesCanBeNested(boxes[i], boxes[j]))) { return false; }
        }
    }

    return true;
}

bool BoxesCanBeNested(const Box &left, const Box &right) {
    return left.length < right.length && left.width < right.width && left.height < right.height ||
           left.length > right.length && left.width > right.width && left.height > right.height;
}

bool operator==(const Box &left, const Box &right) {
    return left.length == right.length &&
           left.width == right.width &&
           left.height == right.height &&
           left.weight == right.weight &&
           left.value == right.value;
}

std::ostream &operator<<(std::ostream &os, const Box &box) {
    return os << "length: " << box.length << ", width: " << box.width
              << ", height: " << box.height << ", weight: " << box.weight
              << ", value: " << box.value;
}

std::istream &operator>>(std::istream &in, Box &box) {
    std::cout << "Enter length, width, height, weight, value for the box: ";

    in >> box.length;
    assert(box.length > 0);
    in >> box.width;
    assert(box.width > 0);
    in >> box.height;
    assert(box.height > 0);
    in >> box.weight;
    assert(box.weight > 0);
    in >> box.value;
    assert(box.value > 0);

    return in;
}