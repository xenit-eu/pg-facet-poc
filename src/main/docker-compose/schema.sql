CREATE TABLE sampledata (
                                 id serial primary key,
                                 col1 text,
                                 col2 text,
                                 col3 text,
                                 col4 text
);

CREATE EXTENSION faceting;
CREATE MATERIALIZED VIEW col1facets AS SELECT col1, facet.signature(id), now() as updated_at FROM sampledata group by col1;

