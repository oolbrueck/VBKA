package de.VBKA.database;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.codegen.GenerationTool;
import org.jooq.impl.DSL;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

    public static DSLContext db = null;
    public static boolean init() {
        try {
            String url = "jdbc:h2:./h2db";
            String name = "tully";
            String pass = "tully";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

            Connection connection = DriverManager.getConnection(url, name, pass);
            //RunScript.execute(connection, new FileReader("src/main/java/de/VBKA/database/db.sql"));
            db = DSL.using(connection, SQLDialect.H2);
            //DataBase.db.dropTableIfExists("ACCOUNT");
            //var r = DataBase.db.dropTableIfExists("ACCOUNT").execute();
            //RunScript.execute(connection, new FileReader("src/main/java/de/VBKA/database/db.sql"));

//            GenerationTool.generate(
//                    Files.readString(
//                            Path.of("src/main/java/de/VBKA/database/jooq-config.xml")
//                    )
//            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
