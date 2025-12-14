cmake_minimum_required(VERSION 3.14)
project(Atlas LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

include(CTest)
enable_testing()

# Core sources
file(GLOB_RECURSE CORE_SOURCES "${CMAKE_SOURCE_DIR}/source/*.cpp")
list(REMOVE_ITEM CORE_SOURCES "${CMAKE_SOURCE_DIR}/source/App.cpp")

add_library(AtlasCore ${CORE_SOURCES})
target_include_directories(AtlasCore PUBLIC ${CMAKE_SOURCE_DIR}/source/include)

# Executable
add_executable(Atlas source/App.cpp)
target_link_libraries(Atlas PRIVATE AtlasCore)

# GTK4 setup
find_package(PkgConfig REQUIRED)
pkg_check_modules(GTK4 REQUIRED gtk4)

target_include_directories(Atlas PRIVATE ${GTK4_INCLUDE_DIRS})
target_link_directories(Atlas PRIVATE ${GTK4_LIBRARY_DIRS})
target_compile_options(Atlas PRIVATE ${GTK4_CFLAGS_OTHER})
target_link_libraries(Atlas PRIVATE ${GTK4_LIBRARIES})

# SQLite setup (system)
find_package(SQLite3 REQUIRED)
target_link_libraries(Atlas PRIVATE SQLite::SQLite3)

set_target_properties(Atlas PROPERTIES
        RUNTIME_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/bin
)

# Add tests
add_subdirectory(tests)
