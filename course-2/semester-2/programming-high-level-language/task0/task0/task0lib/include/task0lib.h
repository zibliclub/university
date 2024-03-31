#include <iostream>

#include <cassert>
#include <vector>

#include "utils/box_struct_functions.h"
#include "utils/weight_limit_exception.h"

namespace task0 {
    class Box {
    private:
        unsigned length_;
        unsigned width_;
        unsigned height_;
        double weight_;
        unsigned value_;

    public:
        Box(int, int, int, double, int);

        unsigned length() const;
        unsigned width() const;
        unsigned height() const;
        double weight() const;
        unsigned value() const;
        void set_length(int);
        void set_width(int);
        void set_height(int);
        void set_weight(double);
        void set_value(int);
    };

    std::ostream &operator<<(std::ostream &, const Box &);
    std::istream &operator>>(std::istream &, Box &);

    class Container {
    private:
        unsigned length_;
        unsigned width_;
        unsigned height_;
        double weight_limit_;
        std::vector<Box> boxes_;

    public:
        Container(int, int, int, double, std::vector<Box>);
        Container(int, int, int, double);

        int AddBox(Box);
        void DeleteBox(size_t);

        int NumberOfBoxes();
        double TotalWeight();
        unsigned TotalValue();

        Box &operator[](size_t);
        const Box &operator[](size_t) const;

        unsigned length() const;
        unsigned width() const;
        unsigned height() const;
        double weight_limit() const;
        std::vector<Box> boxes() const;
        void set_length(int);
        void set_width(int);
        void set_height(int);
        void set_weight_limit(double);
        void set_boxes(std::vector<Box>);
    };

    std::ostream &operator<<(std::ostream &, const Container &);
    std::istream &operator>>(std::istream &, Container &);
}