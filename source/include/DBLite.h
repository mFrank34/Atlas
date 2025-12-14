#pragma once
#ifndef DBLITE_H
#define DBLITE_H

#include <sqlite3.h>
#include <string>
#include <functional>

class SQLiteDB {
public:
    explicit SQLiteDB(const std::string& filename);

    ~SQLiteDB();

    void exec(const std::string& sql) const;
    void query(const std::string& sql, const std::function<void(int, char**, char**)>& callback) const;

private:
    sqlite3* db = nullptr;
};
#endif