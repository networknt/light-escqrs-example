package com.networknt.eventuate.reference;

import com.networknt.eventuate.reference.common.exception.ReferenceDuplicatedException;
import com.networknt.eventuate.reference.common.model.ReferenceTable;
import com.networknt.eventuate.reference.common.model.ReferenceValue;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface ReferenceRepository {

    ReferenceTable saveRefTable(String id, ReferenceTable referenceTable) throws ReferenceDuplicatedException;

    ReferenceValue saveRefValue(String id, ReferenceValue referenceValue);

    int saveRefRelation(String type, String fromValueId, String toValueId);


    List< ReferenceTable> getAllReferences(String host);

    List<String> getAllRefTableNames(String host);

    Optional<ReferenceTable> getReferenceByName(String host, String name);

    Optional<ReferenceTable> getReferenceById( String id);

    List<ReferenceValue> getReferenceValuesById( String id);

    List<String> getAllHosts();

    int deleteRefTable(String id);

    int deleteRefValue(String id);


    ReferenceTable updateRefTable(String id, ReferenceTable referenceTable);

    ReferenceValue updateRefValue(String id, ReferenceValue referenceValue);

    void referenceActive(String id, boolean active);
}
