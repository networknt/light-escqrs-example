
package com.networknt.eventuate.customer.command.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.body.BodyHandler;
import com.networknt.config.Config;
import com.networknt.eventuate.account.command.customer.Customer;
import com.networknt.eventuate.account.command.customer.CustomerService;
import com.networknt.eventuate.account.common.model.customer.CustomerInfo;
import com.networknt.eventuate.account.common.model.customer.CustomerResponse;
import com.networknt.eventuate.account.common.model.customer.ToAccountInfo;
import com.networknt.eventuate.common.AggregateRepository;
import com.networknt.eventuate.common.EventuateAggregateStore;
import com.networknt.service.SingletonServiceFactory;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CustomersToaccountsIdPostHandler implements HttpHandler {

    private EventuateAggregateStore eventStore  = (EventuateAggregateStore) SingletonServiceFactory.getBean(EventuateAggregateStore.class);
    private AggregateRepository customertRepository = new AggregateRepository(Customer.class, eventStore);

    private CustomerService service = new CustomerService(customertRepository);
    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {


        ObjectMapper mapper = new ObjectMapper();

        // add a new object
        Map s = (Map)exchange.getAttachment(BodyHandler.REQUEST_BODY);
        String id = mapper.writeValueAsString(s.get("id"));
        String json = mapper.writeValueAsString(s.get("request"));

        ToAccountInfo toAccountInfo = mapper.readValue(json, ToAccountInfo.class);

        CompletableFuture<String> result = service.addToAccount(id, toAccountInfo).thenApply((e) -> {
            String m =  e.getEntityId();
            return m;
        });

        exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
        exchange.getResponseSender().send(Config.getInstance().getMapper().writeValueAsString(result));
    }
}
