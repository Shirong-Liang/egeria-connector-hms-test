package org.odpi.egeria.egeria_connector_hms.repositoryconnector;

import java.util.Date;
import java.util.List;

//import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.OMRSMetadataCollection;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.OMRSMetadataCollectionBase;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.MatchCriteria;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.SequencingOrder;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Classification;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.EntityDetail;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.EntityProxy;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.EntitySummary;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceGraph;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceProperties;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceProvenanceType;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceStatus;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Relationship;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.AttributeTypeDef;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.AttributeTypeDefCategory;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDef;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefCategory;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefGallery;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefPatch;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefProperties;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefSummary;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryConnector;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryHelper;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryValidator;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.ClassificationErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.EntityConflictException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.EntityNotDeletedException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.EntityNotKnownException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.EntityProxyOnlyException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.FunctionNotSupportedException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.HomeEntityException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.HomeRelationshipException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.InvalidEntityException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.InvalidParameterException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.InvalidRelationshipException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.InvalidTypeDefException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.PagingErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.PatchErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.PropertyErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.RelationshipConflictException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.RelationshipNotDeletedException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.RelationshipNotKnownException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.RepositoryErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.StatusNotSupportedException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.TypeDefConflictException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.TypeDefInUseException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.TypeDefKnownException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.TypeDefNotKnownException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.TypeDefNotSupportedException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.TypeErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.UserNotAuthorizedException;

public class HMSOMRSMetadataCollection extends OMRSMetadataCollectionBase {

	//private HiveMetaStoreClient hiveMetaStoreClient;
	private HMSOMRSRepositoryConnector hmsOMRSRepositoryConnector;
	public HMSOMRSMetadataCollection(HMSOMRSRepositoryConnector parentConnector, String repositoryName,
			OMRSRepositoryHelper repositoryHelper, OMRSRepositoryValidator repositoryValidator,
			String metadataCollectionId) {
		super(parentConnector, repositoryName, repositoryHelper, repositoryValidator, metadataCollectionId);
		// TODO Auto-generated constructor stub
		
		//this.hiveMetaStoreClient = parentConnector.getHiveMetaStoreClient();
        this.hmsOMRSRepositoryConnector = parentConnector;
	}

	@Override
	public TypeDefGallery getAllTypes(String userId)
			throws InvalidParameterException, RepositoryErrorException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDefGallery findTypesByName(String userId, String name)
			throws InvalidParameterException, RepositoryErrorException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeDef> findTypeDefsByCategory(String userId, TypeDefCategory category)
			throws InvalidParameterException, RepositoryErrorException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttributeTypeDef> findAttributeTypeDefsByCategory(String userId, AttributeTypeDefCategory category)
			throws InvalidParameterException, RepositoryErrorException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeDef> findTypeDefsByProperty(String userId, TypeDefProperties matchCriteria)
			throws InvalidParameterException, RepositoryErrorException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeDef> findTypesByExternalID(String userId, String standard, String organization, String identifier)
			throws InvalidParameterException, RepositoryErrorException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeDef> searchForTypeDefs(String userId, String searchCriteria)
			throws InvalidParameterException, RepositoryErrorException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDef getTypeDefByGUID(String userId, String guid) throws InvalidParameterException,
			RepositoryErrorException, TypeDefNotKnownException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeTypeDef getAttributeTypeDefByGUID(String userId, String guid) throws InvalidParameterException,
			RepositoryErrorException, TypeDefNotKnownException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDef getTypeDefByName(String userId, String name) throws InvalidParameterException,
			RepositoryErrorException, TypeDefNotKnownException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeTypeDef getAttributeTypeDefByName(String userId, String name) throws InvalidParameterException,
			RepositoryErrorException, TypeDefNotKnownException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTypeDefGallery(String userId, TypeDefGallery newTypes) throws InvalidParameterException,
			RepositoryErrorException, TypeDefNotSupportedException, TypeDefKnownException, TypeDefConflictException,
			InvalidTypeDefException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTypeDef(String userId, TypeDef newTypeDef) throws InvalidParameterException,
			RepositoryErrorException, TypeDefNotSupportedException, TypeDefKnownException, TypeDefConflictException,
			InvalidTypeDefException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAttributeTypeDef(String userId, AttributeTypeDef newAttributeTypeDef)
			throws InvalidParameterException, RepositoryErrorException, TypeDefNotSupportedException,
			TypeDefKnownException, TypeDefConflictException, InvalidTypeDefException, FunctionNotSupportedException,
			UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean verifyTypeDef(String userId, TypeDef typeDef)
			throws InvalidParameterException, RepositoryErrorException, TypeDefNotSupportedException,
			TypeDefConflictException, InvalidTypeDefException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyAttributeTypeDef(String userId, AttributeTypeDef attributeTypeDef)
			throws InvalidParameterException, RepositoryErrorException, TypeDefNotSupportedException,
			TypeDefConflictException, InvalidTypeDefException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TypeDef updateTypeDef(String userId, TypeDefPatch typeDefPatch)
			throws InvalidParameterException, RepositoryErrorException, TypeDefNotKnownException, PatchErrorException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTypeDef(String userId, String obsoleteTypeDefGUID, String obsoleteTypeDefName)
			throws InvalidParameterException, RepositoryErrorException, TypeDefNotKnownException, TypeDefInUseException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAttributeTypeDef(String userId, String obsoleteTypeDefGUID, String obsoleteTypeDefName)
			throws InvalidParameterException, RepositoryErrorException, TypeDefNotKnownException, TypeDefInUseException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

	@Override
	public TypeDef reIdentifyTypeDef(String userId, String originalTypeDefGUID, String originalTypeDefName,
			String newTypeDefGUID, String newTypeDefName) throws InvalidParameterException, RepositoryErrorException,
			TypeDefNotKnownException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeTypeDef reIdentifyAttributeTypeDef(String userId, String originalAttributeTypeDefGUID,
			String originalAttributeTypeDefName, String newAttributeTypeDefGUID, String newAttributeTypeDefName)
			throws InvalidParameterException, RepositoryErrorException, TypeDefNotKnownException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDetail isEntityKnown(String userId, String guid)
			throws InvalidParameterException, RepositoryErrorException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntitySummary getEntitySummary(String userId, String guid) throws InvalidParameterException,
			RepositoryErrorException, EntityNotKnownException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		//hmsOMRSRepositoryConnector.getRepositoryHelper().getSkeletonEntitySummary(hmsOMRSRepositoryConnector.getRepositoryName(), hmsOMRSRepositoryConnector.getMetadataCollectionId(), InstanceProvenanceType.LOCAL_COHORT, userId, typeName)
		
		EntitySummary summary = new EntitySummary();
		summary.setGUID(guid);
		summary.setCreatedBy("test_hms_user");
		summary.setCreateTime(new Date());
		summary.setUpdatedBy("test_hms_user");
		summary.setUpdateTime(new Date());
		return summary;
	}

	@Override
	public EntityDetail getEntityDetail(String userId, String guid) throws InvalidParameterException,
			RepositoryErrorException, EntityNotKnownException, EntityProxyOnlyException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		
		EntityDetail detail  = null;
		try {
			detail = hmsOMRSRepositoryConnector.getRepositoryHelper().getSkeletonEntity(
			        "sourceName",
			        hmsOMRSRepositoryConnector.getMetadataCollectionId(),
			        InstanceProvenanceType.LOCAL_COHORT,
			        userId,
			        "GlossaryTerm"
			);
			
		} catch (TypeErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detail;

	}

	@Override
	public EntityDetail getEntityDetail(String userId, String guid, Date asOfTime)
			throws InvalidParameterException, RepositoryErrorException, EntityNotKnownException,
			EntityProxyOnlyException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Relationship> getRelationshipsForEntity(String userId, String entityGUID, String relationshipTypeGUID,
			int fromRelationshipElement, List<InstanceStatus> limitResultsByStatus, Date asOfTime,
			String sequencingProperty, SequencingOrder sequencingOrder, int pageSize)
			throws InvalidParameterException, TypeErrorException, RepositoryErrorException, EntityNotKnownException,
			PropertyErrorException, PagingErrorException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntityDetail> findEntitiesByProperty(String userId, String entityTypeGUID,
			InstanceProperties matchProperties, MatchCriteria matchCriteria, int fromEntityElement,
			List<InstanceStatus> limitResultsByStatus, List<String> limitResultsByClassification, Date asOfTime,
			String sequencingProperty, SequencingOrder sequencingOrder, int pageSize)
			throws InvalidParameterException, RepositoryErrorException, TypeErrorException, PropertyErrorException,
			PagingErrorException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntityDetail> findEntitiesByClassification(String userId, String entityTypeGUID,
			String classificationName, InstanceProperties matchClassificationProperties, MatchCriteria matchCriteria,
			int fromEntityElement, List<InstanceStatus> limitResultsByStatus, Date asOfTime, String sequencingProperty,
			SequencingOrder sequencingOrder, int pageSize) throws InvalidParameterException, TypeErrorException,
			RepositoryErrorException, ClassificationErrorException, PropertyErrorException, PagingErrorException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntityDetail> findEntitiesByPropertyValue(String userId, String entityTypeGUID, String searchCriteria,
			int fromEntityElement, List<InstanceStatus> limitResultsByStatus, List<String> limitResultsByClassification,
			Date asOfTime, String sequencingProperty, SequencingOrder sequencingOrder, int pageSize)
			throws InvalidParameterException, TypeErrorException, RepositoryErrorException, PropertyErrorException,
			PagingErrorException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship isRelationshipKnown(String userId, String guid)
			throws InvalidParameterException, RepositoryErrorException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship getRelationship(String userId, String guid) throws InvalidParameterException,
			RepositoryErrorException, RelationshipNotKnownException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship getRelationship(String userId, String guid, Date asOfTime)
			throws InvalidParameterException, RepositoryErrorException, RelationshipNotKnownException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Relationship> findRelationshipsByProperty(String userId, String relationshipTypeGUID,
			InstanceProperties matchProperties, MatchCriteria matchCriteria, int fromRelationshipElement,
			List<InstanceStatus> limitResultsByStatus, Date asOfTime, String sequencingProperty,
			SequencingOrder sequencingOrder, int pageSize)
			throws InvalidParameterException, TypeErrorException, RepositoryErrorException, PropertyErrorException,
			PagingErrorException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Relationship> findRelationshipsByPropertyValue(String userId, String relationshipTypeGUID,
			String searchCriteria, int fromRelationshipElement, List<InstanceStatus> limitResultsByStatus,
			Date asOfTime, String sequencingProperty, SequencingOrder sequencingOrder, int pageSize)
			throws InvalidParameterException, TypeErrorException, RepositoryErrorException, PropertyErrorException,
			PagingErrorException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InstanceGraph getLinkingEntities(String userId, String startEntityGUID, String endEntityGUID,
			List<InstanceStatus> limitResultsByStatus, Date asOfTime)
			throws InvalidParameterException, RepositoryErrorException, EntityNotKnownException, PropertyErrorException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InstanceGraph getEntityNeighborhood(String userId, String entityGUID, List<String> entityTypeGUIDs,
			List<String> relationshipTypeGUIDs, List<InstanceStatus> limitResultsByStatus,
			List<String> limitResultsByClassification, Date asOfTime, int level)
			throws InvalidParameterException, TypeErrorException, RepositoryErrorException, EntityNotKnownException,
			PropertyErrorException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntityDetail> getRelatedEntities(String userId, String startEntityGUID, List<String> entityTypeGUIDs,
			int fromEntityElement, List<InstanceStatus> limitResultsByStatus, List<String> limitResultsByClassification,
			Date asOfTime, String sequencingProperty, SequencingOrder sequencingOrder, int pageSize)
			throws InvalidParameterException, TypeErrorException, RepositoryErrorException, EntityNotKnownException,
			PropertyErrorException, PagingErrorException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDetail addEntity(String userId, String entityTypeGUID, InstanceProperties initialProperties,
			List<Classification> initialClassifications, InstanceStatus initialStatus) throws InvalidParameterException,
			RepositoryErrorException, TypeErrorException, PropertyErrorException, ClassificationErrorException,
			StatusNotSupportedException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEntityProxy(String userId, EntityProxy entityProxy) throws InvalidParameterException,
			RepositoryErrorException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

	@Override
	public EntityDetail updateEntityStatus(String userId, String entityGUID, InstanceStatus newStatus)
			throws InvalidParameterException, RepositoryErrorException, EntityNotKnownException,
			StatusNotSupportedException, UserNotAuthorizedException, FunctionNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDetail updateEntityProperties(String userId, String entityGUID, InstanceProperties properties)
			throws InvalidParameterException, RepositoryErrorException, EntityNotKnownException, PropertyErrorException,
			UserNotAuthorizedException, FunctionNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDetail undoEntityUpdate(String userId, String entityGUID)
			throws InvalidParameterException, RepositoryErrorException, EntityNotKnownException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDetail deleteEntity(String userId, String typeDefGUID, String typeDefName, String obsoleteEntityGUID)
			throws InvalidParameterException, RepositoryErrorException, EntityNotKnownException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void purgeEntity(String userId, String typeDefGUID, String typeDefName, String deletedEntityGUID)
			throws InvalidParameterException, RepositoryErrorException, EntityNotKnownException,
			EntityNotDeletedException, UserNotAuthorizedException, FunctionNotSupportedException {
		// TODO Auto-generated method stub

	}

	@Override
	public EntityDetail restoreEntity(String userId, String deletedEntityGUID)
			throws InvalidParameterException, RepositoryErrorException, EntityNotKnownException,
			EntityNotDeletedException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDetail classifyEntity(String userId, String entityGUID, String classificationName,
			InstanceProperties classificationProperties) throws InvalidParameterException, RepositoryErrorException,
			EntityNotKnownException, ClassificationErrorException, PropertyErrorException, UserNotAuthorizedException,
			FunctionNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDetail declassifyEntity(String userId, String entityGUID, String classificationName)
			throws InvalidParameterException, RepositoryErrorException, EntityNotKnownException,
			ClassificationErrorException, UserNotAuthorizedException, FunctionNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDetail updateEntityClassification(String userId, String entityGUID, String classificationName,
			InstanceProperties properties) throws InvalidParameterException, RepositoryErrorException,
			EntityNotKnownException, ClassificationErrorException, PropertyErrorException, UserNotAuthorizedException,
			FunctionNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship addRelationship(String userId, String relationshipTypeGUID,
			InstanceProperties initialProperties, String entityOneGUID, String entityTwoGUID,
			InstanceStatus initialStatus) throws InvalidParameterException, RepositoryErrorException,
			TypeErrorException, PropertyErrorException, EntityNotKnownException, StatusNotSupportedException,
			UserNotAuthorizedException, FunctionNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship updateRelationshipStatus(String userId, String relationshipGUID, InstanceStatus newStatus)
			throws InvalidParameterException, RepositoryErrorException, RelationshipNotKnownException,
			StatusNotSupportedException, UserNotAuthorizedException, FunctionNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship updateRelationshipProperties(String userId, String relationshipGUID,
			InstanceProperties properties)
			throws InvalidParameterException, RepositoryErrorException, RelationshipNotKnownException,
			PropertyErrorException, UserNotAuthorizedException, FunctionNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship undoRelationshipUpdate(String userId, String relationshipGUID)
			throws InvalidParameterException, RepositoryErrorException, RelationshipNotKnownException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship deleteRelationship(String userId, String typeDefGUID, String typeDefName,
			String obsoleteRelationshipGUID) throws InvalidParameterException, RepositoryErrorException,
			RelationshipNotKnownException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void purgeRelationship(String userId, String typeDefGUID, String typeDefName, String deletedRelationshipGUID)
			throws InvalidParameterException, RepositoryErrorException, RelationshipNotKnownException,
			RelationshipNotDeletedException, UserNotAuthorizedException, FunctionNotSupportedException {
		// TODO Auto-generated method stub

	}

	@Override
	public Relationship restoreRelationship(String userId, String deletedRelationshipGUID)
			throws InvalidParameterException, RepositoryErrorException, RelationshipNotKnownException,
			RelationshipNotDeletedException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDetail reIdentifyEntity(String userId, String typeDefGUID, String typeDefName, String entityGUID,
			String newEntityGUID) throws InvalidParameterException, RepositoryErrorException, EntityNotKnownException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDetail reTypeEntity(String userId, String entityGUID, TypeDefSummary currentTypeDefSummary,
			TypeDefSummary newTypeDefSummary) throws InvalidParameterException, RepositoryErrorException,
			TypeErrorException, PropertyErrorException, ClassificationErrorException, EntityNotKnownException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship reIdentifyRelationship(String userId, String typeDefGUID, String typeDefName,
			String relationshipGUID, String newRelationshipGUID)
			throws InvalidParameterException, RepositoryErrorException, RelationshipNotKnownException,
			FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship reTypeRelationship(String userId, String relationshipGUID, TypeDefSummary currentTypeDefSummary,
			TypeDefSummary newTypeDefSummary)
			throws InvalidParameterException, RepositoryErrorException, TypeErrorException, PropertyErrorException,
			RelationshipNotKnownException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEntityReferenceCopy(String userId, EntityDetail entity) throws InvalidParameterException,
			RepositoryErrorException, TypeErrorException, PropertyErrorException, HomeEntityException,
			EntityConflictException, InvalidEntityException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void purgeEntityReferenceCopy(String userId, String entityGUID, String typeDefGUID, String typeDefName,
			String homeMetadataCollectionId) throws InvalidParameterException, RepositoryErrorException,
			EntityNotKnownException, HomeEntityException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshEntityReferenceCopy(String userId, String entityGUID, String typeDefGUID, String typeDefName,
			String homeMetadataCollectionId) throws InvalidParameterException, RepositoryErrorException,
			EntityNotKnownException, HomeEntityException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveRelationshipReferenceCopy(String userId, Relationship relationship)
			throws InvalidParameterException, RepositoryErrorException, TypeErrorException, EntityNotKnownException,
			PropertyErrorException, HomeRelationshipException, RelationshipConflictException,
			InvalidRelationshipException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void purgeRelationshipReferenceCopy(String userId, String relationshipGUID, String typeDefGUID,
			String typeDefName, String homeMetadataCollectionId)
			throws InvalidParameterException, RepositoryErrorException, RelationshipNotKnownException,
			HomeRelationshipException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshRelationshipReferenceCopy(String userId, String relationshipGUID, String typeDefGUID,
			String typeDefName, String homeMetadataCollectionId)
			throws InvalidParameterException, RepositoryErrorException, RelationshipNotKnownException,
			HomeRelationshipException, FunctionNotSupportedException, UserNotAuthorizedException {
		// TODO Auto-generated method stub

	}

}
