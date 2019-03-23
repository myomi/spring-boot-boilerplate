-- Project Name : testdb
-- Date/Time    : 2019/03/23 13:33:12
-- Author       : myomi
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
*/

-- 従業員
--* RestoreFromTempTable
create table employees (
  employee_id bigserial not null
  , employee_name text not null
  , version bigint default 1 not null
  , created_at timestamp with time zone not null
  , created_user bigint default 0 not null
  , updated_at timestamp with time zone
  , updated_user bigint
  , constraint employees_PKC primary key (employee_id)
) ;

comment on table employees is '従業員';
comment on column employees.employee_id is '従業員ID';
comment on column employees.employee_name is '従業員名';
comment on column employees.version is 'バージョン';
comment on column employees.created_at is 'データ作成日時';
comment on column employees.created_user is 'データ作成者';
comment on column employees.updated_at is 'データ更新日時';
comment on column employees.updated_user is 'データ更新者';
