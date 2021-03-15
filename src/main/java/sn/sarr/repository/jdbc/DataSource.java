package sn.sarr.repository.jdbc;

import java.sql.Connection;

public interface DataSource {
    Connection createConnection();
}
