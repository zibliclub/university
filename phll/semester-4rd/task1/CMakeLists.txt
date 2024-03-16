cmake_minimum_required(VERSION 3.10)

project(task1)

add_executable(MyExecutable task1/task1app/src/task1app.cc)

add_library(MyLibrary
    task1/task1lib/src/task1lib.cc
)

target_include_directories(MyLibrary PUBLIC
    task1/task1lib/include
)

target_link_libraries(MyExecutable PRIVATE MyLibrary)