#!/bin/bash

userName=db_user
databaseName=testdb
tmp=/tmp/sql
PGPASSWORD=postgres

psql -d postgres      -U postgres  -f $tmp/01-create-user.sql
psql -d postgres      -U postgres  -f $tmp/02-create-database.sql
psql -d $databaseName -U $userName -f $tmp/03-create-table.sql
psql -d $databaseName -U $userName -f $tmp/04-insert-data.sql