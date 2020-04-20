package org.odpi.egeria.egeria_connector_hms.repositoryconnector;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.ConnectorType;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryConnectorProviderBase;

public class HMSOMRSRepositoryConnectorProvider extends OMRSRepositoryConnectorProviderBase {

    static final String  connectorTypeGUID = "7b200ca2-655b-4106-917b-abddf2ec3aah";
    static final String  connectorTypeName = "OMRS HMS Repository Connector";
    static final String  connectorTypeDescription = "OMRS HMS Repository Connector that processes events from the HMS repository store.";

    public HMSOMRSRepositoryConnectorProvider() {
        Class connectorClass = HMSOMRSRepositoryConnector.class;
        super.setConnectorClassName(connectorClass.getName());
        ConnectorType connectorType = new ConnectorType();
        connectorType.setType(ConnectorType.getConnectorTypeType());
        connectorType.setGUID(connectorTypeGUID);
        connectorType.setQualifiedName(connectorTypeName);
        connectorType.setDisplayName(connectorTypeName);
        connectorType.setDescription(connectorTypeDescription);
        connectorType.setConnectorProviderClassName(this.getClass().getName());
        super.connectorTypeBean = connectorType;
    }
}
