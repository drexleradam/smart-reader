create table if not exists smart_mock_data (
    id         serial primary key,
    first_name text                  not null,
    last_name  text                  not null,
    age        integer               not null
);
