create table if not exists smart_person (
    id         serial primary key,
    first_name text,
    last_name  text,
    age        integer
);