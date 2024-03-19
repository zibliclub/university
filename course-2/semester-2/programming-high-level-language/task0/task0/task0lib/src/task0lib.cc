#include "task0lib.h"

namespace task0 {
    // Box class

    Box::Box(int length, int width, int height, double weight, int value) {
        assert(length > 0);
        assert(width > 0);
        assert(height > 0);
        assert(weight > 0);
        assert(value > 0);

        length_ = length;
        width_ = width;
        height_ = height;
        weight_ = weight;
        value_ = value;
    };

    unsigned Box::length() const { return length_; };
    unsigned Box::width() const { return width_; };
    unsigned Box::height() const { return height_; };
    double Box::weight() const { return weight_; };
    unsigned Box::value() const { return value_; };

    void Box::set_length(int length) {
        assert(length > 0);

        length_ = length;
    };

    void Box::set_width(int width) {
        assert(width > 0);

        width_ = width;
    };

    void Box::set_height(int height) {
        assert(height > 0);

        height_ = height;
    };

    void Box::set_weight(double weight) {
        assert(weight > 0);

        weight_ = weight;
    };

    void Box::set_value(int value) {
        assert(value > 0);

        value_ = value;
    };

    // Box class functions

    std::ostream &operator<<(std::ostream &os, const Box &box) {
        return os << "length: " << box.length() << ", width: " << box.width()
                  << ", height: " << box.height() << ", weight: " << box.weight()
                  << ", value: " << box.value();
    }

    std::istream &operator>>(std::istream &in, Box &box) {
        std::cout << "Enter length, width, height, weight, value for the box: ";

        unsigned length, width, height, value;
        double weight;

        in >> length >> width >> height >> weight >> value;

        box.set_length(length);
        box.set_width(width);
        box.set_height(height);
        box.set_weight(weight);
        box.set_value(value);

        return in;
    }

    // Container class

    Container::Container(
        int length, int width, int height,
        double weight_limit, std::vector<Box> boxes) {
        assert(length > 0);
        assert(width > 0);
        assert(height > 0);
        assert(weight_limit > 0);

        length_ = length;
        width_ = width;
        height_ = height;
        weight_limit_ = weight_limit;
        boxes_ = boxes;
    };

    Container::Container(int length, int width, int height, double weight_limit) {
        assert(length > 0);
        assert(width > 0);
        assert(height > 0);
        assert(weight_limit > 0);

        length_ = length;
        width_ = width;
        height_ = height;
        weight_limit_ = weight_limit;
    };

    int Container::AddBox(Box add_box) {
        if (boxes_.size()) {
            double current_weight = 0;
            for (const Box &box : boxes_) {
                current_weight += box.weight();
            }

            if (current_weight + add_box.weight() > weight_limit_) {
                throw WeightLimitException();
            }
        } else {
            if (add_box.weight() > weight_limit_) {
                throw WeightLimitException();
            }
        }

        boxes_.push_back(add_box);

        return boxes_.size() - 1;
    }

    void Container::DeleteBox(size_t index) {
        assert(index >= 0);
        assert(index < boxes_.size());

        boxes_.erase(boxes_.begin() + index);
    }

    int Container::NumberOfBoxes() {
        return boxes_.size();
    }

    double Container::TotalWeight() {
        double total_weight = 0;
        for (const Box &box : boxes_) {
            total_weight += box.weight();
        }

        return total_weight;
    }

    unsigned Container::TotalValue() {
        unsigned total_value = 0;
        for (const Box &box : boxes_) {
            total_value += box.value();
        }

        return total_value;
    }

    Box &Container::operator[](size_t index) { return boxes_[index]; }

    const Box &Container::operator[](size_t index) const { return boxes_[index]; }

    unsigned Container::length() const { return length_; };
    unsigned Container::width() const { return width_; };
    unsigned Container::height() const { return height_; };
    double Container::weight_limit() const { return weight_limit_; };
    std::vector<Box> Container::boxes() const { return boxes_; }

    void Container::set_length(int length) {
        assert(length > 0);

        length_ = length;
    };

    void Container::set_width(int width) {
        assert(width > 0);

        width_ = width;
    };

    void Container::set_height(int height) {
        assert(height > 0);

        height_ = height;
    };

    void Container::set_weight_limit(double weight_limit) {
        assert(weight_limit > 0);

        weight_limit_ = weight_limit;
    };

    void Container::set_boxes(std::vector<Box> boxes) {
        boxes_ = boxes;
    };

    // Container class functions

    std::ostream &operator<<(std::ostream &os, const Container &container) {
        os << "length: " << container.length() << ", width: " << container.width()
           << ", height: " << container.height() << ", weight limit: "
           << container.weight_limit() << ", boxes:";

        if (container.boxes().size()) {
            for (const Box &box : container.boxes()) {
                os << std::endl
                   << "  " << box;
            }
        } else {
            os << " none";
        }

        return os;
    }

    std::istream &operator>>(std::istream &in, Container &container) {
        unsigned length, width, height, size;
        double weight_limit;
        std::vector<Box> boxes;

        std::cout << "Enter length, width, height, weight limit for the container: ";
        in >> length;
        container.set_length(length);
        in >> width;
        container.set_width(width);
        in >> height;
        container.set_height(height);
        in >> weight_limit;
        container.set_weight_limit(weight_limit);

        std::cout << "How many boxes will the container store: ";
        in >> size;
        assert(size >= 0);
        if (size) {
            Box box(1, 1, 1, 1., 1);
            for (int i = 0; i < size; i++) {
                std::cin >> box;
                boxes.push_back(box);
            }
        }
        container.set_boxes(boxes);

        return in;
    }
}