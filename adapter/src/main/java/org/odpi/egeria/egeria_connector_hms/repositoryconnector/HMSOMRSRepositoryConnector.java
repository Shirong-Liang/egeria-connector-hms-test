package org.odpi.egeria.egeria_connector_hms.repositoryconnector;

import org.odpi.openmetadata.frameworks.connectors.properties.ConnectionProperties;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.OMRSMetadataCollection;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryConnector;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.RepositoryErrorException;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
//import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.conf.HiveConf;

public class HMSOMRSRepositoryConnector extends OMRSRepositoryConnector {
	
	protected HiveMetaStoreClient hiveMetaStoreClient;
	private HiveConf hiveConf = new HiveConf();
	
	@Override
    public void initialize(String               connectorInstanceId,
                           ConnectionProperties connectionProperties) {
        super.initialize(connectorInstanceId, connectionProperties);

        final String methodName = "initialize";
        this.hiveMetaStoreClient = new HiveMetaStoreClient(hiveConf);
        //try {
			//connectToHMS();
		//} catch (MetaException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	}
	
	/**
     * {@inheritDoc}
     */
        /*
    @Override
    public OMRSMetadataCollection getMetadataCollection() throws RepositoryErrorException {
        final String methodName = "getMetadataCollection";
        if (metadataCollection == null) {
            // If the metadata collection has not yet been created, attempt to create it now
            try {
                connectToHMS(methodName);
            } catch (MetaException e) {
            	throw 
                raiseException( methodName, e, getServerName());
            }
        }
        return super.getMetadataCollection();
    }
    */
    
    //protected void connectToHMS() throws MetaException   {
    	
    	//this.hiveMetaStoreClient = new HiveMetaStoreClient(hiveConf);
    //}
    //public HiveMetaStoreClient getHiveMetaStoreClient() { return this.hiveMetaStoreClient; }

    public void setMetadataCollectionId(String     metadataCollectionId)
    {
        super.metadataCollectionId = metadataCollectionId;

        if (metadataCollectionId != null)
        {
            /*
             * Initialize the metadata collection only once the connector is properly set up.
             */
            super.metadataCollection = new HMSOMRSMetadataCollection(this,
                                                                          super.serverName,
                                                                          repositoryHelper,
                                                                          repositoryValidator,
                                                                          metadataCollectionId);
        }
    }
}
