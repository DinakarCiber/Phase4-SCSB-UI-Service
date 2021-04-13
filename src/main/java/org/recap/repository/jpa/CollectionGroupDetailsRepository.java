package org.recap.repository.jpa;

import org.recap.model.jpa.CollectionGroupEntity;

import java.util.List;

/**
 * Created by hemalathas on 22/6/16.
 */
public interface CollectionGroupDetailsRepository extends BaseRepository<CollectionGroupEntity> {

    /**
     * To get the collection group entity based on the collection group code.
     *
     * @param collectionGroupCode the collection group code
     * @return the collection group entity
     */
    CollectionGroupEntity findByCollectionGroupCode(String collectionGroupCode);

    /**
     *
     * @return the list of collection group entity
     */
    List<CollectionGroupEntity> findAll();
}
