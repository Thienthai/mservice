/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.services.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.services.exception.NoSuchGuestbookException;
import com.services.model.Guestbook;
import com.services.model.impl.GuestbookImpl;
import com.services.model.impl.GuestbookModelImpl;
import com.services.service.persistence.GuestbookPersistence;
import com.services.service.persistence.impl.constants.FOOPersistenceConstants;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the guestbook service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = GuestbookPersistence.class)
public class GuestbookPersistenceImpl
	extends BasePersistenceImpl<Guestbook> implements GuestbookPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GuestbookUtil</code> to access the guestbook persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GuestbookImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public GuestbookPersistenceImpl() {
		setModelClass(Guestbook.class);

		setModelImplClass(GuestbookImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the guestbook in the entity cache if it is enabled.
	 *
	 * @param guestbook the guestbook
	 */
	@Override
	public void cacheResult(Guestbook guestbook) {
		entityCache.putResult(
			entityCacheEnabled, GuestbookImpl.class, guestbook.getPrimaryKey(),
			guestbook);

		guestbook.resetOriginalValues();
	}

	/**
	 * Caches the guestbooks in the entity cache if it is enabled.
	 *
	 * @param guestbooks the guestbooks
	 */
	@Override
	public void cacheResult(List<Guestbook> guestbooks) {
		for (Guestbook guestbook : guestbooks) {
			if (entityCache.getResult(
					entityCacheEnabled, GuestbookImpl.class,
					guestbook.getPrimaryKey()) == null) {

				cacheResult(guestbook);
			}
			else {
				guestbook.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all guestbooks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GuestbookImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the guestbook.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Guestbook guestbook) {
		entityCache.removeResult(
			entityCacheEnabled, GuestbookImpl.class, guestbook.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Guestbook> guestbooks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Guestbook guestbook : guestbooks) {
			entityCache.removeResult(
				entityCacheEnabled, GuestbookImpl.class,
				guestbook.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GuestbookImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new guestbook with the primary key. Does not add the guestbook to the database.
	 *
	 * @param myId the primary key for the new guestbook
	 * @return the new guestbook
	 */
	@Override
	public Guestbook create(long myId) {
		Guestbook guestbook = new GuestbookImpl();

		guestbook.setNew(true);
		guestbook.setPrimaryKey(myId);

		return guestbook;
	}

	/**
	 * Removes the guestbook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myId the primary key of the guestbook
	 * @return the guestbook that was removed
	 * @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	 */
	@Override
	public Guestbook remove(long myId) throws NoSuchGuestbookException {
		return remove((Serializable)myId);
	}

	/**
	 * Removes the guestbook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the guestbook
	 * @return the guestbook that was removed
	 * @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	 */
	@Override
	public Guestbook remove(Serializable primaryKey)
		throws NoSuchGuestbookException {

		Session session = null;

		try {
			session = openSession();

			Guestbook guestbook = (Guestbook)session.get(
				GuestbookImpl.class, primaryKey);

			if (guestbook == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGuestbookException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(guestbook);
		}
		catch (NoSuchGuestbookException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Guestbook removeImpl(Guestbook guestbook) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(guestbook)) {
				guestbook = (Guestbook)session.get(
					GuestbookImpl.class, guestbook.getPrimaryKeyObj());
			}

			if (guestbook != null) {
				session.delete(guestbook);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (guestbook != null) {
			clearCache(guestbook);
		}

		return guestbook;
	}

	@Override
	public Guestbook updateImpl(Guestbook guestbook) {
		boolean isNew = guestbook.isNew();

		Session session = null;

		try {
			session = openSession();

			if (guestbook.isNew()) {
				session.save(guestbook);

				guestbook.setNew(false);
			}
			else {
				guestbook = (Guestbook)session.merge(guestbook);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, GuestbookImpl.class, guestbook.getPrimaryKey(),
			guestbook, false);

		guestbook.resetOriginalValues();

		return guestbook;
	}

	/**
	 * Returns the guestbook with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the guestbook
	 * @return the guestbook
	 * @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	 */
	@Override
	public Guestbook findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGuestbookException {

		Guestbook guestbook = fetchByPrimaryKey(primaryKey);

		if (guestbook == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGuestbookException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return guestbook;
	}

	/**
	 * Returns the guestbook with the primary key or throws a <code>NoSuchGuestbookException</code> if it could not be found.
	 *
	 * @param myId the primary key of the guestbook
	 * @return the guestbook
	 * @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	 */
	@Override
	public Guestbook findByPrimaryKey(long myId)
		throws NoSuchGuestbookException {

		return findByPrimaryKey((Serializable)myId);
	}

	/**
	 * Returns the guestbook with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param myId the primary key of the guestbook
	 * @return the guestbook, or <code>null</code> if a guestbook with the primary key could not be found
	 */
	@Override
	public Guestbook fetchByPrimaryKey(long myId) {
		return fetchByPrimaryKey((Serializable)myId);
	}

	/**
	 * Returns all the guestbooks.
	 *
	 * @return the guestbooks
	 */
	@Override
	public List<Guestbook> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guestbooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbooks
	 * @param end the upper bound of the range of guestbooks (not inclusive)
	 * @return the range of guestbooks
	 */
	@Override
	public List<Guestbook> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the guestbooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbooks
	 * @param end the upper bound of the range of guestbooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of guestbooks
	 */
	@Override
	public List<Guestbook> findAll(
		int start, int end, OrderByComparator<Guestbook> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the guestbooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbooks
	 * @param end the upper bound of the range of guestbooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of guestbooks
	 */
	@Override
	public List<Guestbook> findAll(
		int start, int end, OrderByComparator<Guestbook> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Guestbook> list = null;

		if (useFinderCache) {
			list = (List<Guestbook>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GUESTBOOK);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GUESTBOOK;

				sql = sql.concat(GuestbookModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Guestbook>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the guestbooks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Guestbook guestbook : findAll()) {
			remove(guestbook);
		}
	}

	/**
	 * Returns the number of guestbooks.
	 *
	 * @return the number of guestbooks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GUESTBOOK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "myId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GUESTBOOK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GuestbookModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the guestbook persistence.
	 */
	@Activate
	public void activate() {
		GuestbookModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GuestbookModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GuestbookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GuestbookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GuestbookImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.services.model.Guestbook"),
			true);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_GUESTBOOK =
		"SELECT guestbook FROM Guestbook guestbook";

	private static final String _SQL_COUNT_GUESTBOOK =
		"SELECT COUNT(guestbook) FROM Guestbook guestbook";

	private static final String _ORDER_BY_ENTITY_ALIAS = "guestbook.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Guestbook exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		GuestbookPersistenceImpl.class);

	static {
		try {
			Class.forName(FOOPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}