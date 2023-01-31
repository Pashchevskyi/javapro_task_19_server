CREATE schema if not exists server_connection;

-- Создание таблицы
CREATE TABLE IF NOT EXISTS server_connection.active_connection
(
    id integer NOT NULL,
    client_name varchar(30),
    connected_at    timestamp WITHOUT time zone,
    client_socket text NOT NULL,
    primary key (id)
);
