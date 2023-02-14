create table hotels (
    id integer PRIMARY KEY AUTOINCREMENT,
    name varchar
);

create table plans (
    id integer PRIMARY KEY AUTOINCREMENT,
    hotel_id integer,
    name varchar,
    period_from date,
    period_to date,
    enable bit,
    -- ここの外部キー制約が動かない
    -- ブラウザで動作確認した時に正常に動かなかった。
    CONSTRAINT fk_plants_id
      FOREIGN KEY (hotel_id) -- 外部キー
      REFERENCES hotels(id)
      ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- なぜだか動かない(原因不明)
-- ALTER TABLE plans ADD FOREIGN KEY (hotel_id) REFERENCES hotels(id);

create table rooms (
    id integer PRIMARY KEY AUTOINCREMENT,
    hotel_id integer,
    name varchar,
    enable bit,
    CONSTRAINT fk_rooms_id
      FOREIGN KEY (hotel_id) -- 外部キー
      REFERENCES hotels(id)
      ON DELETE RESTRICT ON UPDATE RESTRICT
);

create table prices (
    id integer PRIMARY KEY AUTOINCREMENT,
    plan_id integer,
    room_id integer,
    date date,
    price integer,
    CONSTRAINT fk_plan_id
      FOREIGN KEY (plan_id) -- 外部キー
      REFERENCES plans(id)
      ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_room_id
      FOREIGN KEY (room_id) -- 外部キー
      REFERENCES plans(id)
      ON DELETE RESTRICT ON UPDATE RESTRICT
);

create table roomstocks (
    id integer PRIMARY KEY AUTOINCREMENT,
    room_id integer,
    date date,
    amount integer,
    CONSTRAINT fk_room_id
      FOREIGN KEY (room_id) -- 外部キー
      REFERENCES plans(id)
      ON DELETE RESTRICT ON UPDATE RESTRICT
);
