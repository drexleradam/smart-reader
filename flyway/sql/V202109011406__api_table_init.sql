create table if not exists smart_listing_status (
    id integer not null,
    status_name text not null
);

create table if not exists smart_marketplace (
    id integer not null,
    marketplace_name text not null
)