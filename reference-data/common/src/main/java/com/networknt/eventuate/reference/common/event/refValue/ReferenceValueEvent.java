package com.networknt.eventuate.reference.common.event.refValue;


import com.networknt.eventuate.common.Event;
import com.networknt.eventuate.common.EventEntity;

@EventEntity(entity = "com.networknt.eventuate.reference.domain.ReferenceValueAggregate")
public interface ReferenceValueEvent extends Event {
}
