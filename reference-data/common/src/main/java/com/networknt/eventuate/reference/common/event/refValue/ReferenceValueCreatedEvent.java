package com.networknt.eventuate.reference.common.event.refValue;



import com.networknt.eventuate.reference.common.model.ReferenceValue;


public class ReferenceValueCreatedEvent implements ReferenceValueEvent {

    private String tableId;

    private ReferenceValue referenceValue;

    private ReferenceValueCreatedEvent() {
    }

    public ReferenceValueCreatedEvent(String tableId, ReferenceValue referenceValue) {
        this.tableId = tableId;
        this.referenceValue = referenceValue;
    }

    public String getTableId() {
        return tableId;
    }

    public ReferenceValue getReferenceValue() {
        return referenceValue;
    }

    public void setReferenceValue(ReferenceValue referenceValue) {
        this.referenceValue = referenceValue;
    }
}