
package com.networknt.eventuate.reference.handler;

import com.networknt.utility.NioUtils;
import com.networknt.rpc.Handler;
import com.networknt.rpc.router.ServiceHandler;
import java.nio.ByteBuffer;

@ServiceHandler(id="lightapi.net/reference/delete/0.0.1")
public class deleteReference implements Handler {
    @Override
    public ByteBuffer handle(Object input)  {
        return NioUtils.toByteBuffer("{\"message\":\"Hello World!\"}");
    }
}
