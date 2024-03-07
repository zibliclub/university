#include "task0lib.h"

int main() {
    // Functionality check of box_struct_functions

    Box box_struct_1(1, 1, 1, 100., 10000);
    Box box_struct_2(2, 2, 2, 200., 20000);
    Box box_struct_3(52345, 1234, 36424, 12351235., 1234512);

    std::cin >> box_struct_3;

    std::cout << "'box_struct_1' parameters: " << box_struct_1 << std::endl
              << "'box_struct_2' parameters: " << box_struct_2 << std::endl
              << "'box_struct_3' parameters: " << box_struct_3 << std::endl
              << std::endl;

    Box boxes_array[] = {box_struct_1, box_struct_2, box_struct_3};
    size_t size = 3;

    unsigned total_array_value = TotalValue(boxes_array, size);

    const unsigned kSpecifiedValue = 2000;
    std::string sum_of_parameters_not_exceed = SumOfParametersNotExceed(boxes_array, size, kSpecifiedValue) ? "true" : "false";

    const unsigned kMaxVolume = 26;
    double max_weight_for_volume_not_exceed = MaxWeightForVolumeNotExceed(boxes_array, size, kMaxVolume);

    std::string can_put_in_each_other = CanPutInEachOther(boxes_array, size) ? "true" : "false";

    std::string equal = box_struct_1 == box_struct_2 ? "true" : "false";

    std::cout << "Total value of the contents of all boxes: "
              << total_array_value << std::endl
              << "Sum of length, width and height of all boxes does not exceed the specified value: "
              << sum_of_parameters_not_exceed << std::endl
              << "The maximum weight of boxes whose volume is not more than 'kMaxVolume' parameter: "
              << max_weight_for_volume_not_exceed << std::endl
              << "All boxes of the array can be nested one at a time: "
              << can_put_in_each_other << std::endl
              << "Boxes 'box_struct_1' and 'box_struct_2' are equal: "
              << equal << std::endl
              << std::endl;

    // Functionality check of task0 namespace

    task0::Box box_class_1(1, 1, 1, 100., 10000);
    task0::Box box_class_2(2, 2, 2, 200., 20000);
    task0::Box box_class_3(52345, 1234, 36424, 12351235., 1234512);

    std::cin >> box_class_3;

    std::cout << "'box_class_1' parameters: " << box_class_1 << std::endl
              << "'box_class_2' parameters: " << box_class_2 << std::endl
              << "'box_class_3' parameters: " << box_class_3 << std::endl
              << std::endl;

    std::vector<task0::Box> boxes_vector;
    boxes_vector.push_back(box_class_1);
    boxes_vector.push_back(box_class_2);
    boxes_vector.push_back(box_class_3);

    task0::Container container(10, 10, 10, 100000, boxes_vector);

    std::cout << container << std::endl
              << std::endl;

    int number_of_boxes = container.NumberOfBoxes();
    double total_weight = container.TotalWeight();
    unsigned total_container_value = container.TotalValue();

    container[1].set_length(4);
    container[1].set_width(4);
    container[1].set_height(4);
    container[1].set_weight(400.);
    container[1].set_value(40000);

    std::cout << "Number of boxes in container: "
              << number_of_boxes << std::endl
              << "Total weight of container contents: "
              << total_weight << std::endl
              << "Total content value: "
              << total_container_value << std::endl
              << "Box in container by index '1': "
              << container[1] << std::endl
              << "Add a box using 'AddBox()' and get its index: "
              << container.AddBox(box_class_1) << std::endl
              << std::endl;

    task0::Box box_class_4(5, 5, 5, 100001, 50000);
    try {
        container.AddBox(box_class_4);
    } catch(WeightLimitException &e) {
        std::cerr << "Caught exception: " << e.what() << std::endl
                  << std::endl;
    }

    container.DeleteBox(0);

    std::cout << container << std::endl
              << std::endl;

    return 0;
}

// 3 3 3 300 30000