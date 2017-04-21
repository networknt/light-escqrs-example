package com.networknt.eventuate.todolist;

import com.networknt.eventuate.common.impl.AggregateCrud;
import com.networknt.exception.ClientException;
import com.networknt.exception.ApiException;
import com.networknt.command.handler.TestCommandServer;
import com.networknt.query.handler.TestQueryServer;
import com.networknt.service.SingletonServiceFactory;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.h2.tools.RunScript;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
* Generated by swagger-codegen
*/
public class TodoTest {

    static final Logger logger = LoggerFactory.getLogger(TodoTest.class);

    public static DataSource ds;

    static {
        ds = (DataSource) SingletonServiceFactory.getBean(DataSource.class);
        try (Connection connection = ds.getConnection()) {
            // Runscript doesn't work need to execute batch here.
            String schemaResourceName = "/embedded-event-store-schema.sql";
            InputStream in = TodoTest.class.getResourceAsStream(schemaResourceName);

            if (in == null) {
                throw new RuntimeException("Failed to load resource: " + schemaResourceName);
            }
            InputStreamReader reader = new InputStreamReader(in);
            RunScript.execute(connection, reader);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private AggregateCrud eventStore = (AggregateCrud)SingletonServiceFactory.getBean(AggregateCrud.class);
    private TodoCommandService service = (TodoCommandService)SingletonServiceFactory.getBean(TodoCommandService.class);

    @Test
    public void testAddTodo() throws Exception {
        Map<String, Object> todo = new HashMap<>();
        todo.put("title", "this is the first todo");
        CompletableFuture<Map<String, Object>> result = service.add(todo).thenApply((e) -> {
            Map<String, Object> m = e.getAggregate().getTodo();
            System.out.println("m = " + m);
            return m;
        });

        System.out.println("result = " + result.get());
    }
}
