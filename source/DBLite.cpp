#include "DBLite.h"

#include <sqlite3.h>
#include <string>
#include <functional>
#include <stdexcept>

SQLiteDB::SQLiteDB(const std::string& filename) {
    if (sqlite3_open(filename.c_str(), &db) != SQLITE_OK) {
        throw std::runtime_error("Failed to open database: " +
                                 std::string(sqlite3_errmsg(db)));
    }
}

SQLiteDB::~SQLiteDB() {
    if (db) sqlite3_close(db);
}

void SQLiteDB::exec(const std::string& sql) const
{
    char* errMsg = nullptr;
    if (sqlite3_exec(db, sql.c_str(), nullptr, nullptr, &errMsg) != SQLITE_OK) {
        const std::string error = errMsg ? errMsg : "Unknown error";
        sqlite3_free(errMsg);
        throw std::runtime_error("SQLite exec error: " + error);
    }
}

using i = int;

void SQLiteDB::query(const std::string& sql,
                     const std::function<void(i, char**, char**)>& callback) const
{



}

