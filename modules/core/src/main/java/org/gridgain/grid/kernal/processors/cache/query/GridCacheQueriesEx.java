/* @java.file.header */

/*  _________        _____ __________________        _____
 *  __  ____/___________(_)______  /__  ____/______ ____(_)_______
 *  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
 *  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
 *  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
 */

package org.gridgain.grid.kernal.processors.cache.query;

import org.gridgain.grid.*;
import org.gridgain.grid.cache.query.*;

import java.util.*;

/**
 * Extended queries interface.
 */
public interface GridCacheQueriesEx<K, V> extends GridCacheQueries<K, V> {
    /**
     * Gets SQL metadata.
     *
     * @return SQL metadata.
     * @throws GridException In case of error.
     */
    public Collection<GridCacheSqlMetadata> sqlMetadata() throws GridException;

    /**
     * Creates SQL fields query which will include results metadata if needed.
     *
     * @param qry SQL query.
     * @param incMeta Whether to include results metadata.
     * @return Created query.
     */
    public GridCacheQuery<List<?>> createSqlFieldsQuery(String qry, boolean incMeta);

    /**
     * Creates user's SQL query, queried class, and query clause which is generally
     * a where clause. For more information refer to {@link GridCacheQuery} documentation.
     *
     * @param clsName Query class name.
     * @param clause Query clause.
     * @return Created query.
     */
    public GridCacheQuery<Map.Entry<K, V>> createSqlQuery(String clsName, String clause);

    /**
     * Creates user's full text query, queried class, and query clause.
     * For more information refer to {@link GridCacheQuery} documentation.
     *
     * @param clsName Query class name.
     * @param search Search clause.
     * @return Created query.
     */
    public GridCacheQuery<Map.Entry<K, V>> createFullTextQuery(String clsName, String search);
}
