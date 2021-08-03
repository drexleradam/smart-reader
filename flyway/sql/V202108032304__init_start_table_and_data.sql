create table if not exists smart_mock_data (
    id         serial primary key,
    first_name text                  not null,
    last_name  text                  not null,
    age        integer               not null
);

insert into smart_mock_data(first_name, last_name, age) values ('Teszt','Elek',30) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Nyom','Réka',21) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Para','Zita',32) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Patta','Nóra',43) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Pár','Zoltán',51) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Pop','Simon',12) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Remek','Elek',35) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Beviz','Elek',8) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Szalmon','Ella',11) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Techno','Kolos',83) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Trab','Antal',92) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Ultra','Viola',43) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Am','Erika',12) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Bac','Ilus',23) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Citad','Ella',31) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Dil','Emma',72) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Eszte','Lenke',81) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Feles','Elek',68) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Füty','Imre',34) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Git','Áron',99) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Har','Mónika',1) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Heu','Réka',52) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Hü','Jenő',44) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Kukor','Ica',22) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Kala','Pál',59) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Külö','Nóra',79) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Körm','Ödön',33) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Kér','Ede',54) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Major','Anna',82) on conflict do nothing;
insert into smart_mock_data(first_name, last_name, age) values ('Meg','Győző',26) on conflict do nothing;
