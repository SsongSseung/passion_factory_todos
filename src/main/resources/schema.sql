DROP TABLE IF EXISTS TODOS;

CREATE TABLE Todos
(
        id IDENTITY PRIMARY KEY,
        name VARCHAR(255) NOT NULL ,
        completed BOOLEAN DEFAULT FALSE,
        completed_at TIMESTAMP  ,
        created_at TIMESTAMP ,
        UPDATED_AT TIMESTAMP
);