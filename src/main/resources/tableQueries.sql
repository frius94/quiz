CREATE TABLE question
(
    id SERIAL PRIMARY KEY
);

CREATE TABLE option
(
    question_id INT          NOT NULL,
    text        VARCHAR(255) NOT NULL,
    isCorrect   BOOLEAN      NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question (id)
);

CREATE TABLE player
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    score INT DEFAULT 0
);

CREATE ROLE quizuser WITH LOGIN PASSWORD '2851';
GRANT CONNECT ON DATABASE postgres TO quizuser;
GRANT ALL PRIVILEGES ON DATABASE postgres TO quizuser;
GRANT USAGE ON SCHEMA public TO quizuser;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO quizuser;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO quizuser;
GRANT CREATE ON SCHEMA public TO quizuser;
ALTER TABLE player
    OWNER TO quizuser;
ALTER TABLE question
    OWNER TO quizuser;
ALTER TABLE question_options
    OWNER TO quizuser;
